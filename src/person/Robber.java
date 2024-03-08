package person;

/**
 * Класс Разбойник
 */
public class Robber extends PersonBase {
    private static final int HEALTH = 1000;
    private static final int POWER = 80;
    private static final int AGILITY = 10;
    private static final int DEFENCE = 12;
    private static final int DISTANCE = 1;

    protected int level;

    protected Robber(String name, int priority, int health, int power, int agility, int defence, int distance) {
        super(name, priority, health, power, agility, defence, distance);
        this.level = 1;
    }

    public Robber(String name, int priority)
    {
        this(name, priority, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE);
    }


    @Override
    public void action() {

    }

    @Override
    public String toString() {
        return String.format("[Разбойник] %s", name);
    }

}
