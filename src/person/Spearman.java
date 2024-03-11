package person;

/**
 * Класс Копейщик
 */
public class Spearman extends InfantryBase {

    private static final int HEALTH = 1000;
    private static final int POWER = 70;
    private static final int AGILITY = 60;
    private static final int DEFENCE = 10;
    private static final int DISTANCE = 1;

    /**
     * Создание экземпляра Копейщика
     *
     * @param name имя
     * @param priority приоритет хода
     */
    public Spearman(String name, int x, int y)
    {
        super(name, 0, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, x, y);
    }

    @Override
    public String toString() {
        return String.format("[Копейщик] %s", name  + " " + position.toString());
    }

}
