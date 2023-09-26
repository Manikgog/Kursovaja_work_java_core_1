public class Employee {
    private String FIO;    // фамилия, имя, отчество
    private int id;                // идентификатор
    private float salary;          // зарплата
    private String department;     // отдел

    Employee(int id){
        this.FIO = "";
        this.id = id;
        this.salary = 0.0f;
        this.department = "";
    }

    public void printEmployee(){
        System.out.println("ID - " + this.id);
        System.out.println("FIO - " + this.FIO);
        System.out.println("Salary - " + MainMenu.toMoneyFormat(this.salary));
        System.out.println("Department - " + this.department + "\n");
    }

    public String getFIO(){
        return this.FIO;
    }

    public int getID(){
        return this.id;
    }

    public float getSalary(){
        return this.salary;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setFIO(final String FIO){
        this.FIO = FIO;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

    public void setDepartment(final String department){
        this.department = department;
    }

    public void printFIO(){
        System.out.println(this.FIO);
    }
}
