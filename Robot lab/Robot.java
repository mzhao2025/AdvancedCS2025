public class Robot {
    private int[] hallway;
    private int position; 
    private boolean isFacingRight;

    public Robot(int[] hallwayToClean, int startingPosition) {
        int[] hallwayFixed = new int[hallwayToClean.length];
        for (int i = 0; i < hallwayToClean.length; i++) {
            hallwayFixed[i] = Math.max(0, hallwayToClean[i]);
        }
        this.hallway = hallwayFixed;

        if (startingPosition < 0) {
            this.position = 0;
        } else if (startingPosition >= hallway.length) {
            this.position = hallway.length - 1;
        } else {
            this.position = startingPosition;
        }

        this.isFacingRight = true;
    }

    public int[] getHallway() {
        return hallway;
    }

    public void setHallway(int[] hallway) {
        int[] hallwayFixed = new int[hallway.length];
        for (int i = 0; i < hallway.length; i++) {
            hallwayFixed[i] = Math.max(0, hallway[i]);
        }
        this.hallway = hallwayFixed;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position < 0) {
            this.position = 0;
        } else if (position >= hallway.length) {
            this.position = hallway.length - 1;
        } else {
            this.position = position;
        }
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean isFacingRight) {
        this.isFacingRight = isFacingRight;
    }

    public boolean isRobotBlockedByWall() {
        return ((isFacingRight && position == hallway.length - 1) || (!isFacingRight && position == 0)); 
    }

    public void move() {

        if (hallway[position] == 1) {
            hallway[position]--;
            // clean + step forward
            if (!isRobotBlockedByWall()) {
                position += isFacingRight ? 1 : -1;
            } else {
                isFacingRight = !isFacingRight;
            }
            return;
        }

        if (hallway[position] > 1) {
            hallway[position]--;
            return;
        }

        // hallway[position] == 0
        if (!isRobotBlockedByWall()) {
            position += isFacingRight ? 1 : -1;
        } else {
            isFacingRight = !isFacingRight;
        }
    }

    public int clearHall() {
        int count = 0;
        while (!hallIsClear()) {
            displayState();
            move();
            count++;
        }
        return count;
    }

    public boolean hallIsClear() {
        for (int item : hallway) {
            if (item != 0) {
                return false;
            }
        }
        return true;
    }

    public void displayState() {
        String hallwayStr = "";
        String robotIndexStr = "";
        for (int i = 0; i < hallway.length; i++) {
            hallwayStr += hallway[i] + " ";
            if (i == position) {
                if (isFacingRight) {
                    robotIndexStr += "> ";
                } else {
                    robotIndexStr += "< ";
                }
            } else {
                robotIndexStr += "  ";
            }
        }
        System.out.println(hallwayStr + "\n" + robotIndexStr);
    }
}
