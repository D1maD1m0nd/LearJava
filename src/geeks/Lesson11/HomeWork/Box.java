package geeks.Lesson11.HomeWork;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private final ArrayList<T> value = new ArrayList<>();

    public float getWeight(){
        if(value.size() == 0){
            return 0.0F;
        }
        return value.size() * value.get(0).getWeight();
    };

    public ArrayList<T> getValue() {
        return value;
    }
    public void add(T fruit){
        value.add(fruit);
    }
    public boolean compare(Box<?> box){
        return box.getWeight() == this.getWeight();
    }
    public void fill(Box<T> fruits){
        if(fruits.getValue().isEmpty()){
            for (T elem: value) {
                fruits.add(elem);
            }
            value.clear();

        }
    }
}
