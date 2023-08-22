import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {
    private List<Employee> book_;

    EmployeeBook()
    {
        book_ = new ArrayList();
    }

    public void AddEmployee(String FIO, int id, float salary, String department){
        book_.add(new Employee(FIO, id, salary, department));
    }

    public void PrintBook(){
        for(int i = 0; i < book_.size(); i++){
            book_.get(i).PrintEmployee();
        }
    }

}
