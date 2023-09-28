
public class Main {
    public static void main(String[] args) {

        EmployeeBook Book = new EmployeeBook();

        Book.addEmployee("Бинг", "Чендлер", "", 25.3f, "отдел статистики");
        Book.addEmployee("Трибиани", "Джо", "", 20.3f, "отдел тетра и кино");
        Book.addEmployee("Геллер", "Росс", "", 26.3f, "отдел палеонтологии");
        Book.addEmployee("Бинг", "Моника", "", 24.9f, "отдел питания");
        Book.addEmployee("Буфэ", "Фиби", "", 23.5f, "рекреационные отдел");
        Book.addEmployee("Грин", "Рэйчел", "", 26.5f, "отдел моды");
        Book.addEmployee("Тиллер", "Гантер", "", 22.4f, "отдел питания");
        Book.addEmployee("Лорен", "Ральф", "", 22.4f, "отдел моды");

        MainMenu mainMenu = new MainMenu();
        mainMenu.menu(Book);

    }
}