public class FullTImeEmployee extends Employee {

    private double monthlySalary;

    public FullTImeEmployee(String name, int Id, double monthlySalary) {
        super(name, Id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
