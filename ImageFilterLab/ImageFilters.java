import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageFilters {
    public static void main(String[] args) {
        try {
            BufferedImage image;
    
            // test invert colors
            image = loadFile("images/landscape.jpg");
            invertColors(image);
            saveFile("images/edited-invert-landscape.jpg", image);
    
            // test grayscale by average
            image = loadFile("images/landscape.jpg");
            grayScaleByAverage(image);
            saveFile("images/edited-grayscale-landscape.jpg", image);
    
            // test sepia
            image = loadFile("images/landscape.jpg");
            sepia(image);
            saveFile("images/edited-sepia-landscape.jpg", image);
    
            // test valencia
            image = loadFile("images/landscape.jpg");
            valencia(image);
            saveFile("images/edited-valencia-landscape.jpg", image);
    
            // test left mirror
            image = loadFile("images/landscape.jpg");
            leftMirror(image);
            saveFile("images/edited-left-mirror-landscape.jpg", image);
    
            // test right mirror
            image = loadFile("images/landscape.jpg");
            rightMirror(image);
            saveFile("images/edited-right-mirror-landscape.jpg", image);
    
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // helper methods
    // This method searches the folder path to the target image and returns a BufferedImage object
    // using the data from the file
    public static BufferedImage loadFile(String pathToImage) throws IOException {
        // Load an image file
        File inputFile = new File(pathToImage);
        BufferedImage image = ImageIO.read(inputFile);
        return image;
    }

    // This method creates a new JPG file at the target save location, and copies the data from the
    // BufferedImage object to the file.
    public static void saveFile(String saveLocation, BufferedImage image) throws IOException {
        // Save the edited image
        File outputFile = new File(saveLocation);
        outputFile.createNewFile();
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Image color changed and saved successfully!");
    }

    // filter methods

    // invert colors
    public static void invertColors(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

               // grab the RGB color values of an individual pixel
                int pixel = image.getRGB(x, y);

                // create a Color obj using the RGB values of the pixel as a starting point 
                Color color = new Color(pixel, true);

                // modify the RGB values of the color 
                // the code below inverts colors 
                color = new Color(255 - color.getRed(), 255 - color.getGreen(),
                        255 - color.getBlue());

                // update the pixel's color to the new color 
                // this code directly modifies the BufferedImage
                image.setRGB(x, y, color.getRGB());
            }
        }

    }

    public static void grayScaleByAverage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
    
                int avg = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
    
                color = new Color(avg, avg, avg);
                image.setRGB(x, y, color.getRGB());
            }
        }
    }

    public static void sepia(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // loop across the height and width of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
                int lum = (int) (0.3 * color.getRed() + 0.59 * color.getGreen() + 0.11 * color.getBlue());
                color = new Color(lum, lum, lum);
                image.setRGB(x, y, color.getRGB());
            }
        }
    }

    public static int applyValenciaWeight(int value) {
        if (value <= 62) {
            // shadow range: 0–62
            return (int)(value * 1.1);
        } else if (value <= 192) {
            // midtone range: 63–192
            return (int)(value * 1.0);
        } else {
            // highlight range: 193–255
            return (int)(value * 0.9);
        }
    }

    public static void valencia(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
    
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);
    
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
    
                red = red + 15;
                green = green + 15;

                red = applyValenciaWeight(red);
                green = applyValenciaWeight(green);
                blue = applyValenciaWeight(blue);
    
                // make sure values stay between 0 and 255
                red = Math.min(255, red);
                green = Math.min(255, green);
                blue = Math.min(255, blue);
    
                color = new Color(red, green, blue);
                image.setRGB(x, y, color.getRGB());
            }
        }
    }

    public static void leftMirror(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();
    
        // loop across the height and only the LEFT half of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                int pixel = image.getRGB(x, y);
                int mirrorX = width - 1 - x;
                image.setRGB(mirrorX, y, pixel);
            }
        }
    }

    public static void rightMirror(BufferedImage image) {
        // grab the dimensions
        int width = image.getWidth();
        int height = image.getHeight();
    
        // loop across the height and only the RIGHT half of the image
        for (int y = 0; y < height; y++) {
            for (int x = width / 2; x < width; x++) {
    
                // grab the RGB color values of a pixel on the right side
                int pixel = image.getRGB(x, y);
    
                // find the matching pixel on the left side
                int mirrorX = width - 1 - x;
    
                // copy the right pixel's color onto the left side
                image.setRGB(mirrorX, y, pixel);
            }
        }
    }
}
