package net_study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author:xiang
 * @Date:2020/2/24 21:32
 * 接收端：使用面向对象封装
 */
public class TalkServe implements Runnable {
    private DatagramSocket serve;
    private int port;
    public TalkServe(int port) {
        try {
            serve = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            //2、准备容器 封装成DatagramSocket包裹
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3、阻塞式接受包裹receive（DatagramSocket p）
            try {
                serve.receive(packet);
                //4、分析数据
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String data=new String(datas,0,len);
                System.out.println(data);
                if (data.equals("exit")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //  5、释放资源
        serve.close();
    }
}
