package Achitecture.Lesson4;

public class ControlNumber implements Controller{
    Number number;
    ControlNumber(Number number){
        this.number = number;
    }

    @Override
    public int sumNumbers() {
        return number.sum().sum().sum().sum().sum().sum().getSum();
    }

    @Override
    public void addNumber(int i) {
        number.addNumber(i);
    }
}
