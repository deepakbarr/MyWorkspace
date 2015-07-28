package com.workspace.demos;

import com.workspace.demos.basic.StockManager;
import com.workspace.demos.basic.StockService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.mockito.Matchers.anyString;

/**
 * Created by deepak.barr on 02/06/15.
 */


public class StockTest extends TestCase {

    public StockTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(ConstructerTest.class);
    }

    public void testStock() throws Exception {
        StockService stockService = PowerMockito.mock(StockService.class);
        PowerMockito.when(stockService.getPrice(anyString())).thenReturn(2l);
        StockManager stockManager = new StockManager(stockService);
        System.out.println(stockManager.getValue(10));
    }
}