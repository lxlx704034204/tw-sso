package com.java.study.ifelse.no.statepattern;

//    原文：https://blog.csdn.net/u012401711/article/details/52675873
public class ClientMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }

    //资源汇聚
    public static class Context {
        //定义出所有的电梯状态
        public final static OpenningState openningState = new OpenningState();
        public final static ClosingState closeingState = new ClosingState();
        public final static RunningState runningState = new RunningState();
        public final static StoppingState stoppingState = new StoppingState();
        //定一个当前电梯状态
        private LiftState liftState;

        public LiftState getLiftState() {
            return liftState;
        }

        public void setLiftState(LiftState liftState) {
            this.liftState = liftState;
            //把当前的环境通知到各个实现类中
            this.liftState.setContext(this);
        }

        public void open() {
            this.liftState.open();
        }

        public void close() {
            this.liftState.close();
        }

        public void run() {
            this.liftState.run();
        }

        public void stop() {
            this.liftState.stop();
        }
    }

    //定义一个电梯的接口
    public static abstract class LiftState {
        //定义一个环境角色，也就是封装状态的变换引起的功能变化
        protected Context context;

        public void setContext(Context _context) {
            this.context = _context;
        }

        //首先电梯门开启动作
        public abstract void open();

        //电梯门有开启，那当然也就有关闭了
        public abstract void close();

        //电梯要能上能下，跑起来
        public abstract void run();

        //电梯还要能停下来，停不下来那就扯淡了
        public abstract void stop();
    }


}
