public interface ElementalAttacks {
    default void attack(Monster opponent) {
        Monster thisMonster = thisMonster();

        if (opponent == null) {
            throw new IllegalArgumentException("attack: opponent cannot be null");
        }
        if (thisMonster.getHealth() <= 0) {
            return;
        }

        if (thisMonster.hasUsedDoubleDown()) {
            if (Math.random() < 0.5) {
                performSingleElementalAttack(1, opponent);
            } else {
                performSingleElementalAttack(2, opponent);
            }
            return;
        }

        double rollAttack = Math.random();
        if (rollAttack < 0.45) {
            performSingleElementalAttack(1, opponent);
        } else if (rollAttack < 0.90) {
            performSingleElementalAttack(2, opponent);
        } else {
            performDoubleDownAttack(opponent);
        }
    }

    // The current monster attacks opponent using attack 1 or 2
    default void performSingleElementalAttack(int attackNumber, Monster opponent) {
        Monster thisMonster = thisMonster();

        if (opponent == null) {
            throw new IllegalArgumentException("the opponent cannot be a null monster");
        }
        if (attackNumber != 1 && attackNumber != 2) {
            throw new IllegalArgumentException("attackNumber must be 1 or 2");
        }

        String attackName;
        ElementType attackType;

        if (attackNumber == 1) {
            attackName = thisMonster.attackNameOne;
            attackType = thisMonster.attackElementOne;
        } else {
            attackName = thisMonster.attackNameTwo;
            attackType = thisMonster.attackElementTwo;
        }

        if (attackType == null) {
            throw new IllegalArgumentException("attackType cannot be null");
        }
        if (opponent.getElement() == null) {
            throw new IllegalArgumentException("opponent element cannot be null");
        }

        double mult = ElementalAttacks.getElementalMultiplier(attackType, opponent.getElement());
        boolean crit = ElementalAttacks.didAttackCrit(thisMonster.getSpeed());

        int baseDamage = thisMonster.getAttack() - (opponent.getDefense() / 2);
        if (baseDamage < 1) baseDamage = 1;

        double dmg = baseDamage * mult;
        if (crit) {
            dmg *= 2.0;
        }
        int finaldamage = (int) Math.max(1, Math.floor(dmg));

        // Apply damage
        opponent.takeDamage(finaldamage);
        if (opponent.getHealth() < 0) {
            opponent.setHealth(0);
        }

        // Print play-by-play
        System.out.print(thisMonster.getName() + " used " + attackName + " (" + attackType + ")! ");

        if (mult == 2.0) {
            System.out.print("It was super effective! ");
        } else if (mult == 0.5) {
            System.out.print("It was at most slightly effective... ");
        }
        if (crit) {
            System.out.print("CRITICAL HIT!!!");
        }

        System.out.println(opponent.getName() + " took " + finaldamage + " damage.");
    }

    default void performDoubleDownAttack(Monster opponent) {
        Monster thisMonster = thisMonster();

        if (opponent == null) {
            throw new IllegalArgumentException("opponent cannot be null");
        }

        if (thisMonster.hasUsedDoubleDown()) {
            System.out.println(thisMonster.getName() + " attempted to Double Down, but it was already used! Turn wasted :) ");
            return;
        }

        System.out.println(thisMonster.getName() + " DOUBLE DOWNS --> uses BOTH attacks!");
        thisMonster.useDoubleDown();

        performSingleElementalAttack(1, opponent);
        if (opponent.getHealth() <= 0) { // if opponent hp is now 0
            return;
        }
        performSingleElementalAttack(2, opponent);
    }

    public static boolean didAttackCrit(int speed) {
        if (speed <= 0) return false;
        if (speed >= 250) return true;
        return Math.random() < (speed / 250.0);
    }

    static boolean isSuperEffectiveAgainst(ElementType attackType, ElementType defenderType) {
        if (attackType == null || defenderType == null) return false;
        return (attackType == ElementType.FIRE && defenderType == ElementType.AIR)
            || (attackType == ElementType.AIR && defenderType == ElementType.EARTH)
            || (attackType == ElementType.EARTH && defenderType == ElementType.WATER)
            || (attackType == ElementType.WATER && defenderType == ElementType.FIRE);
    }

    static double getElementalMultiplier(ElementType attackType, ElementType defenderType) {
        if (attackType == null || defenderType == null) return 1.0;
        if (isSuperEffectiveAgainst(attackType, defenderType)) return 2.0;
        if ((attackType == ElementType.FIRE && (defenderType == ElementType.WATER || defenderType == ElementType.FIRE))
            || (attackType == ElementType.WATER && (defenderType == ElementType.EARTH || defenderType == ElementType.WATER))
            || (attackType == ElementType.EARTH && (defenderType == ElementType.AIR || defenderType == ElementType.EARTH))
            || (attackType == ElementType.AIR && (defenderType == ElementType.FIRE || defenderType == ElementType.AIR)))
            return 0.5;
        return 1.0;
    }

    private Monster thisMonster() {
        if (!(this instanceof Monster)) {
            throw new IllegalStateException("ElementalAttack implementations must be Monsters");
        }
        return (Monster) this;
    }
}