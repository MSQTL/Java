//Класс Main
package org.example;

import Animals.*;

public class Main {

    public static void main(String[] args) {

        Cat semen = new Cat("Семён");
        System.out.println(semen.run(30));

        Dog charlik = new Dog("Чарлик");
        System.out.println(charlik.swim(10));

        Dog cuma = new Dog("Кума");
        System.out.println(cuma.run(501));

        Cat simka = new Cat("Симка");
        System.out.println(simka.swim(5));
        System.out.println(simka.run(200));

        System.out.printf("""
                Всего создано:
                %d животных
                %d котов
                %d собак""",
                Animal.countAnimal, Cat.countCat, Dog.countDog);
    }
}

//Пакет Животные

//Класс Животное
package Animals;

public abstract class Animal {

    String name;
    public static int countAnimal = 0;
    public Animal(String name){
        this.name = name;
        countAnimal++;
    }
    public abstract String run(int length);
    public abstract String swim(int length);

}

//Класс Собака
package Animals;

public class Dog extends Animal{
    public static int countDog = 0;
    public Dog(String name){
        super(name);
        countDog++;
    }
    @Override
    public String run(int length){
        return length <= 500 ? name + " пробежал(-а) " + length + "м." :
                "Слишком большое препятствие для " + name + "!";
    }
    @Override
    public String swim(int length){
        return length <= 10 ? name + " проплыл(-а) " + length + "м." :
                "Слишком большое препятствие для " + name + "!";
    }
}

//Класс Кот
package Animals;

public class Cat extends  Animal{
    public static int countCat = 0;
    public Cat(String name){
        super(name);
        countCat++;
    }
    @Override
    public String run(int length){
        return length <= 200 ? name + " пробежал(-а) " + length + "м." :
                "Слишком большое препятствие для " + name + "!";
    }
    @Override
    public String swim(int length){
        return name + " не умеет плавать!";
    }
}
