package com.java.study.ifelse.no.strategy3.zhuangtai;

/**
 *         原文：https://blog.csdn.net/liuchang840302/article/details/83894907
 */
public class testClient {
    public static void main(String[] args) {
        StateController controller = new StateController();
        //设置状态
        controller.onLine();
        //省去了很多if-else的结构
        controller.run();
        controller.drive();
        controller.back();

    }

    /** Controller **/
    public static class StateController implements State {
        Function func;
        public void setState(Function c) {
            this.func = c;
        }

        @Override
        public void offLine() {
            //设置不同的状态
            setState(new OffLineState());
        }
        @Override
        public void onLine() {
            //设置不同的状态
            setState(new OnLineState());
        }

        public void drive() {
            func.drive();
        }
        public void run() {
            func.run();
        }
        public void back() {
            func.back();
        }
    }

    /** 状态接口 **/
    public interface State {
        void offLine();
        void onLine();
    }

    /** 功能接口 **/
    public interface Function {
        void drive();
        void run();
        void back();
    }


    /** 在线状态实现接口 **/
    static class OnLineState implements Function {
        @Override
        public void drive() {
            System.out.print("在线的drive");
        }
        @Override
        public void run() {
            System.out.print("在线的run");
        }
        @Override
        public void back() {
            System.out.print("在线的back");
        }
    }

    /** 离线状态实现接口 **/
    public static class OffLineState implements Function {
        @Override
        public void drive() {
            System.out.print("不在线的drive");
        }
        @Override
        public void run() {
            System.out.print("不在线的run");
        }
        @Override
        public void back() {
            System.out.print("不在线的back");
        }
    }

}
