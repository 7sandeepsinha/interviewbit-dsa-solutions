package org.sandeep.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestClass implements Formula{
    @Override
    public int calculate(int x) {
        return sq(x);
    }

    public static void main(String[] args) {
        Converter<String,Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return Integer.parseInt(from);
            }
        };

        Predicate<Boolean> nonNull = Objects::nonNull;
        System.out.println(nonNull.test(null));


        Converter<String, Integer> converter1 = (from) -> Integer.parseInt(from);

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        Iterator<Integer> i = list.iterator();
        while(i.hasNext()){
            System.out.println(i);
            i.next();
        }

    }
}


@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Person{
    public String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }
}