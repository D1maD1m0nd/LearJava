package geeks.Algorithms.Lesson4;

public class QueueM {
    private int maxSize;
    private int[] queu;
    private int front;
    private int rear;
    private int items;



    public QueueM(int maxSize) {
        this.maxSize = maxSize;
        this.queu = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }
    public void Insert(int i){
        if(rear == maxSize -1){
            --rear;
        }
        queu[++rear] = i;
        items++;
    }

    public int remove(){
        int temp = queu[front++];
        if(front == maxSize){
            front = 0;
        }
        items--;
        return temp;
    }
    public int peek(){
        return queu[front];
    }
    public boolean isEmpty(){
        return items == 0;
    }
    public boolean isFull(){
        return items == maxSize ;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setQueu(int[] queu) {
        this.queu = queu;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int[] getQueu() {
        return queu;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getItems() {
        return items;
    }


}
