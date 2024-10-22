public class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlySalary;

    public PartTimeEmployee(String name, int Id, int hoursWorked, double hourlySalary) {
        super(name, Id);
        this.hourlySalary = hourlySalary;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked*hourlySalary;
    }
}
