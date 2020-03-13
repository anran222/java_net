package udpradiobroadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author:xiang
 * @Date:2020/3/13 14:59
 * udp广播接收端
 */
public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds=new DatagramSocket(10000);
        DatagramPacket dp=new DatagramPacket(new byte[1024],1024);
        ds.receive(dp);
        byte[] data=dp.getData();
        int length=dp.getLength();
        System.out.println(new String(data,0,length));
        ds.close();
    }
}
