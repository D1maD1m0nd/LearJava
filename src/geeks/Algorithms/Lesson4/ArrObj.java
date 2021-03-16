package geeks.Algorithms.Lesson4;

public class ArrObj {
    private double x;
    private double y;

    public ArrObj(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void print(){
        System.out.println("X: " + x + " " + "Y: " + y);
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }
}
