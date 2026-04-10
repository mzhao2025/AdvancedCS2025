public class TypeChart {

    // Granite > Blade, Granite < Parchment
    // Parchment > Granite, Parchment < Blade
    // Blade > Parchment, Blade < Granite
    public static double multiplier(CardType attacker, CardType defender) {
        if (attacker == defender) return 1.0;

        if (attacker == CardType.GRANITE && defender == CardType.BLADE) return 2.0;
        if (attacker == CardType.GRANITE && defender == CardType.PARCHMENT) return 0.5;

        if (attacker == CardType.PARCHMENT && defender == CardType.GRANITE) return 2.0;
        if (attacker == CardType.PARCHMENT && defender == CardType.BLADE) return 0.5;

        if (attacker == CardType.BLADE && defender == CardType.PARCHMENT) return 2.0;
        if (attacker == CardType.BLADE && defender == CardType.GRANITE) return 0.5;

        return 1.0;
    }
}