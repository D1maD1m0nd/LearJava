package geeks.Algorithms.Lesson4;

import java.util.PriorityQueue;

public class PriorityDeq {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityDeq = new PriorityQueue<>();
        priorityDeq.add(1);
        priorityDeq.add(5);
        priorityDeq.add(78);
        priorityDeq.offer(66);

        while (!priorityDeq.isEmpty()){
            System.out.println(priorityDeq.poll());
        }
    }
}
