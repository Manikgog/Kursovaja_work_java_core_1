public class Main {
    public static void main(String[] args) {
        EmployeeBook Book = new EmployeeBook();
        Book.AddEmployee("Chendler", 1, 20.5f, "statistics department");
        Book.AddEmployee("Ross", 2, 22f, "paleontologic department");
        Book.AddEmployee("Joe", 3, 15.4f, "department of actors");
        Book.AddEmployee("Monica", 4, 19.6f, "nutrition department");
        Book.AddEmployee("Rachel", 5, 23.2f, "fashion department");
        Book.AddEmployee("Fuibi", 6, 17.3f, "massage department");
        Book.PrintBook();
    }
}