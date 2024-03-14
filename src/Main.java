/*
Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников.
Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

Добавить в абстрактный класс int поле инициатива. В классах наследников инициализировать это поле.
Крестьянин = 0, маги=1, пехота=2, лучники=3.
В мэйне сделать так, чтобы сначала делали ход персонажи с наивысшей инициативой
из обеих комманд а с наименьшей в конце.
*/

import behavior.CoordXY;
import behavior.HeroesNames;
import person.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    static ArrayList<PersonBase> red = new ArrayList<>();
    static ArrayList<PersonBase> blue = new ArrayList<>();
    static ArrayList<PersonBase> all = new ArrayList<>();

    public static void main(String[] args) {
        createTeam(red, 10, 0);
        createTeam(blue, 10, 3);
        all.addAll(red);
        all.addAll(blue);
//        all.sort(new PrioritySort());
        all.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));

        for (PersonBase p : all)
        {
            System.out.println(p + " ходит.");
            if (red.contains(p))
            {
//                if (p.getClass().getSimpleName().equals("Wizard"))
//                {
//                    ...
//                }
                p.step(blue);

            } else {
                p.step(red);
            }
        }

    }


    public static void createTeam(ArrayList<PersonBase> team, int num, int start)
    {
        Random rnd = new Random();
        while (--num >= 0)
        {
            int n = start + rnd.nextInt(4);
            switch (n)
            {
                case 0:
                    team.add(new Crossbowman(HeroesNames.getRandomName(), new CoordXY(0, num)));
                    break;
                case 1:
                    team.add(new Spearman(HeroesNames.getRandomName(), new CoordXY(0, num)));
                    break;
                case 2:
                    team.add(new Wizard(HeroesNames.getRandomName(), new CoordXY(0, num)));
                    break;
                case 3:
                    team.add(new Peasant(HeroesNames.getRandomName(), new CoordXY(start*3, num)));
                    break;
                case 4:
                    team.add(new Sniper(HeroesNames.getRandomName(), new CoordXY(9, num)));
                    break;
                case 5:
                    team.add(new Monk(HeroesNames.getRandomName(), new CoordXY(9, num)));
                    break;
                case 6:
                    team.add(new Robber(HeroesNames.getRandomName(), new CoordXY(9, num)));
                    break;
                default:
                    System.out.println("ERROR! Пересмотри алгоритм, ламер!");
            }
        }
    }

}