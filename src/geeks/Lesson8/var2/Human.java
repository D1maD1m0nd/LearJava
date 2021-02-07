package geeks.Lesson8.var2;

public class Human implements Participant {
    private final String name;
    private final int maxRunDist;
    private final int maxJumpDist;

    Human(String name, int maxJumpDist, int maxRunDist) {

        this.name = name;
        this.maxJumpDist = maxJumpDist;
        this.maxRunDist = maxRunDist;
    }

    @Override
    public boolean run(Barrier barrier) {
        System.out.printf("Человек %s бежит\n", name);
        return barrier.overcomingBarrier(maxRunDist);
    }

    @Override
    public boolean jump(Barrier barrier) {
        System.out.printf("Человек %s прыгает \n", name);
        return barrier.overcomingBarrier(maxJumpDist);
    }
}

