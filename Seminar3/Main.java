package Seminar3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    
    public static Worker generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        String[] age = new String[] { "20", "30", "25", "35", "40", "45", "50", "60", "65" };
        
        int salary = random.nextInt(1500);
        int salaryIndex = random.nextInt(31);

        return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], age[random.nextInt(9)],  salary * salaryIndex );
        
    }

    public static Freelancer generateEmployee2(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        String[] age = new String[] { "20", "30", "25", "35", "40", "45", "50", "60", "65" };

        int salary = random.nextInt(1500);
        int salaryIndex = random.nextInt(31);
        int salaryHour = random.nextInt(5);
        
        return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], age[random.nextInt(9)], salary * salaryIndex * salaryHour );
    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        // for (Employee employee: employees) {
        //     System.out.println(employee);
        // }

        Arrays.sort(employees);

        System.out.println("\n*** Отсортированный массив сотрудников ***\n");

        for (Employee employee: employees) {
            System.out.println(employee);
        }


        //________Разделитель между фрилансерами и рабочими___________________________________________________________________________
        
        Employee[] employees2 = new Employee[10];
        for (int i = 0; i < employees2.length; i++){
            employees2[i] = generateEmployee2();
        }

        // for (Employee employee2: employees2) {
        //     System.out.println(employee2);
        // }

        Arrays.sort(employees2);

        System.out.println("\n*** Отсортированный массив сотрудников ***\n");

        for (Employee employee: employees2) {
            System.out.println(employee);
        }


    }

}


class SalaryComparator implements Comparator<Employee>{

    // 1 0 -1
    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
        //return o1.calculateSalary() == o2.calculateSalary() ? 0 :
        //        (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
    }
}

class SurNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {

        return o1.surName.compareTo(o2.surName);
    }

}

abstract class Employee implements Comparable<Employee>{

    protected String firstName;
    protected String surName;
    protected String age;
    protected double salary;
    

    public Employee(String firstName, String surName, String age, double salary) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
        
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Ставка: %.2f; Среднемесячная заработная плата: %.2f",
                surName, firstName, salary, age, calculateSalary());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee{

    public Worker(String firstName, String surName, String age, double salary) {
        super(firstName, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Возраст; %s; Среднемесячная заработная плата: %.2f",
                surName, firstName, age, calculateSalary());
    }
}


class Freelancer extends Employee{
    
    public Freelancer(String firstName, String surName, String age, double salary) {
        super(firstName, surName, age, salary);
    }

    public double calculateSalary() {
        return salary;
    }
    
    public String toString() {
         return String.format("%s %s; Фрилансер; Возраст; %s; Среднемесячная заработная плата: %.2f",
            surName, firstName, age, calculateSalary());
    }
}
