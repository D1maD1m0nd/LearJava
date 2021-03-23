package books.headfirst.Lesson5;

import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;
    
    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("PornHub.com");
        DotCom two = new DotCom();
        two.setName("vk.com");
        DotCom three = new DotCom();
        three.setName("Lol.com");

        System.out.println("Ваша цель потопить три корабля");
        System.out.println("PornHub.com vk.com Lol.com");

        for (DotCom dotComToSet: dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while (!dotComsList.isEmpty()){
            String usetGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(usetGuess);
        }
        finishGame();
    }

    private void finishGame() {
    }

    private void checkUserGuess(String usetGuess) {
    }
}
