package person;

import java.util.Random;

/**
 * База для персонажей.
 */
public abstract class PersonBase {
    protected static Random rnd;
    static {
        rnd = new Random();
    }

    protected String name;
    protected int priority;                 // приоритет хода
    protected int health;                       // здоровье
    protected final int maxHealth;
    protected final int power;                //
    protected final int agility;                  // ловкость
    protected final int defence;              //
    protected int distance;                 // дистанция воздействия на другой объект

    /**
     * Конструктор базы
     * @param name Имя
     * @param priority Приоритет хода
     * @param health Текущее здоровье
     * @param power Сила
     * @param agility Ловкость (%). 3 ловкости = 1% к увороту, и 10 ловкости = 1% к критическому удару
     * @param defence Защита (% к сопротивлению урону)
     * @param distance Дистанция воздействия на другой объект (10 у мага, 1 у крестьянина и тд)
     */
    protected PersonBase(String name, int priority, int health, int power, int agility, int defence, int distance)
    {
        this.name = name;
        this.priority = priority;
        this.health = health;
        this.maxHealth = health;
        this.power = power;
        this.agility = agility;
        this.defence = defence;
        this.distance = distance;
    }

    /**
     * Лечение персонажа
     * @param health Количество добавляемого здоровья
     */
    public void healed(int health)
    {
        this.health = Math.min(this.health +health, this.maxHealth);
    }

    /**
     * Персонаж принимает урон
     * @param damage Величина урона (конечная будет зависеть от @defence и ловкости)
     * @return Количество действительно нанесенного урона
     */
    public int getDamage(int damage)
    {
        boolean probability = (this.agility/3) >= rnd.nextInt(100);
        if (probability)
            return 0;           // увернулись
        int loss = damage - (this.defence * damage) / 100;
        loss = Math.min(loss, this.health);
        this.health -= loss;
        return loss;
    }

    /**
     * Действие персонажа (ход)
     */
    abstract public void action();


//    @Override
//    public String toString()
//    {
//        return String.format("[%s] %s", this.getClass().getSimpleName(), this.name);
//    }

}
