package geeks.Lesson8.Var1;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[3];
        participants[0] = new Cat("Vasya",40,40);
        participants[1] = new Robot("Robo-Vasya",30,30);
        participants[2] = new Human("Vasiliy",50,50);

        Barrier[] barriers = new Barrier[4];
        barriers[0] = new Wall(10);
        barriers[1] = new Wall(40);
        barriers[2] = new Treadmill(20);
        barriers[3] = new Treadmill(50);
        for (Participant participant :
                participants) {
            for (Barrier barrier:
                    barriers) {
                if(barrier instanceof Treadmill){
                    if(!participant.run(barrier.getBarrier())){
                        break;
                    };
                }
                if(barrier instanceof Wall){
                    if(!participant.jump(barrier.getBarrier())){
                        break;
                    };
                }
            }
        }
    }
}
