package com.java.study.ifelse.no.strategy3.celue;

public class Example {

    /**
     *
     *描述：计算用户所付金额
     */
    public Double calRecharge(Double charge , ClientMain.RechargeTypeEnum type ){
        if(type.equals(ClientMain.RechargeTypeEnum.E_BANK)){
            return charge*0.85;
        }else if(type.equals(ClientMain.RechargeTypeEnum.BUSI_ACCOUNTS)){
            return charge*0.90;
        }
//        else if(type.equals(RechargeTypeEnum.MOBILE)){
//            return charge;
//        }else if(type.equals(RechargeTypeEnum.CARD_RECHARGE)){
//            return charge+charge*0.01;
//        }
        else{
            return null;
        }

    }
}