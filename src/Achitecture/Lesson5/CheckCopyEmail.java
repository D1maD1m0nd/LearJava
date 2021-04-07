package Achitecture.Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckCopyEmail extends Check{
     private final static List<String> emails = new ArrayList<>(Arrays.asList(new String[]{"alex@yandex.ru",
             "alex-27@yandex.com",
             "alex.27@yandex.com",
             "alex111@devcolibri.com",
             "alex@gmail.com.com",
             "alex27@gmail.com",
             "alex-27@yandex-test.com"}));


    @Override
    public boolean checkValidEmail(String email) {
            if (!emails.contains(email) ){
                return false;
            }
            return checkNext(email);
    }
}
