package ru.synergy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        //массивы
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Tomas");
        cats[1] = new Cat("Бегемот");
        cats[2] = new Cat("Дымка");
        cats[3] = new Cat("Белка");

        //cats[1] = null; //[Cat{name='Tomas'}, null, Cat{name='Дымка'}]

        System.out.println(Arrays.toString(cats));
        //[Cat{name='Tomas'}, Cat{name='Бегемот'}, Cat{name='Дымка'}]

        ArrayList<Cat> catsList = new ArrayList();
        for(Cat cat : cats){
            catsList.add(cat);
        }
        catsList.add(new Cat("Гипопотам")); //добавляется только в ArrayList
        System.out.println(catsList.toString());

        catsList.remove(1); //удаление элемента по индексу 1 (Бегемот)
        System.out.println(catsList.toString());

        Cat cat = catsList.get(0);
        System.out.print(cat);
        System.out.println(" Индекс кота: " + catsList.indexOf(cat)); //0

        catsList.add(2, cat); //если поставить индекс больше, чем установлен, то будет ошибка по индексу
        System.out.println(catsList.toString()); //не заменяет, а ставить плюсом

        catsList.set(2, new Cat("Меня сюда вставили")); //заменяет одного кота на другово
        System.out.println(catsList.toString());

        //catsList.removeAll(catsList); //удаление всех элементов списка
        //System.out.println(catsList.toString()); //[]

        catsList.removeAll(Arrays.asList(cat, catsList.get(3))); //удаляет значение массива под индексом 3
        System.out.println(catsList.toString());

        //cats = catsList.toArray(); //вернется лист котов (по сути не используется)

        System.out.println(catsList.size()); // размер листа - 3


    }
}