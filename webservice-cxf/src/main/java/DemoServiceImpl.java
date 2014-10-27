import javax.jws.WebService;

/**
 * Created by deepak on 10/21/14.
 */

@WebService(endpointInterface = "com.aranin.weblog4j.services.BookShelfService",
        serviceName = "employeeService")
public class DemoServiceImpl implements DemoService {

    public String insertEmployee(Employee emp) {
        return "dummy";
    }

    public Employee getEmployee(String title) {
        return new Employee(10l,"dummy");  //To change body of implemented methods use File | Settings | File Templates.
    }
}
