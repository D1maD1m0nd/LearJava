package geeks.Lesson8.Var1;

public class Cat implements Participant {
    private final String name;
    private final int maxRunDist;
    private final int maxJumpDist;

    Cat(String name, int maxJumpDist, int maxRunDist) {

        this.name = name;
        this.maxJumpDist = maxJumpDist;
        this.maxRunDist = maxRunDist;
    }

    @Override
    public boolean run(int runLengthBarrier) {

        if (runLengthBarrier <= maxRunDist) {
            System.out.printf("Кот %s пробежал дистанцию %d м\n", name, runLengthBarrier);
            return true;
        } else {
            System.out.printf("Кот %s не смог пробежать дистаницю %d м\n", name, runLengthBarrier);
            return false;
        }
    }

    @Override
    public boolean jump(int runJumpBarrier) {

        if (runJumpBarrier <= maxRunDist) {
            System.out.printf("Кот %s перепрыгнул стену высотой %d м\n", name, runJumpBarrier);
            return true;
        } else {
            System.out.printf("Кот %s не перепрыгнул стену высотой %d м\n", name, runJumpBarrier);
            return false;

        }
    }
}
