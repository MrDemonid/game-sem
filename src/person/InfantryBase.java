package person;

/**
 * Абстрактный класс Пехота, в данном случае база для Разбойников и Копейщиков,
 * но можно добавить Мечников, Варваров и тд.
 */
public abstract class InfantryBase extends PersonBase {

    protected int level;            // уровень, увеличивается по мере опыта

    /**
     * Конструктор базы Пехоты
     *
     * @param name     Имя
     * @param priority Приоритет хода
     * @param health   Текущее здоровье
     * @param power    Сила
     * @param agility  Ловкость (%). 3 ловкости = 1% к увороту, и 10 ловкости = 1% к критическому удару
     * @param defence  Защита (% к сопротивлению урону)
     * @param distance Дистанция воздействия на другой объект (10 у мага, 1 у крестьянина и тд)
     */
    protected InfantryBase(String name, int priority, int health, int power, int agility, int defence, int distance) {
        super(name, priority, health, power, agility, defence, distance);
        level = 1;
    }

}