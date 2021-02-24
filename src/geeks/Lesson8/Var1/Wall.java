package geeks.Lesson8.Var1;

public class Wall implements Barrier {
    private final int maxHeight;

    Wall(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public int getBarrier() {
        return maxHeight;
    }
}
