public abstract class Employee {
    private String Name;
    private int Id;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee Id :" + " " + this.Id + " " + " Employee Name :" + " " + this.Name  + " Employee Salary :" + " " + this.calculateSalary();
    }



    public Employee(String name, int Id){
        this.Name = name;
        this.Id = Id;
    }
}
