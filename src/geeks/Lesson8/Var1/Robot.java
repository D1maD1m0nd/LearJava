package geeks.Lesson8.Var1;

public class Robot implements Participant {
    private final String name;
    private final int maxRunDist;
    private final int maxJumpDist;

    Robot(String name, int maxJumpDist, int maxRunDist) {

        this.name = name;
        this.maxJumpDist = maxJumpDist;
        this.maxRunDist = maxRunDist;
    }

    @Override
    public boolean run(int runLengthBarrier) {
        if (maxRunDist >= runLengthBarrier) {
            System.out.printf("Робот %s пробежал дистанцию %d м\n", name, runLengthBarrier);
            return true;
        } else {
            System.out.printf("Робот %s не смог пробежать дистанцию %d м\n", name, runLengthBarrier);
            return false;
        }

    }

    @Override
    public boolean jump(int runJumpBarrier) {
        if (maxRunDist >= maxJumpDist) {
            System.out.printf("Робот %s прыгает на %d м\n", name, runJumpBarrier);
            return true;
        } else {
            System.out.printf("Робот %s не смог перепрыгнуть %d м\n", name, runJumpBarrier);
            return false;
        }

    }
}
