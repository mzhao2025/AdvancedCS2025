public class BattleEngine {
    public static boolean validateStats(Monster monster) {
        if (monster == null) {
            throw new IllegalArgumentException("monster cannot be null");
        }
        if (monster.getHealth() < 0 || monster.getAttack() < 0 || monster.getDefense() < 0 || monster.getSpeed() < 0) {
            return false;
        }
        return monster.getTotalStatSum() <= 250;
    }

    public static boolean validateElement(Monster monster) {
        if (monster == null) {
            throw new IllegalArgumentException("monster cannot be null");
        }

        if (monster.getElement() == ElementType.FIRE 
            || monster.getElement() == ElementType.WATER 
            || monster.getElement() == ElementType.EARTH 
            || monster.getElement() == ElementType.AIR) {
            return true;
        }

        monster.setElement(ElementType.FIRE);
        return false;
    }

    public static void correctStats(Monster monster) {
        if (monster == null) {
            throw new IllegalArgumentException("monster cannot be null");
        }

        if (monster.getHealth() < 0) monster.setHealth(0);
        if (monster.getAttack() < 0) monster.setAttack(0);
        if (monster.getDefense() < 0) monster.setDefense(0);
        if (monster.getSpeed() < 0) monster.setSpeed(0);

        while (monster.getTotalStatSum() > 250) {
            int health = monster.getHealth();
            int attack = monster.getAttack();
            int defense = monster.getDefense();
            int speed = monster.getSpeed();

            if (health >= attack && health >= defense && health >= speed && health > 0) {
                monster.setHealth(health - 1);
            }
            else if (attack >= health && attack >= defense && attack >= speed && attack > 0) {
                monster.setAttack(attack - 1);
            }
            else if (defense >= health && defense >= attack && defense >= speed && defense > 0) {
                monster.setDefense(defense - 1);
            }
            else if (speed > 0) {
                monster.setSpeed(speed - 1);
            }
            else {
                break;
            }
        }
    }

    public static Monster startBattle(Monster monster1, Monster monster2) {
        if (monster1 == null || monster2 == null) {
            throw new IllegalArgumentException("monsters cannot both be null");
        }

        boolean m1ElemValid = validateElement(monster1);
        boolean m2ElemValid = validateElement(monster2);
        
        // don't correct as that is the job of correctStats; if invalid, just make Monster lose
        boolean m1StatsValid = validateStats(monster1); 
        boolean m2StatsValid = validateStats(monster2);

        boolean m1Valid = m1ElemValid && m1StatsValid;
        boolean m2Valid = m2ElemValid && m2StatsValid;

        if (!m1Valid && !m2Valid) {
            return null;
        }
        if (!m1Valid) {
            return monster2;
        }
        if (!m2Valid) {
            return monster1;
        }

        Monster attackerMonster;
        Monster defenderMonster;

        if (monster1.getSpeed() > monster2.getSpeed()) {
            attackerMonster = monster1; 
            defenderMonster = monster2;
        } else if (monster2.getSpeed() > monster1.getSpeed()) {
            attackerMonster = monster2; 
            defenderMonster = monster1;
        } else {
            if (Math.random() < 0.5) { // tie = random
                attackerMonster = monster1; 
                defenderMonster = monster2;
            } else {
                attackerMonster = monster2; 
                defenderMonster = monster1;
            }
        }

        // battle loop
        while (monster1.getHealth() > 0 && monster2.getHealth() > 0) {
            attackerMonster.attack(defenderMonster);
            displayStatus(monster1, monster2);

            if (defenderMonster.getHealth() <= 0) break;

            Monster curMonster = attackerMonster;
            attackerMonster = defenderMonster;
            defenderMonster = curMonster;
        }

        Monster winner = monster1.getHealth() > 0 ? monster1 : monster2;
        System.out.println(winner.getName() + " has WON!!! " + winner.victoryNoise());

        return winner;
    }

    // Print both monsters' current health each turn
    public static void displayStatus(Monster monster, Monster opponent) {
        if (monster == null || opponent == null) {
            throw new IllegalArgumentException("displayStatus: monsters cannot be null");
        }
        System.out.println(monster.getName() + ": " + monster.getHealth()
                + " health vs " + opponent.getName() + ": " + opponent.getHealth() + " health");
    }
}