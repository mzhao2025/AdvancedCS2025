public class NameOps {
    public static String printMethodCall(String method, String name) {
        return method + "(\"" + name + "\"): ";
    }

    public static String whoIsAwesome(String name) {
        return name + " is awesome!";
    }

    public static int indexOfFirstSpace(String name) {
        return name.indexOf(" ");
    }

    public static int indexOfSecondSpace(String name) {
        int firstSpaceIndex = name.indexOf(" ");
        if (firstSpaceIndex == -1) {
            return -1;
        }
        return name.indexOf(" ", firstSpaceIndex + 1);
    }

    public static String findFirstName(String name) {
        int firstSpaceIndex = name.indexOf(" ");
        if (firstSpaceIndex == -1) {
            return name;
        }
        return name.substring(0, firstSpaceIndex);
    }

    public static String findLastName(String name) {
        int lastSpaceIndex = name.lastIndexOf(" ");
        if (lastSpaceIndex == -1) {
            return "";
        }
        return name.substring(lastSpaceIndex + 1);
    }

    public static String findMiddleName(String name) {
        int firstSpaceIndex = name.indexOf(" ");
        if (firstSpaceIndex == -1) {
            return "";
        }
        int secondSpaceIndex = name.indexOf(" ", firstSpaceIndex + 1);
        if (secondSpaceIndex == -1) {
            return "";
        }
        return name.substring(firstSpaceIndex + 1, secondSpaceIndex);
    }

    public static String generateLastFirstMidInitial(String name) {
        String first = findFirstName(name);
        String middle = findMiddleName(name);
        String last = findLastName(name);

        if (last.isEmpty() && middle.isEmpty()) {
            return first;
        }

        if (middle.isEmpty()) {
            return last + ", " + first;
        }

        return last + ", " + first + " " + middle.charAt(0) + ".";
    }
}
