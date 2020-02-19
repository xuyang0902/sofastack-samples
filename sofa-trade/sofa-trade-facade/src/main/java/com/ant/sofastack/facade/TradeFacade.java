package com.ant.sofastack.facade;

import com.ant.sofastack.facade.model.TradeReq;
import com.ant.sofastack.facade.model.TradeRes;

/**
 * @author xu.qiang
 * @date 20/2/15
 */
public interface TradeFacade {

    /**
     * 交易请求
     * @param tradeReq
     * @return
     */
    TradeRes buy(TradeReq tradeReq);

}
