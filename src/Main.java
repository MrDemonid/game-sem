/*
Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников.
Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.
*/

import person.*;

public class Main {
    public static void main(String[] args) {
        PersonBase peasant = new Peasant("Garry", 1);
        PersonBase sniper = new Sniper("Tom", 2);
        PersonBase crossbowman = new Crossbowman("Sam", 2);
        PersonBase robber = new Robber("Sam", 3);
        PersonBase spearman = new Spearman("Bob", 4);
        PersonBase wizard = new Wizard("Robert", 5);
        PersonBase monk = new Monk("Pedro", 5);

        System.out.println(peasant);
        System.out.println(sniper);
        System.out.println(crossbowman);
        System.out.println(robber);
        System.out.println(spearman);
        System.out.println(wizard);
        System.out.println(monk);
    }
}