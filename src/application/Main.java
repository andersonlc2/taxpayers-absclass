package application;

import entities.Company;
import entities.Individual;
import entities.Taxpayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Taxpayer> taxpayerList = new ArrayList<>();

        System.out.print("Enter to number of persons: ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.printf("%d# TAXPAYER: %n", i);
            System.out.print("[1] - Individual or [2] - Company: ");
            char person = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if (person == '1') {
                System.out.print("Health  spending: ");
                double healthSpending = sc.nextDouble();
                taxpayerList.add(new Individual(name, annualIncome, healthSpending));
            } else if (person == '2') {
                System.out.print("Number employee: ");
                int numberEmployee = sc.nextInt();
                taxpayerList.add(new Company(name, annualIncome, numberEmployee));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");
        double sum = 0;
        for (Taxpayer taxpayer : taxpayerList) {
            System.out.printf("%s - $ %.2f%n", taxpayer.getName(), taxpayer.totalTax());
            sum+= taxpayer.totalTax();
        }
        System.out.println();
        System.out.printf("Total tax: $ %.2f", sum);
    }
}
