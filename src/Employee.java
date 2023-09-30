import java.util.Objects;

public class Employee {

    private final int id;
    private final String lastName;    // фамилия
    private final String name;        // имя
    private final String surName;     // отчество
    private float salary;             // зарплата
    private String department;        // отдел

    Employee(String lastName, String name, String surName, float salary, String department){
        this.id = Main.countId;
        this.lastName = lastName;
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.department = department;
        Main.countId++;
    }

    @Override public String toString(){
        return "ID - " + this.id +
                "\nФИО - " + this.lastName + " " + this.name + " " + this.surName +
                "\nЗарплата - " + MainMenu.toMoneyFormat(this.salary) +
                "\nОтдел - " + this.department + "\n";
    }

    @Override public boolean equals(Object employee){
        if(this == employee){
            return true;
        }
        if (employee == null || this.getClass() != employee.getClass()) {
            return false;
        }
        Employee e = (Employee) employee;
        return this.department.equals(e.department) &&
                this.lastName.equals(e.lastName) &&
                this.name.equals(e.name) &&
                this.surName.equals(e.surName) &&
                this.salary == e.salary &&
                this.id == e.id;
    }

    @Override public int hashCode() {
        return Objects.hash(this.id, this.name, this.surName, this.lastName, this.salary, this.department);
    }

    public int getId(){
        return this.id;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getName(){
        return this.name;
    }

    public String getSurName(){
        return this.surName;
    }

    public float getSalary(){
        return this.salary;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

    public void setDepartment(final String department){
        this.department = department;
    }

}
