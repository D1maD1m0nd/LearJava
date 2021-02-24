package books.headfirst.Lesson4;

public class Dog {
    private int size;
    private String name;

    public int getSize() {
        return size;
    }

    public void setSize(int aSize) {
        size = aSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    void bark(int count) {
        for (int i = 0; i < count; i++) {
            if (size > 10) {
                System.out.println("Auf Auf");
            } else {
                System.out.println("uf uf");
            }
        }
    }
}
