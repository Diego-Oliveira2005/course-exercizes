package Application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter Department's name: ");
        String department = sc.nextLine();
        System.out.println("Enter Worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));

        System.out.print("How many contracts to this worker? ");
        int contracts = sc.nextInt();

        for (int i = 1; i <= contracts; i++) {
            sc.nextLine();
            System.out.printf("Enter contract #%d data: \n" , i);
            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), fmt1);
            System.out.print("Value per hour: ");
            double value = sc.nextDouble();
            System.out.print("Duration (Hours): ");
            int duration = sc.nextInt();
            HourContract contract = new HourContract(date, value, duration);
            worker.addContract(contract);
        }
        sc.nextLine();

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.nextLine();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.print("Name: ");
        System.out.println(worker.getName());
        System.out.print("Department: ");
        System.out.println(worker.getDepartment().getName());
        System.out.printf("Income for: %s: %.2f", monthAndYear, worker.income(year, month));

        sc.close();
    }
}
