package com.workspace.demos.basic;

/**
 * Created by deepak.barr on 02/06/15.
 */
public class StockManager {

    private StockService stockService;

    public StockManager(StockService stockService) {
        this.stockService = stockService;
    }

    public long getValue(int units) {
        return units * stockService.getPrice("");
    }
}
