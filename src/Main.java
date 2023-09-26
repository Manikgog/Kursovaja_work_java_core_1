
public class Main {
    public static void main(String[] args) {

        EmployeeBook Book = new EmployeeBook();

        Book.addEmployee("Chandler Bing", 25.3f, "statistic department", Book.checkVacancy());
        Book.addEmployee("Joe Tribiany", 15.3f, "department of actors", Book.checkVacancy());
        Book.addEmployee("Ross Geller", 26.3f, "paleonthologic department", Book.checkVacancy());
        Book.addEmployee("Monica Bing", 24.2f, "nutrition department", Book.checkVacancy());
        Book.addEmployee("Fuiby Buffee", 20.3f, "massage department", Book.checkVacancy());
        Book.addEmployee("Rachel Grin", 23.3f, "fashion department", Book.checkVacancy());
        Book.addEmployee("Ganter Tiler", 13.3f, "nutrition department", Book.checkVacancy());
        Book.addEmployee("Ralf Loren", 13.3f, "fashion department", Book.checkVacancy());

        MainMenu mainMenu = new MainMenu();
        mainMenu.menu(Book);
        /*
        Book.PrintBook();

        System.out.println("Работник с минимальной зарплатой:");
        Book.MinSalaryFind().PrintEmployee();
        System.out.println("Работник с максимальной зарплатой:");
        Book.MaxSalaryFind().PrintEmployee();
        System.out.println("Затраты на зарплату - " + Book.SalaryCost());
        System.out.println("Средняя зарплата - " + Book.AverageSalary());
        Book.PrintBookByFIO();
        System.out.println("--------------------------------------");
        Book.DeleteEmployeeByFIO("Joe");
        Book.PrintBookByFIO();
        System.out.println("--------------------------------------");
        Book.AddEmployee("Joe", 15.3f, "department of actors");
        Book.PrintBookByFIO();
        System.out.println("--------------------------------------");
        Book.GetEmployeeByID(2).PrintEmployee();
        Book.ChangeEmployeeSalaryByID(2, 16.7f);
        Book.GetEmployeeByID(2).PrintEmployee();
        Book.ChangeEmployeeDepartmentByID(2, "advertising department");
        Book.GetEmployeeByID(2).PrintEmployee();
        Book.PrintFIOByDepartment();
        */
    }
}