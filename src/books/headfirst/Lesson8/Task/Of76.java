package books.headfirst.Lesson8.Task;

public class Of76 extends Clowns{
    public static void main(String[] args) {
        Nose[] noses = new Nose[3];

        noses[0] = new Acts();
        noses[1] = new Clowns();
        noses[2] = new Of76();

        for (Nose nose : noses) {
            System.out.println(nose.iMethod() + " " + nose.getClass());
        }
    }
}
