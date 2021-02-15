package geeks.Lesson10.Example;

import java.util.Objects;

public class Cat {
    String name;
    int age;
    Cat(String isName, int isAge){
        name = isName;
        age = isAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
