package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author:xiang
 * @Date:2020/3/11 22:20
 * UDP单播发送数据
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        //1、创建发送端DatagramSocket对
            DatagramSocket ds=new DatagramSocket();
        //2、创建数据，并把数据打包（DatagramPacket）
        String s="礼物";
        byte[] bytes=s.getBytes();
        InetAddress address=InetAddress.getByName("127.0.0.1");
        int port=10000;
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,address,port);
        //3、调用DatagramSocket对象的方法发送数据
        ds.send(dp);
        //4、释放资源
        ds.close();
    }
}
