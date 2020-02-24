package net_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Author:xiang
 * @Date:2020/2/24 20:05
 * 实现多次交流：发送端
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备数据一定转成字节数组
 * 3、封装成DatagramSocket包裹，需要指定目的地
 * 4、阻塞式发送包裹send（DatagramSocket p）
 * 5、释放资源
 */
public class UdpTalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中.......");
        // 1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //     * 2、准备数据一定转成字节数组
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        byte[] datas = data.getBytes();
        //   * 3、封装成DatagramSocket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
        // * 4、阻塞式发送包裹send（DatagramSocket p）
        client.send(packet);
        if (data.equals("exit")) {
            break;
        }
    }
      //          5、释放资源
        client.close();
    }
}
