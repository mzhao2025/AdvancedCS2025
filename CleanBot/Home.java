public class Home {
    private String address;
    private String ownerName;
    private String username;
    private int cleanlinessLevel;
    private boolean isScheduled;

    public Home(String address, String ownerName, int cleanlinessLevel) {
        this.address = address;
        this.ownerName = CleanUtils.fixName(ownerName);
        this.username = CleanUtils.generateUsername(ownerName);
        this.cleanlinessLevel = CleanUtils.validateCleanlinessLevel(cleanlinessLevel);
        this.isScheduled = false;
    }

    public Home() {
        this.address = "123 Default St";
        this.ownerName = "John Doe";
        this.username = CleanUtils.generateUsername(this.ownerName);
        this.cleanlinessLevel = 5;
        this.isScheduled = false;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = CleanUtils.fixName(ownerName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(int cleanlinessLevel) {
        this.cleanlinessLevel = CleanUtils.validateCleanlinessLevel(cleanlinessLevel);
    }

    public boolean isScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public String toString() {
        if (!isScheduled) {
            return "== ABOUT HOME ==\nAddress: " 
                + address 
                + "\nOwner: " + ownerName 
                + "\nUsername: " + username 
                + "\nCleanliness Level: " + cleanlinessLevel 
                + "\nIs scheduled for cleaning? no";
        }
        return "== ABOUT HOME ==\nAddress: " 
            + address 
            + "\nOwner: " + ownerName 
            + "\nUsername: " + username 
            + "\nCleanliness Level: " + cleanlinessLevel 
            + "\nIs scheduled for cleaning? yes";
    }

    public boolean equals(Home home) {
        return this.address.equals(home.address)
            && this.ownerName.equals(home.ownerName)
            && this.username.equals(home.username)
            && this.cleanlinessLevel == home.cleanlinessLevel
            && this.isScheduled == home.isScheduled;
    }
}