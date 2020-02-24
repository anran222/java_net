package net_study;

/**
 * @Author:xiang
 * @Date:2020/2/24 21:47
 * 加入多线程实现双向交流
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkServe(9999)).start();
        new Thread(new TalkSend(5555,"localhost",8888)).start();
    }
}
