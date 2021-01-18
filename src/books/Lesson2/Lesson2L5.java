package books.Lesson2;

public class Lesson2L5 {
    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        if(d.snare == true){
            d.playShare();
        }

        d.playTopHat();
    }
}
