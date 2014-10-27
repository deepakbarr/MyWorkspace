import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by deepak on 10/21/14.
 */

@XmlRootElement(name = "employee")
public class Employee implements Serializable {
    private long empId;
    private String empName;

    public Employee(long empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
