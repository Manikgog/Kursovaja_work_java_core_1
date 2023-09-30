import java.util.Arrays;

public class EmployeeBook {

    private final int capacity = 10;
    private final Employee[] book = new Employee[capacity];
    private int size = 0;
    public EmployeeBook()
    {}

    int getSize(){
        return this.size;
    }

    boolean checkVacancy(){
        return this.size < this.capacity;
    }

    public void printBook(){
        for(int i = 0; i < this.size; i++){
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "ID - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getId() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Фамилия - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getLastName() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Имя - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getName() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Отчество - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getSurName() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Зарплата - " + ConsoleColors.TEXT_BRIGHT_WHITE + MainMenu.toMoneyFormat(this.book[i].getSalary()) + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Отдел - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getDepartment() + ConsoleColors.TEXT_RESET);
            System.out.println();
        }
    }

    public void addEmployee(final String lastName, final String name, final String surName, float salary, final String department){
        if(size <= capacity) {
            this.size++;
            if (book[size - 1] == null) {
                book[size - 1] = new Employee(lastName, name, surName, salary, department);
            }
        }
    }

    public boolean deleteEmployeeByFIO(final String lastName, final String name, final String surName){
        for(int i = 0; i < this.size; i++){
            if(this.book[i] != null &&
                this.book[i].getLastName().equals(lastName) &&
                this.book[i].getName().equals(name) &&
                this.book[i].getSurName().equals(surName)){
                System.arraycopy(book, i + 1, book, i, book.length - i - 1);
                this.book[size - 1] = null;
                this.size--;
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployeeByID(int id){
        for (int i = 0; i < this.size; i++) {
            if(this.book[i] != null && id == book[i].getId()){
                System.arraycopy(book, i + 1, book, i, book.length - id - 1);
                this.book[size - 1] = null;
                this.size--;
                return true;
            }
        }
        return false;
    }

    public void changeEmployeeSalaryByID(int id, float salary){
        for (int i = 0; i < this.size; i++) {
            if(this.book[i] != null && this.book[i].getId() == id){
                book[i].setSalary(salary);
                return;
            }
        }
    }

    public void changeEmployeeDepartmentByID(int id, final String department){
        for (int i = 0; i < this.size; i++) {
            if(this.book[i] != null && this.book[i].getId() == id){
                book[i].setDepartment(department);
                return;
            }
        }
    }

    public Employee getEmployeeByID(int id){
        for (int i = 0; i < this.size; i++) {
            if(this.book[i] != null &&this.book[i].getId() == id){
                return book[i];
            }
        }
        return null;
    }
    public float minSalaryFind(){
        if(size == 0){
            return 0F;
        }
        float min = this.book[0].getSalary();
        for(int i = 1; i < this.size; i++){
            if(this.book[i].getSalary() < min){
                min = this.book[i].getSalary();
            }
        }
        return min;
    }

    public float maxSalaryFind(){
        if(size == 0){
            return 0F;
        }
        float max = this.book[0].getSalary();
        for(int i = 1; i < this.size; i++){
            if(this.book[i].getSalary() > max){
                max = this.book[i].getSalary();
            }
        }
        return max;
    }

    public float salaryCost(){
        float summ = 0.0f;
        for(int i = 0; i < this.size; i++){
            summ += this.book[i].getSalary();
        }
        return summ;
    }

    public float averageSalary(){
        if(this.size == 0){
            return 0F;
        }
        return salaryCost() / this.size;
    }

    public void printBookByFIO(){
        for(int i = 0; i < this.size; i++){
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Фамилия - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getLastName() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Имя - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getName() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Отчество - " + ConsoleColors.TEXT_BRIGHT_WHITE + this.book[i].getSurName() + ConsoleColors.TEXT_RESET);
        }
    }

    public void printFIOByDepartment(){
        String[] dep = new String[10];
        for(int i = 0; i < this.size; i++){
            dep[i] = this.book[i].getDepartment();
        }
        for(int i = 0; i < this.size - 1; i++){
            for(int j = i+1; j < this.size; j++){
                if(dep[i].equals(dep[j]))
                    dep[j] = "";
            }
        }
        for(int i = 0; i < this.size; i++){
            if(dep[i].length() == 0)
                continue;
            if(dep[i].equals(this.book[i].getDepartment())){
                System.out.println(ConsoleColors.TEXT_GREEN + this.book[i].getDepartment() + ":" + ConsoleColors.TEXT_RESET);
                for(int j = 0; j < this.size; j++){
                    if(dep[i].equals(this.book[j].getDepartment())) {
                        System.out.println(this.book[j].getLastName() + " " +
                                            this.book[j].getName() + " " +
                                            this.book[j].getSurName());
                    }
                }
            }
        }
    }

    public boolean checkSameFIO(String[] FIO){
        for(int i = 0; i < this.size; i++){
            if(book[i].getName().equals(FIO[1]) &&
                    book[i].getSurName().equals(FIO[2]) &&
                    book[i].getLastName().equals(FIO[0])){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "book=" + Arrays.toString(book) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        EmployeeBook that = (EmployeeBook) o;
        return Arrays.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(book);
    }
}
