import java.util.Objects;

public class Employee {
    private String lastName;    // фамилия
    private String name;        // имя
    private String surName;
    private float salary;          // зарплата
    private String department;     // отдел

    Employee(String lastName, String name, String surName, float salary, String department){
        this.lastName = lastName;
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.department = department;
    }

    @Override public String toString(){
        return "ФИО - " + this.lastName + " " + this.name + " " + this.surName +
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
                this.salary == e.salary;
    }

    @Override public int hashCode() {
        return Objects.hash(name, surName, lastName, salary, department);
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

    public void setLastName(final String lastName){
        this.lastName = lastName;
    }
    public void setName(final String Name){
        this.name = name;
    }

    public void setSurName(final String surName){
        this.surName = surName;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

    public void setDepartment(final String department){
        this.department = department;
    }

}
