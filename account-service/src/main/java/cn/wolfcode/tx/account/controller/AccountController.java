package cn.wolfcode.tx.account.controller;

import cn.wolfcode.tx.account.domain.Account;
import cn.wolfcode.tx.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping(value = "/reduce")
    public String reduce(String userId, int money) {
        try {
            accountService.reduce(userId, money);
        } catch (Exception exx) {
            exx.printStackTrace();
            return "FAIL";
        }
        return "SUCCESS";
    }

}
