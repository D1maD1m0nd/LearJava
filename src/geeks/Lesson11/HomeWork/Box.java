package geeks.Lesson11.HomeWork;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> value = new ArrayList<>();

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
        if(value.isEmpty()){

            value.addAll(fruits.getValue());
            fruits.clear();
        }
    }

    public void clear(){
        value.clear();
    }
}
