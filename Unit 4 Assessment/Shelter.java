import java.util.ArrayList;

public class Shelter {
    // instance variables
    private Dog[][] kennels;

    // constructors
    public Shelter(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns cannot be negative!");
        } else {
            kennels = new Dog[rows][cols];
        }
    }

    /* initializes kennels as a 3x3 2D array */
    public Shelter() {
        kennels = new Dog[3][3];
    }

    // getters and setters
    public Dog[][] getKennels() {
        return kennels;
    }

    public void setKennels(Dog[][] kennels) {
        this.kennels = kennels;
    }

    // methods

    /*
     * prints out the 2D array 'kennels', displaying the dog's info if the kennel is occupied, or
     * 'empty' if the kennel is empty
     */
    public void displayStatus() {
        for (Dog[] row : kennels) {
            for (Dog animal : row) {
                if (animal != null) {
                    System.out.print(animal);
                } else {
                    System.out.print("[Empty]");
                }
            }
            System.out.println();
        }
    }

    public void add(Dog animal) {
        if (kennels == null) {
            throw new IllegalArgumentException("Row and columsn cannot be negative!");
        }
        for (int i = 0; i < kennels.length; i++) {
            for (int j = 0; j < kennels[i].length; j++) {
                if (kennels[i][j] == null) {
                    kennels[i][j] = animal;
                    return;
                }
            }
        }
    }

    public void add(Dog animal, int row, int col) {
        if ((kennels == null) || (row < 0) || (row >= kennels.length) 
            || (col < 0) || (col >= kennels[row].length) 
            || (animal == null)) {
            throw new IllegalArgumentException("Row and columsn cannot be negative!");
        }
        if (kennels[row][col] == null) {
            kennels[row][col] = animal;
        } else {
            add(animal);
        }
    }

    public void add(ArrayList<Dog> animals) {
        if (kennels == null || animals == null) {
            throw new IllegalArgumentException("Row and columsn cannot be negative!");
        }

        for (Dog animal : animals) {
            add(animal);
            if (kennels[kennels.length - 1][kennels[kennels.length - 1].length - 1] != null) {
                System.out.println("No empty kennels.");
                break;
            }
        }
    }

    public Dog adopt(int row, int col) {
        if ((kennels == null) || (row < 0) || (row >= kennels.length) 
            || (col < 0) || (col >= kennels[row].length) 
            || (kennels[row][col] == null)) {
            throw new IllegalArgumentException("Row and columsn cannot be negative!");
        }
        Dog adoptedDog = kennels[row][col];
        kennels[row][col] = null;
        return adoptedDog;
    }

    public ArrayList<Dog> search(String name) {
        if ((kennels == null) || (name == null)) {
            return new ArrayList<Dog>();
        }

        ArrayList<Dog> matchingDogs = new ArrayList<Dog>();
        for (Dog[] row : kennels) {
            for (Dog dog : row) {
                if (dog.getName().equals(name) && (dog != null) 
                    && (!matchingDogs.contains(dog))) {
                    matchingDogs.add(dog);
                }
            }
        }
        return matchingDogs;
    }

    public ArrayList<Dog> search(int age) {
        if (kennels == null) {
            return new ArrayList<Dog>();
        }

        ArrayList<Dog> matchingDogs = new ArrayList<Dog>();
        for (Dog[] row : kennels) {
            for (Dog dog : row) {
                if ((dog.getAge() == age) && (dog != null)) {
                    matchingDogs.add(dog);
                }
            }
        }
        return matchingDogs;
    }
}
