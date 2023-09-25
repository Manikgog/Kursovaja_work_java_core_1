public class Employee {
    private String FIO_;    // фамилия, имя, отчество
    private int id_;                // идентификатор
    private float salary_;          // зарплата
    private String department_;     // отдел

    Employee(int id){
        FIO_ = "";
        id_ = id;
        salary_ = 0.0f;
        department_ = "";
    }

    public void PrintEmployee(){
        System.out.println("ID - " + id_);
        System.out.println("FIO - " + FIO_);
        System.out.println("Salary - " + MainMenu.toMoneyFormat(salary_));
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

    public void SetFIO(final String FIO){
        FIO_ = FIO;
    }

    public void SetSalary(float salary){
        salary_ = salary;
    }

    public void SetDepartment(final String department){
        department_ = department;
    }

    public void PrintFIO(){
        System.out.println(FIO_);
    }
}
