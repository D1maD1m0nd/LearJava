package geeks.Algorithms.Lesson4;

import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<ArrObj> stack = new Stack<>();

        stack.push(new ArrObj(1,3333));
        stack.push(new ArrObj(3,1111));
        stack.push(new ArrObj(4,33));
        stack.push(new ArrObj(5,1));
        stack.push(new ArrObj(6,32));
        stack.push(new ArrObj(7,32));

        stack.peek().print();

        while (!stack.empty()){
            stack.pop().print();
        }
        StackM stackM = new StackM(2000);
        Random rand = new Random();
        while (!stackM.isFull()){
            stackM.push(rand.nextInt());
        }

        while(!stackM.isEmpty()){
            System.out.println(stackM.pop());
        }
    }
}
