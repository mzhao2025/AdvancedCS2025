public class Tester {
    public static void main(String[] args) {
        Monster chimera = new Chimera("Chimera", ElementType.FIRE, 100, 50, 50, 50, 
            "Flame Breath", "Tail Swipe", ElementType.FIRE, ElementType.EARTH);
        Monster treaunt = new Treaunt("Treaunt", ElementType.WATER, 80, 60, 40, 70,
            "Water Blast", "Tackle", ElementType.WATER, ElementType.AIR);

        BattleEngine.validateStats(chimera);
        BattleEngine.validateElement(chimera);
        BattleEngine.correctStats(chimera);

        BattleEngine.validateStats(treaunt);
        BattleEngine.validateElement(treaunt);
        BattleEngine.correctStats(treaunt);

        BattleEngine.startBattle(chimera, treaunt);
    }
}
