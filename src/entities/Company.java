package entities;

public class Company extends Taxpayer {

    private Integer numberEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double annualIncome, Integer numberEmployees) {
        super(name, annualIncome);
        this.numberEmployees = numberEmployees;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    @Override
    public Double totalTax() {
        double tax = annualIncome * 0.16;
        if (numberEmployees > 10)
            tax = annualIncome * 0.14;
        return tax;
    }
}
