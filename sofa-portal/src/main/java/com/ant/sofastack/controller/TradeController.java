package com.ant.sofastack.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.ant.sofastack.facade.TradeFacade;
import com.ant.sofastack.facade.model.TradeReq;
import com.ant.sofastack.facade.model.TradeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author xu.qiang
 * @date 20/2/15
 */
@RestController
public class TradeController {



    //使用了SofaReference后不需要再用  @Autowired
    @SofaReference(interfaceType = TradeFacade.class,
            uniqueId = "",//目标服务设定的唯一ID
            binding = @SofaReferenceBinding(bindingType = "bolt"))
    private TradeFacade tradeFacade;

    @GetMapping("/trade/buy")
    public TradeRes buy(HttpServletRequest request){

        TradeReq tradeReq = new TradeReq();
        tradeReq.setToken(UUID.randomUUID().toString());
        tradeReq.setUserId("110");
        tradeReq.setProductId("009001");
        tradeReq.setAmount(new BigDecimal("8888"));
        TradeRes buy = tradeFacade.buy(tradeReq);

        return buy;
    }
}
