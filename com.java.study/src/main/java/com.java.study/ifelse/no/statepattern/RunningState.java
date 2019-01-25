package com.java.study.ifelse.no.statepattern;
import com.java.study.ifelse.no.statepattern.ClientMain.Context;
import com.java.study.ifelse.no.statepattern.ClientMain.LiftState;
//电梯在运行状态下能做哪些动作
public class RunningState extends LiftState {
    //电梯门关闭？这是肯定了
    @Override
    public void close() {
        //do nothing
    }
    //运行的时候 电梯不会打开
    @Override
    public void open() {
        //do nothing
    }
    //这是在运行状态下要实现的方法
    @Override
    public void run() {
        System.out.println("电梯running...");
    }
    //会运行，也会有停止
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState); //环境设置为停止状态；
        super.context.getLiftState().stop();
    }

}
