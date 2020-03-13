package udpmulticast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author:xiang
 * @Date:2020/3/12 21:11
 * UDP组播发送端
 */
public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds=new DatagramSocket();
        String s="hello world";
        byte[] bytes=s.getBytes();
        InetAddress address=InetAddress.getByName("224.0.1.0");
        int port=10000;
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,address,port);
        ds.send(dp);
        ds.close();
    }
}
