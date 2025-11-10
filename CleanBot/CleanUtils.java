public class CleanUtils {
    public static int validateCleanlinessLevel(int cleanlinessLevel) {
        if (cleanlinessLevel < 0) {
            return 0;
        } else if (cleanlinessLevel > 10) {
            return 10;
        } else {
            return cleanlinessLevel;
        }
    }

    public static String generateUsername(String name) {
        name = fixName(name);
        name = name.toLowerCase();
        int indexOfFirstSpace = name.indexOf(" ");
        int RANDNUM = (int) (Math.random() * 100) + 1950;
        return "@" 
            + name.substring(0, indexOfFirstSpace) 
            + "_" 
            + name.substring(indexOfFirstSpace + 1) 
            + RANDNUM;
    }

    public static void cleanHome(Home home) {
        home.setCleanlinessLevel(home.getCleanlinessLevel() + 2);
    }

    public static String fixName(String name) {
        name = name.trim();
        int indexOfFirstSpace = name.indexOf(" ");
        int indexOfLastSpace = name.lastIndexOf(" ");
        return name.substring(0, indexOfFirstSpace + 1)
            + name.substring(indexOfLastSpace + 1);
    }
}
