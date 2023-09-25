import java.text.NumberFormat;
import java.util.Scanner;

public class MainMenu {

    public void Menu(EmployeeBook Book) {
        do {
            Menu menu = new Menu();
            int choice;
            do {
                choice = menu.MenuMain();
            } while (choice < 1 || choice > 10);

            switch (choice) {
                case 1 -> {
                    System.out.println("*******************************************************");
                    Book.PrintBook();
                    System.out.println("*******************************************************");
                }
                case 2 -> {
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println("Сумма затрат на зарплаты равна " + toMoneyFormat(Book.SalaryCost()));
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
                case 3 -> {
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println("Работники с минимальной зарплатой");
                    PrintEmployeesWithSalary(Book, Book.MinSalaryFind());
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
                case 4 -> {
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println("Работники с максимальной зарплатой");
                    PrintEmployeesWithSalary(Book, Book.MaxSalaryFind());
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
                case 5 -> {
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println("Средняя зарплата равна " + toMoneyFormat(Book.AverageSalary()));
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
                case 6 -> {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    Employee emp = AddEmpl(Book);
                    Book.AddEmployee(emp.GetFIO(), emp.GetSalary(), emp.GetDepartment(), emp.GetID());
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                }
                case 7 -> {
                    System.out.println("-------------------------------------------------------");
                    DeleteEmployee(Book);
                    System.out.println("-------------------------------------------------------");
                }
                case 8 -> ChangeEmployee(Book);
                case 9 -> Book.PrintFIOByDepartment();
            }

            if(choice == 10)
                break;
        } while(true);
    }

    public static String toMoneyFormat(float cost){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cost);
    }

    private void ChangeEmployee(EmployeeBook Book){
        System.out.print("Введите ID работника:");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        if(!Book.CheckID(id)) {
            System.out.println("Работника с ID " + id + " нет.");
            return;
        }
        System.out.println("1. Изменить зарплату.");
        System.out.println("2. Изменить отдел.");
        System.out.println("Введите номер пункта: ");
        int n = in.nextInt();
        if(n == 1){
            System.out.print("Введите новую зарплату работника: ");
            float salary = in.nextFloat();
            Book.ChangeEmployeeSalaryByID(id, salary);
        }else if(n == 2){
            System.out.print("Введите новый отдел работника: ");
            String dep = in.nextLine();
            Book.ChangeEmployeeDepartmentByID(id, dep);
        }
    }

    private void PrintEmployeesWithSalary(EmployeeBook Book, float salary){
        for(int i = 1; i <= 10; i++){
            if(Book.GetEmployeeByID(i).GetSalary() == salary){
                Book.GetEmployeeByID(i).PrintEmployee();
            }
        }
    }

    private void DeleteEmployee(EmployeeBook Book){
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
            }
        }else if(input == 2){
            System.out.print("Введите ФИО: ");
            String name;
            Scanner in_ = new Scanner(System.in);
            name = in_.nextLine();
            if(name.equals("")){
                System.out.println("Вы ввели пустую строку");
            }
            else {
                if (Book.DeleteEmployeeByFIO(name)) {
                    System.out.println("Данные сотрудника " + name + " удалены.");
                }else{
                    System.out.println("Сотрудник с таким именем не найден.");
                }
            }
        }
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

            return new Employee(-1);
        }
    }


}
