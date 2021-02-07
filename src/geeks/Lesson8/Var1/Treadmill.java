package geeks.Lesson8.Var1;

public class Treadmill implements Barrier {
    private final int lengthTreadmill;
    Treadmill(int lengthTreadmill){

        this.lengthTreadmill = lengthTreadmill;
    }

    @Override
    public int getBarrier() {
        return lengthTreadmill;
    }
}
