public enum CardType {
    GRANITE, PARCHMENT, BLADE;

    public static CardType fromText(String text) {
        if (text == null) return null;
        String t = text.trim().toLowerCase();
        if (t.equals("granite") || t.equals("g")) return GRANITE;
        if (t.equals("parchment") || t.equals("p")) return PARCHMENT;
        if (t.equals("blade") || t.equals("b")) return BLADE;
        return null;
    }

    public String display() {
        switch (this) {
            case GRANITE: return "Granite";
            case PARCHMENT: return "Parchment";
            default: return "Blade";
        }
    }
}