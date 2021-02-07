package geeks.Lesson8.var2;

public class Wall implements Barrier {
    private final int maxHeight;
    Wall(int maxHeight){
        this.maxHeight = maxHeight;
    }
    @Override
    public boolean overcomingBarrier(int dist){
        if(dist >= maxHeight){
            System.out.printf("Участник успешно перепрыгнул %d m\n",maxHeight);
            return true;
        }
        System.out.printf("Участник не смог перепрыгнуть %d m\n", maxHeight);
        return false;
    }
}
