package cn.wolfcode.tx.order.controller;

import cn.wolfcode.tx.order.domain.Order;
import cn.wolfcode.tx.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping(value = "/create")
    public String create(String userId, String commodityCode, int orderCount) {
        try {
            orderService.create(userId, commodityCode, orderCount);
        } catch (Exception exx) {
            exx.printStackTrace();
            return "FAIL";
        }
        return "SUCCESS";
    }
}
