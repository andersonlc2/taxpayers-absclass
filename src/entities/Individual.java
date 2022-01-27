package entities;

public class Individual extends Taxpayer {

    private Double healthSpending;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthSpending) {
        super(name, annualIncome);
        this.healthSpending = healthSpending;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    @Override
    public Double totalTax() {
        double tax = 0;
        if (healthSpending > 0) {
            if (annualIncome < 20000)
                tax = (annualIncome * 0.15) - (healthSpending * 0.5);
            else
                tax = (annualIncome * 0.25) - (healthSpending * 0.5);
        } else {
            if (annualIncome < 20000)
                tax = (annualIncome * 0.15);
            else
                tax = (annualIncome * 0.25);
        }
        return tax;
    }
}
