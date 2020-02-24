package net_study;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author:xiang
 * @Date:2020/2/24 20:04
 * 实现多次交流：接收端
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备容器 封装成DatagramSocket包裹
 * 3、阻塞式接受包裹receive（DatagramSocket p）
 * 4、分析数据
 * 5、释放资源
 */
public class UdpTalkServe {
    public static void main(String[] args) throws Exception{
        System.out.println("接受方启动中。。。。。");
        // 1、使用DatagramSocket 指定端口 创建接收端
        DatagramSocket serve=new DatagramSocket(9999);
        while (true) {
            //2、准备容器 封装成DatagramSocket包裹
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3、阻塞式接受包裹receive（DatagramSocket p）
            serve.receive(packet);
            //4、分析数据
            byte[] datas = packet.getData();
            int len = packet.getLength();
            String data=new String(datas,0,len);
            System.out.println(data);
            if (data.equals("exit")){
                break;
            }
        }
    //  5、释放资源
        serve.close();
    }
}
