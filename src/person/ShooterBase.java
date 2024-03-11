package person;

import java.util.ArrayList;

/**
 * Базовый класс для стрелков, в данном случае для Снайперов и Арбалетчиков,
 * но можно добавить Мушкетёров или Катапульту :)
 */
public abstract class ShooterBase extends PersonBase {

    protected int ammo;                         // боеприпасов в наличии
    protected int level;                        // уровень (зависит от опыта и даёт увеличение урона)
    protected int effectiveDistance;            // макс. дальность эффективной стрельбы

    /**
     * Конструктор базы Стрелков
     *
     * @param name     Имя
     * @param priority Приоритет хода
     * @param health   Текущее здоровье
     * @param power    Сила
     * @param agility  Ловкость (%). 3 ловкости = 1% к увороту, и 10 ловкости = 1% к критическому удару
     * @param defence  Защита (% к сопротивлению урону)
     * @param distance Дистанция воздействия на другой объект (10 у мага, 1 у крестьянина и тд)
     */
    protected ShooterBase(String name, int priority, int health, int power, int agility, int defence, int distance, int ammo, int effectiveDistance, int x, int y)
    {
        super(name, priority, health, power, agility, defence, distance, x, y);
        this.ammo = ammo;
        this.effectiveDistance = effectiveDistance;
        this.level = 1;
    }

    public PersonBase findNearestEnemy(ArrayList<PersonBase> enemies)
    {
        PersonBase target = null;
        float distance = Integer.MAX_VALUE;

        for (PersonBase p : enemies)
        {
            float n = p.distanceTo(this);
            if (n < distance)
            {
                distance = n;
                target = p;
            }
        }
        return target;
    }

    /**
     * Выбираем цель и атакуем, если есть стрелы
     */
    @Override
    public void action()
    {

    }

}
