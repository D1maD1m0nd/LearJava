package geeks.Algorithms.Lesson4;

public class StackM {
    private int maxSize;
    private int[] stack;
    private int top;

    public StackM(int size){
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int elem){
        stack[++top] = elem;
    }
    public int pop(){
        return stack[top--];
    }
    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == maxSize - 1;
    }
}
