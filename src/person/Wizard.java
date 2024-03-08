package person;

/**
 * Класс Колдун
 */
public class Wizard extends PersonBase {

    private static final int HEALTH = 600;
    private static final int POWER = 40;
    private static final int AGILITY = 10;
    private static final int DEFENCE = 0;
    private static final int DISTANCE = 8;
    private static final int MANA = 100;

    protected int mana;
    protected int maxMana;

    protected Wizard(String name, int priority, int health, int power, int agility, int defence, int distance, int mana)
    {
        super(name, priority, health, power, agility, defence, distance);
        this.mana = mana;
        this.maxMana = mana;
    }

    public Wizard(String name, int priority)
    {
        this(name, priority, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, MANA);
    }


    @Override
    public void action() {

    }

    @Override
    public String toString() {
        return String.format("[Колдун] %s", name);
    }

}
