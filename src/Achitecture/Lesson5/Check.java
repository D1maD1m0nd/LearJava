package Achitecture.Lesson5;

public abstract class Check {
    private Check next;

    public Check link(Check check){
        this.next = next;
        return next;
    }

    public abstract boolean checkValidEmail(String email);

    protected boolean checkNext(String email){
        if(next == null){
            return true;
        }
        return next.checkValidEmail(email);
    }
}
