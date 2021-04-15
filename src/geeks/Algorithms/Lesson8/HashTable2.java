package geeks.Algorithms.Lesson8;

public class HashTable2 {
    private Item[] hashArray;
    private int arrSize;
    private Item nonItem;

    public HashTable2(int size){
        this.arrSize = size;
        hashArray = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display(){
        for (int i = 0; i < arrSize ; i++) {
            if(hashArray[i] != null){
                System.out.println(hashArray[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public void insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArray[hashVal] = item;
    }
    public Item delete(int key){
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                Item temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key){
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public int getPrime(int min){
        for (int i = min + 1; true; i++) {
            if(isPrime(i)){
                return i;
            }
        }
    }
    public boolean isPrime(int n){
        for (int j = 2; (j* j) <= n; j++)
            if (n % j == 0)
                return false;
        return true;

    }
}
