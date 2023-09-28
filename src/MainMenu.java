import java.text.NumberFormat;
import java.util.Scanner;
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
                    addEmpl(Book);
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

        System.out.println("1. Изменить зарплату.");
        System.out.println("2. Изменить отдел.");
        System.out.print("Введите номер пункта: ");
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
        for(int i = 0; i < Book.getSize(); i++){
            if(Book.getEmployeeByID(i).getSalary() == salary){
                System.out.println(Book.getEmployeeByID(i).toString());
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
            String[] FIO = this.enterFIO();
            int len = FIO.length;
            if(len == 3) {
                if (Book.deleteEmployeeByFIO(FIO[0], FIO[1], FIO[2])) {
                    System.out.println("Данные сотрудника " + FIO[0] + " " + FIO[1] + " " + FIO[2] + " удалены.");
                } else {
                    System.out.println("Сотрудник с таким именем не найден.");
                }
            }
            else if(len == 2){
                if (Book.deleteEmployeeByFIO(FIO[0], FIO[1], "")) {
                    System.out.println("Данные сотрудника " + FIO[0] + " " + FIO[1] + " " + " удалены.");
                } else {
                    System.out.println("Сотрудник с таким именем не найден.");
                }
            }
            else if(len == 1){
                if (Book.deleteEmployeeByFIO(FIO[0], "", "")) {
                    System.out.println("Данные сотрудника " + FIO[0] + " удалены.");
                } else {
                    System.out.println("Сотрудник с таким именем не найден.");
                }
            }
        }
    }

    private String[] enterFIO(){
        System.out.print("Введите фамилию: ");
        String lastName;
        String name;
        String surName;
        Scanner in_ = new Scanner(System.in);
        lastName = in_.nextLine();
        System.out.print("Введите имя: ");
        name = in_.nextLine();
        System.out.print("Введите отчество: ");
        surName = in_.nextLine();
        return new String[]{lastName, name, surName};
    }

    private void addEmpl(EmployeeBook Book) {
        if (Book.getSize() < Book.getCapacity()) {

            String[] FIO = this.enterFIO();
            if(Book.checkSameFIO(FIO)){
                System.out.println("Такой работник уже есть.");
                return;
            }
            System.out.print("Введите название отдела: ");
            String department = this.enterDepartment();

            System.out.print("Введите величину зарплаты: ");
            float salary = enterSalary();
            int len = FIO.length;
            if(len == 3) {
                Book.addEmployee(FIO[0], FIO[1], FIO[2], salary, department);
            }
            else if(len == 2){
                Book.addEmployee(FIO[0], FIO[1], "", salary, department);
            }else if(len == 1){
                Book.addEmployee(FIO[0], "", "", salary, department);
            }
            return;
        }
        System.out.println("Свободных вакансий нет.");
        return;
    }

    private String enterDepartment(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private float enterSalary(){
        Scanner input = new Scanner(System.in);
        return input.nextFloat();
    }

    @Override
    public String toString() {
        return "MainMenu{}";
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
