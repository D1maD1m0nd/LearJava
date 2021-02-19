package geeks.Lesson11.HomeWork;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    ArrayList<T> value;
    public float getWeight(){
        if(value.size() == 0){
            return 0.0F;
        }
        return value.size() * value.get(0).getWeight();
    };
    public boolean compare(Box<T> box){
        return box.getWeight() == this.getWeight();
    }
}
