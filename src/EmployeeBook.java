

public class EmployeeBook {
    private Employee[] book_ = new Employee[10];
    private static int count_ = 0;
    EmployeeBook()
    {
        for(int i = 0; i < 10; i++){
            count_++;
            book_[i] = new Employee(count_);
        }
    }

    public void printBook(){
        for(int i = 0; i < 10; i++){
            if(book_[i].getFIO().length() == 0)
                continue;
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "ID - " + ConsoleColors.TEXT_BRIGHT_WHITE + book_[i].getID() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "FIO - " + ConsoleColors.TEXT_BRIGHT_WHITE + book_[i].getFIO() + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Salary - " + ConsoleColors.TEXT_BRIGHT_WHITE + MainMenu.toMoneyFormat(book_[i].getSalary()) + ConsoleColors.TEXT_RESET);
            System.out.println(ConsoleColors.TEXT_BRIGHT_BLUE + "Department - " + ConsoleColors.TEXT_BRIGHT_WHITE + book_[i].getDepartment() + ConsoleColors.TEXT_RESET);
            System.out.println();
        }
    }

    public int checkVacancy(){
        for(int i = 0; i < 10; i++){
            if(book_[i].getFIO().length() == 0){
               return book_[i].getID();
            }
        }
        return -1;
    }

    public boolean checkID(int id){
        for(int i = 1; i <= 10; i++){
            if(book_[i].getID() == id){
                return true;
            }
        }
        return false;
    }

    public void addEmployee(final String FIO, float salary, final String department, int id){
        if(id < 0) return;
        if(book_[id - 1].getFIO().length() == 0){
            book_[id - 1].setFIO(FIO);
            book_[id - 1].setSalary(salary);
            book_[id - 1].setDepartment(department);
        }
    }

    public boolean deleteEmployeeByFIO(final String FIO){
        for(int i = 0; i < 10; i++){
            if(book_[i].getFIO().equals(FIO)){
                book_[i].setFIO("");
                book_[i].setSalary(0.0f);
                book_[i].setDepartment("");
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployeeByID(int id){
        for(int i = 0; i < 10; i++){
            if(book_[i].getID() == id){
                book_[i].setFIO("");
                book_[i].setSalary(0.0f);
                book_[i].setDepartment("");
                return true;
            }
        }
        return false;
    }

    public void changeEmployeeSalaryByID(int id, float salary){
        for(int i = 0; i < 10; i++){
            if(book_[i].getID() == id){
                book_[i].setSalary(salary);
            }
        }
    }

    public void changeEmployeeDepartmentByID(int id, final String department){
        for(int i = 0; i < 10; i++){
            if(book_[i].getID() == id){
                book_[i].setDepartment(department);
            }
        }
    }

    public Employee getEmployeeByID(int id){
        for(int i = 0; i < 10; i++){
            if(id == book_[i].getID())
                return book_[i];
        }
        return new Employee(0);
    }
    public float minSalaryFind(){
        float min = book_[0].getSalary();
        for(int i = 1; i < 10; i++){
            if(book_[i].getFIO().length() == 0)
                continue;
            if(book_[i].getSalary() < min){
                min = book_[i].getSalary();
            }
        }
        return min;
    }

    public float maxSalaryFind(){
        float max = book_[0].getSalary();
        for(int i = 1; i < 10; i++){
            if(book_[i].getSalary() > max){
                max = book_[i].getSalary();
            }
        }
        return max;
    }

    public float salaryCost(){
        float summ = 0.0f;
        for(int i = 0; i < 10; i++){
            summ += book_[i].getSalary();
        }
        return summ;
    }

    public int countNumberOfEmlpoyee(){
        int number = 0;
        for(int i = 0; i < 10; i++){
            if(book_[i].getFIO().length() == 0)
                continue;
            number++;
        }
        return number;
    }

    public float averageSalary(){
        return salaryCost() / countNumberOfEmlpoyee();
    }

    public void printBookByFIO(){
        for(int i = 0; i < 10; i++){
            if(book_[i].getFIO().length() == 0)
                continue;
            book_[i].printFIO();
        }
    }

    public void printFIOByDepartment(){
        String[] dep = new String[10];
        for(int i = 0; i < 10; i++){
            dep[i] = book_[i].getDepartment();
        }
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 10; j++){
                if(dep[i].equals(dep[j]))
                    dep[j] = "";
            }
        }
        for(int i = 0; i < 10; i++){
            if(dep[i].length() == 0)
                continue;
            if(dep[i].equals(book_[i].getDepartment())){
                System.out.println(ConsoleColors.TEXT_GREEN + book_[i].getDepartment() + ":" + ConsoleColors.TEXT_RESET);
                for(int j = 0; j < 10; j++){
                    if(dep[i].equals(book_[j].getDepartment())) {
                        book_[j].printFIO();
                    }
                }
            }
        }
    }

}
