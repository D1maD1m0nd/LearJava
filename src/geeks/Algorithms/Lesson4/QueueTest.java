package geeks.Algorithms.Lesson4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<ArrObj> a = new LinkedList<>();

        a.add(new ArrObj(1,2));
        a.add(new ArrObj(3,4));
        a.add(new ArrObj(6,4));

        while (!a.isEmpty()){
            a.poll().print();
        }

        QueueM b = new QueueM(3);

        b.Insert(132);
        b.Insert(1222222);
        b.Insert(11111111);

        while (!b.isEmpty()){
            System.out.println(b.remove());
        }
    }
}
