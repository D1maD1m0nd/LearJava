package books.headfirst.Lesson10;

public class ExTestDrive {
    public static void main(String[] args) {
        String test = args[0];
        try {
            doRisky(test);
        }catch (MyEx ex){
            System.out.println("throws");
        }

    }

    public static void doRisky(String t) throws MyEx{
        if(t.equals("yes")){
            System.out.println();
        }else{
            throw new MyEx();
        }
    }
}
