public class Main {
    public static void main(String[] args) {
        PayRoll payRoll = new PayRoll();

        FullTImeEmployee emp1 = new FullTImeEmployee("Vineet", 1, 100000);
        FullTImeEmployee emp2 = new FullTImeEmployee("Akshay", 2, 120000);
        PartTimeEmployee emp3 = new PartTimeEmployee("Riya", 3, 10, 1000);
        PartTimeEmployee emp4 = new PartTimeEmployee("Omraje", 4, 11, 900);

        payRoll.addEmployee(emp1);
        payRoll.addEmployee(emp2);
        payRoll.addEmployee(emp3);
        payRoll.addEmployee(emp4);

        System.out.println("Employee in the Payroll");
        payRoll.showAllEmployee();

        System.out.println("Removing Employee");
        payRoll.removeEmployee(2);

        System.out.println("Employee in the Payroll");
        payRoll.showAllEmployee();
    }
}