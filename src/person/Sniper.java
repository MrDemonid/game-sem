package person;

/**
 * Класс Снайпер (лучник)
 */
public class Sniper extends PersonBase {

    private static final int HEALTH = 800;
    private static final int POWER = 30;
    private static final int AGILITY = 30;
    private static final int DEFENCE = 5;
    private static final int DISTANCE = 6;
    private static final int ARROWS = 12;
    private static final int EFFECTIVE_DISTANCE = 4;


    protected int arrows;                       // количество стрел в наличии
    protected int level;                        // уровень (+10% к урону)
    protected int effectiveDistance;            // макс. дальность эффективной стрельбы

    protected Sniper(String name, int priority, int health, int power, int agility, int defence, int distance, int arrows, int effectiveDistance)
    {
        super(name, priority, health, power, agility, defence, distance);
        this.arrows = arrows;
        this.effectiveDistance = effectiveDistance;
        this.level = 1;
    }

    /**
     * Создание экзеспляра снайпера
     * @param name Имя
     * @param priority Приоритет хода
     */
    public Sniper(String name, int priority)
    {
        this(name, priority, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, ARROWS, EFFECTIVE_DISTANCE);
    }


    /**
     * Выбираем цель и атакуем, если есть стрелы
     */
    @Override
    public void action() {

    }

    @Override
    public String toString() {
        return String.format("[Снайпер] %s", name);
    }

}

