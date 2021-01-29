package Lesson5;


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
        filterAgeEmployee(employees);
    }

    private static Employee[] generateEmployee(){
        Employee[] employee = new Employee[names.length];
        System.out.println("Выводим общую информацию на консоль о всех сотрудниках");
        for (int i = 0; i < names.length ; i++) {
            employee[i] = new Employee(names[i],"Enginer#" + i, i + EMAIL, genRandomNumPhone(), genSalary(), 38 + i);
            employee[i].printDataOfEmployee();
        }
        return employee;
    }
    private static int genRandomNumPhone(){
        return (int) (Math.random() * 1000000000) + 1000000000;
    }

    private static double genSalary(){
        return Math.random() * 100000 + 20000;
    }

    private static void filterAgeEmployee(Employee[] employees){
        System.out.println("Выводим общую информацию на консоль о сотрудниках старше 40");
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getAge() > 40){
                employees[i].printDataOfEmployee();
            }
        }
    }
}
