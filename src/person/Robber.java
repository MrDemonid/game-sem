package person;

/**
 * Класс Разбойник
 */
public class Robber extends InfantryBase {

    private static final int HEALTH = 1000;
    private static final int POWER = 80;
    private static final int AGILITY = 10;
    private static final int DEFENCE = 12;
    private static final int DISTANCE = 1;

    /**
     * Создание экземпляра Разбойника
     *
     * @param name имя
     * @param priority приоритет хода
     */
    public Robber(String name, int x, int y)
    {
        super(name, 0, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, x, y);
    }


    @Override
    public String toString() {
        return String.format("[Разбойник] %s", name  + " " + position.toString());
    }

}
