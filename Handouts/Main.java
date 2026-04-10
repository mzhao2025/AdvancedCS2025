import java.util.ArrayList;

public class Main {

    public static ArrayList<Monster> getMonstersForTest() {
        ArrayList<Monster> list = new ArrayList<>();

        Monster chimera = new Chimera( "Chimera",
            ElementType.FIRE,
            50, 50, 10, 140,
            "Pepper Breath", "Deadly Scream",
            ElementType.FIRE, ElementType.AIR
        );

        Monster treaunt = new Treaunt(
            "Treaunt",
            ElementType.EARTH,
            100, 40, 50, 60,
            "Vine Whip", "Air Slash",
            ElementType.EARTH, ElementType.AIR
        );
        list.add(chimera);
        list.add(treaunt);
        
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Monster> monsters = getMonstersForTest();
        Monster winner = BattleEngine.startBattle(monsters.get(0), monsters.get(1));

        System.out.println("Winner: " + (winner != null ? winner.getName() : "None"));
        
    }
}