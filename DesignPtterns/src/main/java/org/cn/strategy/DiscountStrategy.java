package org.cn.strategy;

/**
 * 策略模式用于封装系列的算法， 这些算法通常被封装在一个被称为Context的类中，
 * 客户端程序可以自由选择其中一种算法，或让Context为客户选择义哥最佳的算法
 * 使用策略模式的优势是为了支持算法的自由切换
 *
 * 以下场景：假如正在开发一个网上书店，该书店为了更好的促销，经常对图书进行打折
 * 促销，程序需考虑各种打折促销的计算方法
 */

/**
 * 这是一个打折算法的接口
 */
public interface DiscountStrategy {
   //定义一个用于计算打折价的接口
   double getDiscount(double originPrice);
}
