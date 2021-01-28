package Lesson5;

public class Employee {
    private final String name;
    private final String position;
    private final String email;
    private final int phoneNumber;
    private final double salary;
    private final int age;

    Employee(String name, String position, String email, int phoneNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printDataOfEmployee() {
        System.out.printf("Имя:%s, " +
                "Должность: %s, " +
                "Email: %s, " +
                "Телефонный номер: %d, " +
                "Зарплата: %.2f, " +
                "Возраст: %d\n", name, position, email, phoneNumber, salary, age);
    }
}
