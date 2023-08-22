public class Employee {
    private String FIO_;    // фамилия, имя, отчество
    private int id_;                // идентификатор
    private float salary_;          // зарплата
    private String department_;     // отдел

    Employee(){
        FIO_ = "";
        id_ = 0;
        salary_ = 0.0f;
        department_ = "";
    }
    Employee(String FIO, int id, float salary, String department){
        FIO_ = FIO;
        id_ = id;
        salary_ = salary;
        department_ = department;
    }

    public void PrintEmployee(){
        System.out.println("ID - " + id_);
        System.out.println("FIO - " + FIO_);
        System.out.println("Salary - " + salary_);
        System.out.println("Department - " + department_+ "\n");
    }

    public String GetFIO(){
        return FIO_;
    }

    public int GetID(){
        return id_;
    }

    public float GetSalary(){
        return salary_;
    }

    public String GetDepartment(){
        return department_;
    }
}
