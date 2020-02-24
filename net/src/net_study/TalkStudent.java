package net_study;

/**
 * @Author:xiang
 * @Date:2020/2/24 21:47
 * 加入多线程实现双向交流
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkServe(8888)).start();
    }
}
