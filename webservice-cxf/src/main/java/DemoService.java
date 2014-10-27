import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by deepak on 10/21/14.
 */

@WebService
public interface DemoService {

    @WebMethod
    public String insertEmployee(Employee emp);

    @WebMethod
    public Employee getEmployee(String id);
}