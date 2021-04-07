package Achitecture.Lesson5;

public class App {
    public static void main(String[] args) {
        Check check = new EmailCheck();
        Check checkCopyEmails = new CheckCopyEmail();

        check.link(checkCopyEmails);

        boolean result = check.checkValidEmail("valid@mail.ru");
        if(result){
            System.out.println("OK");
        }
    }
}
