package Lesson5;

import java.util.Random;

public class TestEmployee
{
    private static final String[] names = new String[]{"Авдошин Дима Александрович",
                                                        "Перекопиваев Анатолий Александрович",
                                                        "Артемовавич Тигран Александрович",
                                                        "Музыкальный Виктор Суварович",
                                                         "Засанадлева Анастасия Викторовна"};
    private static final String EMAIL = "company@mail.ru";
    public static void main(String[] args) {
       Employee[] employees =  generateEmployee();
    }
    private static Employee[] generateEmployee(){
        Employee[] employee = new Employee[names.length];
        for (int i = 0; i < names.length ; i++) {
            employee[i] = new Employee(names[i],"Enginer#" + i, i + EMAIL, genRandomNumPhone(), genSalary(), 16 + i);
            employee[i].printDataOfEmployee();
        }
        return employee;
    }
    private static int genRandomNumPhone(){
        return (int)(Math.random() * 11) + 11;
    }
    private static double genSalary(){
        return Math.random() * 100000 + 20000;
    }
}
