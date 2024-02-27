package cn.wolfcode.tx.stock.controller;

import cn.wolfcode.tx.stock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stocks")
public class StockController {
    @Autowired
    private IStockService StockService;

    @Autowired
    private IStockService stockService;

    @GetMapping(value = "/deduct")
    public String deduct(String commodityCode, int count) {
        try {
            stockService.deduct(commodityCode, count);
        } catch (Exception exx) {
            exx.printStackTrace();
            return "FAIL";
        }
        return "SUCCESS";
    }
}
