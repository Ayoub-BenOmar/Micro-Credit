import repository.CreditRepository;
import service.EcheanceService;
import util.DBConnection;
import view.CreditView;
import view.EmployeView;
import view.ProfessionnelView;

public class Main {
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();

        EcheanceService echeanceService = new EcheanceService();
        echeanceService.updatePaymentStatusAutomatically();

        EmployeView employeView = new EmployeView();

        ProfessionnelView professionnelView = new ProfessionnelView();

        CreditView creditView = new CreditView();

        CreditRepository creditRepository = new CreditRepository();
        creditView.createCreditView();
    }
}
