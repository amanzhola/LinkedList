package nay.kirill.queue;

import java.util.Objects;

public class Animal {

    private String name;

    Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

}
