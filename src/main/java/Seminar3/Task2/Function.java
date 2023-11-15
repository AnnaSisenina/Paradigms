package Seminar3.Task2;

import java.util.ArrayList;

public class Function {
    public static void main(String[] args) {
    ArrayList<Person> persons = new ArrayList<>();
    persons.add(new Person("Ivan", 30));
    persons.add(new Person("Petr", 20));
    persons.add(new Person("Petr", 35));
    System.out.println(count(persons, 19));
    }


    public static long count(ArrayList<Person> members, int age) {
        return members.stream().filter(person -> (person.age > age)).count();

    }
}

