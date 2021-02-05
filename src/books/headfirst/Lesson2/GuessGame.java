package books.headfirst.Lesson2;

public class GuessGame {
    Player p1;
    Player p2;
    Player p3;
    public  void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1Right = false;
        boolean p2Right = false;
        boolean p3Right = false;

        int count = 0;

        int targetNumber = (int) (Math.random() * 100000000);
        System.out.println("I think num 0 of 9");

        while(true){
            System.out.println("Num whoes think - " + targetNumber);

            p1.guess();
            p2.guess();
            p3.guess();


            guessp1 = p1.number;
            guessp2 = p2.number;
            guessp3 = p3.number;

            if(guessp1 == targetNumber){
                p1Right = true;
            }
            if(guessp2 == targetNumber){
                p2Right = true;
            }
            if(guessp3 == targetNumber){
                p3Right = true;
            }
            if(p1Right || p2Right || p3Right){
                System.out.println("First player " + p1Right);
                System.out.println("Second player " + p2Right);
                System.out.println("Third player " + p3Right);
                break;
            }else{
                System.out.println("Игровки пробуют еще раз");
            }
            count++;
        }
        System.out.println(count);
    }
}
