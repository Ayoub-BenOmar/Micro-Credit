import util.DBConnection;
import view.EmployeView;
import view.ProfessionnelView;

public class Main {
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        EmployeView employeView = new EmployeView();
        ProfessionnelView professionnelView = new ProfessionnelView();
        professionnelView.delete();
    }
}
