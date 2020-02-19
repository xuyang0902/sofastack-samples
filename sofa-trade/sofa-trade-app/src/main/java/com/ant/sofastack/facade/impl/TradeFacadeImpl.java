package com.ant.sofastack.facade.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.ant.sofastack.facade.TradeFacade;
import com.ant.sofastack.facade.model.TradeReq;
import com.ant.sofastack.facade.model.TradeRes;
import org.springframework.stereotype.Service;

/**
 * @author xu.qiang
 * @date 20/2/15
 */
@Service
@SofaService(
        interfaceType = TradeFacade.class,
        uniqueId = "",//本服务的唯一ID
        bindings = {
                @SofaServiceBinding(bindingType = "bolt",timeout = 6000),
                @SofaServiceBinding(bindingType = "rest")
        }
)
public class TradeFacadeImpl implements TradeFacade {

    @Override
    public TradeRes buy(TradeReq tradeReq) {
        System.out.println(tradeReq);

        TradeRes tradeRes = new TradeRes();
        tradeRes.setStatus(-1);
        tradeRes.setFailReason("token过期无法交易");
        return tradeRes;
    }

}
