import java.util.*;

public class PayRoll {

    private ArrayList<Employee> employeeList;

    public PayRoll() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public void removeEmployee(int ID) {
        Employee employeeToRemove = null;
        for (Employee e : employeeList) {
            if (e.getId() == ID) {
                employeeToRemove = e;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }else{
            System.out.println("Employee is not in Organization");
        }
    }

    public void showAllEmployee(){
        for(Employee e : employeeList){
            System.out.println(e);
        }
    }
}
