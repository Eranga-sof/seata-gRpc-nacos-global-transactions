package cn.wolfcode.tx.stock.service.impl;

import cn.wolfcode.tx.stock.domain.Stock;
import cn.wolfcode.tx.stock.mapper.StockMapper;
import cn.wolfcode.tx.stock.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {
    @Override
    public void deduct(String commodityCode, int count) {

        Stock one = lambdaQuery().eq(Stock::getCommodityCode, commodityCode).one();
        if(one != null && one.getCount() < count){
            throw new RuntimeException("Not Enough count ...");
        }
        lambdaUpdate().setSql("count = count-" + count)
                .eq(Stock::getCommodityCode, commodityCode)
                .update();
    }
}
