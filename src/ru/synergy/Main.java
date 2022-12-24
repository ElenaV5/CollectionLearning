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
    }
}