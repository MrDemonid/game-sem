package controller;/*
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
import view.View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static ArrayList<PersonBase> red = new ArrayList<>();
    public static ArrayList<PersonBase> blue = new ArrayList<>();
    public static ArrayList<PersonBase> all = new ArrayList<>();

    public static void main(String[] args) {
        createTeam(red, 10, 0);
        createTeam(blue, 10, 3);
        all.addAll(blue);
        all.addAll(red);
//        all.sort(new PrioritySort());
        all.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));

//        for (int i = 0; i < 30; i++) {
        Scanner in = new Scanner(System.in);
        while (true)
          {
            View.view();
            for (PersonBase p : all) {
//                System.out.print(p + " ходит. ");
                if (red.contains(p)) {
                    p.step(blue, red);

                } else {
                    p.step(red, blue);
                }
//                System.out.println();
            }
            in.nextLine();
            if (!isLiving(red))
            {
                System.out.println("Blue wins!");
                break;
            }
            if (!isLiving(blue))
            {
                System.out.println("Red wins!");
                break;
            }

        }

    }

    private static boolean isLiving(ArrayList<PersonBase> team)
    {
        for (PersonBase personBase : team) {
            if (personBase.getHealth() > 0)
                return true;
        }
        return false;
    }

    public static void createTeam(ArrayList<PersonBase> team, int num, int start)
    {
        Random rnd = new Random();
        int cy = 1;
        while (num-- > 0)
        {
            int n = start + rnd.nextInt(4);
            switch (n)
            {
                case 0:
                    team.add(new Crossbowman(HeroesNames.getRandomName(), new CoordXY(1, cy)));
                    break;
                case 1:
                    team.add(new Spearman(HeroesNames.getRandomName(), new CoordXY(1, cy)));
                    break;
                case 2:
                    team.add(new Wizard(HeroesNames.getRandomName(), new CoordXY(1, cy)));
                    break;
                case 3:
                    team.add(new Peasant(HeroesNames.getRandomName(), new CoordXY(start*3+1, cy)));
                    break;
                case 4:
                    team.add(new Sniper(HeroesNames.getRandomName(), new CoordXY(10, cy)));
                    break;
                case 5:
                    team.add(new Monk(HeroesNames.getRandomName(), new CoordXY(10, cy)));
                    break;
                case 6:
                    team.add(new Robber(HeroesNames.getRandomName(), new CoordXY(10, cy)));
                    break;
                default:
                    System.out.println("ERROR! Пересмотри алгоритм, ламер!");
            }
            cy++;
        }
    }

}