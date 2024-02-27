package cn.wolfcode.tx.account.service.impl;

import cn.wolfcode.tx.account.domain.Account;
import cn.wolfcode.tx.account.mapper.AccountMapper;
import cn.wolfcode.tx.account.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public void reduce(String userId, int money) {
        Account one = lambdaQuery().eq(Account::getUserId, userId).one();
        if(one != null && one.getMoney() < money){
            throw new RuntimeException("Not Enough Money ...");
        }
        lambdaUpdate().setSql("money = money - " + money)
                        .eq(Account::getUserId, userId)
                                .update();
    }
}
