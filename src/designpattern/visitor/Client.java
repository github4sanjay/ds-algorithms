package designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {
   
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FixedSalaryEmployee(20, "john", 300));
        employees.add( new CommissionBasedEmployee(100, "tom", 30, 1500));
        employees.add(new FixedSalaryAndCommissionBasedEmployee(10, "jona", 200, 10, 1500));

        // total salary
        Visitor<Integer> visitor = new SalaryCalculator();
        int sum=0;
        for(Employee employee : employees) {
            sum = sum + employee.accept(visitor);
        }
        System.out.println("Total salary is "+sum);

        // print info
        Visitor<String> informationPrinter = new InformationPrinter();
        List<String> infos = new ArrayList<>();
        for(Employee employee : employees) {
            infos.add(employee.accept(informationPrinter));
        }
        System.out.println(infos);
    }
   
}