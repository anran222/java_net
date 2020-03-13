package udpradiobroadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author:xiang
 * @Date:2020/3/13 14:55
 * UDP广播发送端
 */
public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds=new DatagramSocket();
        String s="hello world";
        byte[] bytes=s.getBytes();
        InetAddress address=InetAddress.getByName("255.255.255.255");
        int port=10000;
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,address,port);
        ds.send(dp);
        ds.close();

    }
}
