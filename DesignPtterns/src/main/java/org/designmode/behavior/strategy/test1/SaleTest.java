package org.designmode.behavior.strategy.test1;

import java.util.ArrayList;
import java.util.List;

public class SaleTest {
    public static void main(String[] args) {
        List<XiaoShouSale> xiaoShouSales = new ArrayList<XiaoShouSale>();
        xiaoShouSales.add(new PVIPUser());
        xiaoShouSales.add(new VIPUser());
        xiaoShouSales.add(new SVIPUser());
        XiaoShouSaleService shouSaleService = new XiaoShouSaleService(xiaoShouSales);
        shouSaleService.getSale("SVIP","sale");
    }
}
