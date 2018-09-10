package org.cn.behavior.strategy.test1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XiaoShouSaleService {

    Map<String,XiaoShouSale> map = new HashMap<String, XiaoShouSale>();

    public XiaoShouSaleService(List<XiaoShouSale> xiaoShouSaleList){
        for(XiaoShouSale xiaoShouSale : xiaoShouSaleList){
            map.put(xiaoShouSale.getDiscountType(),xiaoShouSale);
        }
    }

    public void getSale(String type,String name){
        map.get(type).getName(name);
    }
}
