package geeks.Lesson8.var2;

public class Treadmill implements Barrier {
    private final int lengthTreadmill;

    Treadmill(int lengthTreadmill) {

        this.lengthTreadmill = lengthTreadmill;
    }

    @Override
    public boolean overcomingBarrier(int dist) {
        if (dist >= lengthTreadmill) {
            System.out.printf("Участник успешно пробежал %d m\n", lengthTreadmill);
            return true;
        }
        System.out.printf("Участник не смог пробежать %d m\n", lengthTreadmill);
        return false;
    }
}
