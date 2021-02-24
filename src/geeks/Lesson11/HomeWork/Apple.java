package geeks.Lesson11.HomeWork;

public class Apple extends Fruit {
    public Apple() {
        super(1.0f);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // 1
        if (this == obj) {
            return true;
        }

        // 2
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 3
        Apple simpson = (Apple) obj;
        return getWeight() == simpson.getWeight();
    }
}
