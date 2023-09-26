import java.text.NumberFormat;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class MainMenu {

    public void menu(EmployeeBook Book) {
        do {
            Menu menu = new Menu();
            String choice;
            do {
                choice = menu.menuMain();
            } while (!choice.equals("1") &&
                    !choice.equals("2") &&
                    !choice.equals("3") &&
                    !choice.equals("4") &&
                    !choice.equals("5") &&
                    !choice.equals("6") &&
                    !choice.equals("7") &&
                    !choice.equals("8") &&
                    !choice.equals("9") &&
                    !choice.equals("q") &&
                    !choice.equals("Q"));

            if(choice.equals("q") || choice.equals("Q"))
                break;

            int choice_ = choice.charAt(0);
            switch (choice_) {
                case 49 -> {
                    System.out.println("*******************************************************");
                    Book.printBook();
                    System.out.println("*******************************************************");
                }
                case 50 -> {
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                    System.out.println("Сумма затрат на зарплаты равна " + toMoneyFormat(Book.salaryCost()));
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                }
                case 51 -> {
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                    System.out.println("Работники с минимальной зарплатой");
                    printEmployeesWithSalary(Book, Book.minSalaryFind());
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                }
                case 52 -> {
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                    System.out.println("Работники с максимальной зарплатой");
                    printEmployeesWithSalary(Book, Book.maxSalaryFind());
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                }
                case 53 -> {
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                    System.out.println("Средняя зарплата равна " + toMoneyFormat(Book.averageSalary()));
                    System.out.println(ConsoleColors.TEXT_BRIGHT_YELLOW +
                            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" +
                            ConsoleColors.TEXT_RESET);
                }
                case 54 -> {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    Employee emp = addEmpl(Book);
                    Book.addEmployee(emp.getFIO(), emp.getSalary(), emp.getDepartment(), emp.getID());
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                }
                case 55 -> {
                    System.out.println("-------------------------------------------------------");
                    deleteEmployee(Book);
                    System.out.println("-------------------------------------------------------");
                }
                case 56 -> changeEmployee(Book);
                case 57 -> Book.printFIOByDepartment();
            }


        } while(true);
    }

    public static String toMoneyFormat(float cost){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(cost);
    }

    private void changeEmployee(EmployeeBook Book){
        System.out.print("Введите ID работника: ");
        Scanner in = new Scanner(System.in);
        int id = parseInt(in.nextLine());
        if(!Book.checkID(id)) {
            System.out.println("Работника с ID " + id + " нет.");
            return;
        }
        System.out.println("1. Изменить зарплату.");
        System.out.println("2. Изменить отдел.");
        System.out.println("Введите номер пункта: ");
        int n = parseInt(in.nextLine());
        if(n == 1){
            System.out.print("Введите новую зарплату работника: ");
            float salary = in.nextFloat();
            Book.changeEmployeeSalaryByID(id, salary);
        }else if(n == 2){
            System.out.print("Введите новый отдел работника: ");
            String dep = in.nextLine();
            Book.changeEmployeeDepartmentByID(id, dep);
        }
    }

    private void printEmployeesWithSalary(EmployeeBook Book, float salary){
        for(int i = 1; i <= 10; i++){
            if(Book.getEmployeeByID(i).getSalary() == salary){
                Book.getEmployeeByID(i).printEmployee();
            }
        }
    }

    private void deleteEmployee(EmployeeBook Book){
        System.out.println("Выберите вариант удаления:");
        System.out.println("1. Удаление по ID.");
        System.out.println("2. Удаление по ФИО.");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер пункта меню: ");
        int input = parseInt(in.nextLine());
        if(input == 1){
            System.out.print("Введите ID: ");
            input = parseInt(in.nextLine());
            if(Book.deleteEmployeeByID(input)){
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
                if (Book.deleteEmployeeByFIO(name)) {
                    System.out.println("Данные сотрудника " + name + " удалены.");
                }else{
                    System.out.println("Сотрудник с таким именем не найден.");
                }
            }
        }
    }

    private Employee addEmpl(EmployeeBook Book) {
        int id = Book.checkVacancy();
        if (id > 0) {
            Employee e = new Employee(id);
            Scanner in = new Scanner(System.in);
            System.out.print("Введите ФИО: ");
            String name = in.nextLine();
            System.out.print("Введите название отдела: ");
            String department = in.nextLine();
            System.out.print("Введите величину зарплаты: ");
            float salary;
            salary = (float)parseDouble(in.nextLine());
            e.setFIO(name);
            e.setSalary(salary);
            e.setDepartment(department);
            return e;
        } else {
            System.out.println("Свободных вакансий нет.");

            return new Employee(-1);
        }
    }


}
