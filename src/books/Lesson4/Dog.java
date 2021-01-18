package books.Lesson4;

public class Dog {
    int size;
    String name;
    void bark(int count){
        for (int i = 0; i < count ; i++) {
            if(size > 10){
                System.out.println("Auf Auf");
            }else{
                System.out.println("uf uf");
            }
        }
    }
}
