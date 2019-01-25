package com.java.study.ifelse.no.strategy3.celue;

import java.util.HashMap;
import java.util.Map;

/** 客户端调用
 * 来源：
 * https://blog.csdn.net/liuchang840302/article/details/83894907
 * https://github.com/wovert/DesignPattern/blob/358429258dc990878d35baed29494bc35b674783/java/strategy/README.md
 * **/
public class ClientMain {

    public static void main(String[] args) {

        //★★★在Context环境中进行 值传递, 然后计算★★★ 都调用一个接口，各自用不同的实现
        Context context = new Context();

        // 网银充值100 需要付多少
        Double money = context.valuePass(100D, RechargeTypeEnum.E_BANK.value());
        System.out.println(money);

        // 商户账户充值100 需要付多少
        Double money2 = context.valuePass(100D, RechargeTypeEnum.BUSI_ACCOUNTS.value());
        System.out.println(money2);

//        // 手机充值100 需要付多少
//        Double money3 = context.calRecharge(100D, RechargeTypeEnum.MOBILE.value());
//        System.out.println(money3);
//
//        // 充值卡充值100 需要付多少
//        Double money4 = context.calRecharge(100D, RechargeTypeEnum.CARD_RECHARGE.value());
//        System.out.println(money4);
    }



    /**
     *描述：场景类
     */
    public static class Context {
        private Strategy strategy;

        public Double valuePass(Double charge, Integer type) {
            strategy = StrategyFactory.getInstance().creator(type);
            return strategy.commonInterface(charge, RechargeTypeEnum.valueOf(type));
        }

        public Strategy getStrategy() {
            return strategy;
        }
        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }
    }

    /** 策略接口类 **/
    public static interface Strategy {
        public Double commonInterface(Double charge ,RechargeTypeEnum type );
    }


    /**
     *描述：策略工厂 使用单例模式
     */
    public static class StrategyFactory {

        private static StrategyFactory factory = new StrategyFactory();
        private StrategyFactory() {}

        private static Map<Integer ,Strategy> strategyMap = new HashMap<>();

        static {
            strategyMap.put(RechargeTypeEnum.E_BANK.value(), new ObjectEBank());
            strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new ObjectBusiAcct());
//        strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategy());
//        strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new CardStrategy());
        }

        public Strategy creator(Integer type){
            return strategyMap.get(type);
        }

        public static StrategyFactory getInstance(){
            return factory;
        }
    }






    /** 策略B **/
    public static class ObjectBusiAcct implements Strategy{
        @Override
        public Double commonInterface(Double charge, RechargeTypeEnum type) {
            return charge*0.90;
        }
    }
    /** 策略A **/
    public static class ObjectEBank implements Strategy{
        @Override
        public Double commonInterface(Double charge, RechargeTypeEnum type) {
            return charge*0.85;
        }
    }






    public enum RechargeTypeEnum {

        E_BANK(1, "网银"),
        BUSI_ACCOUNTS(2, "商户账号"),
        MOBILE(3,"手机卡充值"),
        CARD_RECHARGE(4,"充值卡");

        /**
         *状态值
         */
        private int value;

        /**
         * 类型描述
         */
        private String description;

        private RechargeTypeEnum(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int value() {
            return value;
        }
        public String description() {
            return description;
        }

        public static RechargeTypeEnum valueOf(int value) {
            for(RechargeTypeEnum type : RechargeTypeEnum.values()) {
                if(type.value() == value) {
                    return type;
                }
            }
            return null;
        }
    }

}