

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

    public void PrintBook(){
        for(int i = 0; i < 10; i++){
            if(book_[i].GetFIO() == "")
                continue;
            System.out.println("ID - " + book_[i].GetID());
            System.out.println("FIO - " + book_[i].GetFIO());
            System.out.println("Salary - " + MainMenu.toMoneyFormat(book_[i].GetSalary()));
            System.out.println("Department - " + book_[i].GetDepartment());
        }
        System.out.println();
    }

    public int CheckVacancy(){

        for(int i = 0; i < 10; i++){
            if(book_[i].GetFIO() == ""){
               return book_[i].GetID();
            }
        }
        return -1;
    }

    public boolean CheckID(int id){
        for(int i = 1; i <= 10; i++){
            if(book_[i].GetID() == id){
                return true;
            }
        }
        return false;
    }

    public boolean AddEmployee(final String FIO, float salary, final String department, int id){
        if(id < 0) return false;
            if(book_[id - 1].GetFIO() == ""){
                book_[id - 1].SetFIO(FIO);
                book_[id - 1].SetSalary(salary);
                book_[id - 1].SetDepartment(department);
                return true;
            }

        return false;
    }

    public boolean DeleteEmployeeByFIO(final String FIO){
        for(int i = 0; i < 10; i++){
            if(book_[i].GetFIO() == FIO){
                book_[i].SetFIO("");
                book_[i].SetSalary(0.0f);
                book_[i].SetDepartment("");
                return true;
            }
        }
        return false;
    }

    public boolean DeleteEmployeeByID(int id){
        for(int i = 0; i < 10; i++){
            if(book_[i].GetID() == id){
                book_[i].SetFIO("");
                book_[i].SetSalary(0.0f);
                book_[i].SetDepartment("");
                return true;
            }
        }
        return false;
    }

    public boolean ChangeEmployeeSalaryByID(int id, float salary){
        for(int i = 0; i < 10; i++){
            if(book_[i].GetID() == id){
                book_[i].SetSalary(salary);
                return true;
            }
        }
        return false;
    }

    public boolean ChangeEmployeeDepartmentByID(int id, final String department){
        for(int i = 0; i < 10; i++){
            if(book_[i].GetID() == id){
                book_[i].SetDepartment(department);
                return true;
            }
        }
        return false;
    }

    public Employee GetEmployeeByID(int id){
        for(int i = 0; i < 10; i++){
            if(id == book_[i].GetID())
                return book_[i];
        }
        Employee e = new Employee(0);
        return e;
    }
    public float MinSalaryFind(){
        float min = book_[0].GetSalary();
        for(int i = 1; i < 10; i++){
            if(book_[i].GetFIO() == "")
                continue;
            if(book_[i].GetSalary() < min){
                min = book_[i].GetSalary();
            }
        }
        return min;
    }

    public float MaxSalaryFind(){
        float max = book_[0].GetSalary();
        for(int i = 1; i < 10; i++){
            if(book_[i].GetSalary() > max){
                max = book_[i].GetSalary();
            }
        }
        return max;
    }

    public float SalaryCost(){
        float summ = 0.0f;
        for(int i = 0; i < 10; i++){
            summ += book_[i].GetSalary();
        }
        return summ;
    }

    public int CountNumberOfEmlpoyee(){
        int number = 0;
        for(int i = 0; i < 10; i++){
            if(book_[i].GetFIO() == "")
                continue;
            number++;
        }
        return number;
    }

    public float AverageSalary(){
        return SalaryCost() / CountNumberOfEmlpoyee();
    }

    public void PrintBookByFIO(){
        for(int i = 0; i < 10; i++){
            if(book_[i].GetFIO() == "")
                continue;
            book_[i].PrintFIO();
        }
    }

    public void PrintFIOByDepartment(){
        String dep[] = new String[10];
        for(int i = 0; i < 10; i++){
            dep[i] = book_[i].GetDepartment();
        }
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 10; j++){
                if(dep[i] == dep[j])
                    dep[j] = "";
            }
        }
        for(int i = 0; i < 10; i++){
            if(dep[i] == "")
                continue;
            if(dep[i] == book_[i].GetDepartment()){
                System.out.println(book_[i].GetDepartment() + ":");
                for(int j = 0; j < 10; j++){
                    if(dep[i] == book_[j].GetDepartment()) {
                        book_[j].PrintFIO();
                    }
                }
            }
        }
    }

}
