package books.headfirst.Lesson8;

public class MyAnimalList {
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;

    public void add(Animal d){
        if(nextIndex < animals.length){
            animals[nextIndex] = d;
            System.out.println("Animal added in container");
            nextIndex++;
        }
    }
}
