package geeks.Algorithms.Lesson4;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
    public static void main(String[] args) {
        Deque<ArrObj> deq = new ArrayDeque<>();
        deq.add(new ArrObj(1,2));
        deq.add(new ArrObj(2,3));
        deq.add(new ArrObj(5,3));

        deq.addFirst(new ArrObj(111,111));
        deq.addLast(new ArrObj(111111111,222222222));

        while (!deq.isEmpty()){
            deq.poll().print();
        }

        deq.addLast(new ArrObj(1,2));
        deq.addFirst(new ArrObj(111111,22321));

        assert deq.peekFirst() != null;
        deq.peekFirst().print();
        assert deq.peekLast() != null;
        deq.peekLast().print();
    }
}
