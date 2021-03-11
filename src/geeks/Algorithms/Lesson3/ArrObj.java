package geeks.Algorithms.Lesson3;

public class ArrObj {
    private int x;
    private int y;

    ArrObj(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void print(){
        System.out.println("X: " + x + "Y: " + y);
    }
    public int  getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
