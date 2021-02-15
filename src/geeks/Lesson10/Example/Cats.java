package geeks.Lesson10.Example;

public class Cats {
    private Cat[] cats;
    private int lastIndex;
    public Cats(int capacity){
        cats = new Cat[capacity];
    }
    public void add(Cat cat){
        if(lastIndex == cats.length){
            Cat[] newCats = new Cat[(int)(lastIndex * 1.5)];
            System.arraycopy(cats,0,newCats,0,lastIndex);
            cats = newCats;
        }
        cats[lastIndex] = cat;
        lastIndex++;
    }
    public Cat get(int index){
        return cats[index];
    }

    public int getLength(){
        return lastIndex;
    }

}
