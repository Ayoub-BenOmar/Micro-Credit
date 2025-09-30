import util.DBConnection;
import view.EmployeView;

public class Main {
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        EmployeView employeView = new EmployeView();
        employeView.createEmploye();
    }
}
