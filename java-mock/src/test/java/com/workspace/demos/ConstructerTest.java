package com.workspace.demos;

import com.workspace.demos.basic.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Main.class)
public class ConstructerTest {

    @Test
    public void testConstructor() throws Exception {
        Employee e = new Employee("B", 2);
        PowerMockito.whenNew(Employee.class).withNoArguments().thenReturn(e);

        Main main = new Main();
        Employee e1 = main.getEmp();

        System.out.println("e1 = " + e1);
    }

    @Test
    public void testConstructor2() throws Exception {
        Employee e = PowerMockito.mock(Employee.class);
        PowerMockito.whenNew(Employee.class).withNoArguments().thenReturn(e);
        PowerMockito.when(e.toString()).thenReturn("Mocked output");

        Main main = new Main();
        Employee e1 = main.getEmp();

        System.out.println("e1 = " + e1);
    }

}
