public class TheaterMember {
    private String name;
    private boolean[] loyaltyCredits;

    public TheaterMember(String name) {
        this.name = name;
        this.loyaltyCredits = new boolean[10];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean[] getLoyaltyCredits() {
        return loyaltyCredits;
    }

    public void setLoyaltyCredits(boolean[] loyaltyCredits) {
        this.loyaltyCredits = loyaltyCredits;
    }

    public void grantLoyaltyCredit() {
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (!loyaltyCredits[i]) {
                loyaltyCredits[i] = true;
                break;
            }
        }
    }

    public int countLoyaltyCredits() {
        int count = 0;
        for (boolean credit : loyaltyCredits) {
            if (credit) {
                count++;
            }
        }
        return count;
    }

    public String determineMembershipStatus() {
        int credits = countLoyaltyCredits();
        if (credits >= 6) {
            return "Gold Member";
        } else if (credits >= 3) {
            return "Silver Member";
        } else {
            return "Plus Member";
        }
    }

    public String loyaltyHistory() {
        String history = "[";
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i]) {
                history += "X";
            } else {
                history += "-";
            }
            if (i < loyaltyCredits.length - 1) {
                history += ", ";
            }
        }
        history += "]";
        return history;
    }

    public String toString() {
        return name + " (" + determineMembershipStatus()
                + "), Loyalty History: " + loyaltyHistory();
    }

    public boolean equals(TheaterMember other) {
        if (!this.name.equals(other.name)) {
            return false;
        }
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] != other.loyaltyCredits[i]) {
                return false;
            }
        }
        return true;
    }
}
