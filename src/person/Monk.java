package person;

public class Monk extends Wizard {

    private static final int HEALTH = 600;
    private static final int POWER = 40;
    private static final int AGILITY = 10;
    private static final int DEFENCE = 0;
    private static final int DISTANCE = 8;
    private static final int MANA = 100;

    public Monk(String name, int priority)
    {
        super(name, priority, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, MANA);
    }

    @Override
    public String toString() {
        return String.format("[Монах] %s", name);
    }

}
