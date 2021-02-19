package geeks.Lesson11.Exampels;

public class Stats <T extends Number>{
    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }
    public double average(){
        double sum = 0;
        for (T num: nums) {
            sum += num.doubleValue();
        }
        return  sum/nums.length;
    }

    public boolean sameAverage(Stats<?> stats){
        return this.average() == stats.average();
    }

    public <K> K doSomething(K param){
        System.out.println(param);
        return param;
    }
    public void setNum(T[] nums) {
        this.nums = nums;
    }

    public T[] getNum() {
        return nums;
    }
}
