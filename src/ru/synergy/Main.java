package ru.synergy;

import java.lang.reflect.Array;
import java.util.*;

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
        catsList.add(new Cat("Гипопотам"));

        //LinkedList
        String str1 = new String("Hello World");
        String str2 = new String("My name is Elena");
        String str3 = new String("I love Java");

        LinkedList<String> elenaBio = new LinkedList();
        elenaBio.add(str1);
        elenaBio.add(str2);
        elenaBio.add(str3);

        System.out.println(elenaBio); //[Hello World, My name is Elena, I love Java]

        elenaBio.remove(); //удаляет первое значение
        System.out.println(elenaBio);
        elenaBio.remove(1); //удаляет значение с индексом 1
        System.out.println(elenaBio);

        //LikedList on practice:
        LinkedList<Car> cars = new LinkedList<>();
        Car ferrari = new Car("Ferrari Spider");
        Car bugatti = new Car("Bugatti Veyron");
        Car mercedes = new Car("Mercedes Benz");

        cars.addAll(Arrays.asList(ferrari, bugatti, mercedes));
        System.out.println(cars);

        cars.addFirst(new Car ("Ford GT300")); //ресурсоемкая операция в массивах
        System.out.println(cars); //добавится в начало массива

        cars.addLast(new Car("Fiat S400")); //дабавление в конец массива
        System.out.println(cars);

        System.out.println(cars.pollFirst()); //операция вытаскивание из массива
        System.out.println(cars); //выводится без первого элемента

        System.out.println(cars.pollLast()); //операция вытаскивание из массива
        System.out.println(cars); //выводится без последнего элемента

        //cars.toArray(); //получаем объекты!

        //ArrayList vs LinkedList - замерим время работы обоих листов
/*        List<Integer> list = new LinkedList();
        for(int i = 0; i < 5000000; i++){
            list.add(new Integer(i));
        }
        long start = System.currentTimeMillis();
        for(int i=0; i < 100; i++){
            list.add(2000000, Integer.MAX_VALUE);
        }
        System.out.println("Время работы для LinkedList (миллисекунды): " + (System.currentTimeMillis() - start));
        //2523

        list = new ArrayList<>();
        for(int i = 0; i < 5000000; i++){
            list.add(new Integer(i));
        }
        start = System.currentTimeMillis();
        for(int i=0; i < 100; i++){
            list.add(2000000, Integer.MAX_VALUE);
        }
        System.out.println("Время работы для ArrayList (миллисекунды): " + (System.currentTimeMillis() - start));
        //2344
*/
        //set - коллекции
        Set<String> states = new HashSet<>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        boolean isAdded = states.add("Italy"); //добавим страну еще раз
        System.out.println("Is the 2nd Italy added: " + isAdded);
        System.out.println("Set contains: " + states.size());
        System.out.println(states);
        states.add("Russia");
        System.out.println(states);
        states.remove("Germany"); //удаление объекта
        System.out.println(states);

        HashSet<Cat> catsHashSet = new HashSet<>(catsList); //выводит лист с котами
        System.out.println(catsHashSet);

        TreeSet<Cat> catTreeSet = new TreeSet(catsList);
        System.out.println(catTreeSet); //сортирует по алфавиту

        //Map-коллекции
        Map<Integer, String> stateMap = new HashMap<>();
        stateMap.clear(); //очищает коллекцию
        stateMap.put(1, "Germany");
        stateMap.put(2, "Spain");
        stateMap.put(3, "Italy");
        stateMap.put(4, "France");
        String first = stateMap.get(2); //выводит значение под 2 ключом
        System.out.println(first);
        System.out.println(stateMap.keySet()); //выводит ключи коллекции
        stateMap.remove(2); //удаление по ключу
        stateMap.remove(3, "Itali"); //не удалит, если или ключ или значение не совпадают
        for(Map.Entry<Integer, String> item : stateMap.entrySet()){
            System.out.printf("Key: %d | Value: %s \n", item.getKey(), item.getValue());
        } //выводит все строки коллекции

    }
}