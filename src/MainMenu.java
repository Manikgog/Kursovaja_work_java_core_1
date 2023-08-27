import java.util.Scanner;

public class MainMenu {

    public void MainMenu(EmployeeBook Book) {
        do {
            Menu menu = new Menu();
            int choice = 0;
            do {
                choice = menu.MenuMain();
            } while (choice < 1 || choice > 10);

            switch (choice) {
                case 1:
                    System.out.println("*******************************************************");
                    Book.PrintBook();
                    System.out.println("*******************************************************");
                    break;
                case 2:
                    System.out.println("Сумма затрат на зарплаты равна " + Book.SalaryCost());
                    break;
                case 3:
                    System.out.println("Работники с минимальной зарплатой");
                    PrintEmployeesWithSalary(Book, Book.MinSalaryFind());
                    break;
                case 4:
                    System.out.println("Работники с максимальной зарплатой");
                    PrintEmployeesWithSalary(Book, Book.MaxSalaryFind());
                    break;
                case 5:
                    System.out.println("Средняя зарплата равна " + Book.AverageSalary());
                    break;
                case 6:
                    Employee emp = AddEmpl(Book);
                    Book.AddEmployee(emp.GetFIO(), emp.GetSalary(), emp.GetDepartment(), emp.GetID());
                    break;
                case 7:
                    DeleteEmployee(Book);
                    break;
                case 8:
                    ChangeEmployee(Book);
                    break;
                case 9:
                    Book.PrintFIOByDepartment();
                    break;

            }

            if(choice == 10)
                break;
        } while(true);
    }

    private boolean ChangeEmployee(EmployeeBook Book){
        System.out.print("Введите ID работника:");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        if(!Book.CheckID(id)) {
            System.out.println("Работника с ID " + id + " нет.");
            return false;
        }
        System.out.println("1. Изменить зарплату.");
        System.out.println("2. Изменить отдел.");
        System.out.println("Введите номер пункта: ");
        int n = in.nextInt();
        if(n == 1){
            System.out.print("Введите новую зарплату работника: ");
            float salary = in.nextFloat();
            if(Book.ChangeEmployeeSalaryByID(id, salary))
                return true;
        }else if(n == 2){
            System.out.print("Введите новый отдел работника: ");
            String dep = in.nextLine();
            if(Book.ChangeEmployeeDepartmentByID(id, dep))
                return true;
        }
        return false;
    }

    private void PrintEmployeesWithSalary(EmployeeBook Book, float salary){
        for(int i = 1; i <= 10; i++){
            if(Book.GetEmployeeByID(i).GetSalary() == salary){
                Book.GetEmployeeByID(i).PrintEmployee();
            }
        }
    }

    private boolean DeleteEmployee(EmployeeBook Book){
        System.out.println("Выберите вариант удаления:");
        System.out.println("1. Удаление по ID.");
        System.out.println("2. Удаление по ФИО.");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер пункта меню: ");
        int input = in.nextInt();
        if(input == 1){
            System.out.print("Введите ID: ");
            input = in.nextInt();
            if(Book.DeleteEmployeeByID(input)){
                System.out.println("Данные сотрудника с ID "+ input + " удалены.");
                return true;
            }
        }else if(input == 2){
            System.out.print("Введите ФИО: ");
            String name;
            name = in.nextLine();
            if(Book.DeleteEmployeeByFIO(name)){
                System.out.println("Данные сотрудника "+ name + " удалены.");
                return true;
            }
        }
        return false;
    }

    private Employee AddEmpl(EmployeeBook Book) {
        int id = Book.CheckVacancy();
        if (id > 0) {
            Employee e = new Employee(id);
            Scanner in = new Scanner(System.in);
            System.out.print("Введите ФИО: ");
            String name = in.nextLine();
            System.out.print("Введите название отдела: ");
            String department = in.nextLine();
            System.out.print("Введите величину зарплаты: ");
            float salary;
            salary = in.nextFloat();
            e.SetFIO(name);
            e.SetSalary(salary);
            e.SetDepartment(department);
            return e;
        } else {
            System.out.println("Свободных вакансий нет.");
            Employee noEmployee = new Employee(-1);
            return noEmployee;
        }
    }


}
