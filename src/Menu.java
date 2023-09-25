import java.util.Scanner;

public class Menu {

    public int MenuMain() {
        System.out.println("Меню действий со списком сотрудников:");
        System.out.println("1. Получить список всех сотрудников.");
        System.out.println("2. Посчитать сумму затрат на зарплаты.");
        System.out.println("3. Найти сотрудника с минимальной заплатой.");
        System.out.println("4. Найти сотрудника с максимальной зарплатой.");
        System.out.println("5. Подсчитать среднее значение зарплат.");
        System.out.println("6. Добавить нового сотрудника.");
        System.out.println("7. Удалить сотрудника.");
        System.out.println("8. Изменить сотрудника.");
        System.out.println("9. Напечатать список отделов и ФИО их сотрудников.");
        System.out.println("10. Выход из программы.");

        System.out.print("Введите номер пункта -> ");
        Scanner in = new Scanner(System.in);

        return in.nextInt();
    }


}
