package com.java.study.ifelse.no.statepattern;
import com.java.study.ifelse.no.statepattern.ClientMain.Context;
import com.java.study.ifelse.no.statepattern.ClientMain.LiftState;
//电梯门关闭以后，电梯可以做哪些事情
public class ClosingState extends LiftState {
    //电梯门关闭，这是关闭状态要实现的动作
    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState); //电梯门=open
        super.context.getLiftState().open();
    }
    //电梯running,门是关闭的
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState); //设置为运行状态；
        super.context.getLiftState().run();
    }
    //电梯门关着， 不按楼层
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState); //设置为停止状态；
        super.context.getLiftState().stop();
    }

}
