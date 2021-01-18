package books.Lesson4;

public class Dog {
    private int size;
    private String name;

    public void setSize(int aSize){
        size = aSize;
    }
    public int getSize(){
        return size;
    }

    public void setName(String aName){
        name = aName;
    }

    public String getName(){
        return name;
    }
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
