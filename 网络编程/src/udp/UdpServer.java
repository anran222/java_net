package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author:xiang
 * @Date:2020/3/11 22:35
 * UDP单播接收数据
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
//        1、创建接收端的DatagramSocket对象
        DatagramSocket ds=new DatagramSocket(10000);
//        2、创建一个箱子用于接收数据
        byte[] bytes=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
//        3、调用DatagramSocket的方法接收数据并将数据放入箱子中
        ds.receive(dp);
//        4、解析数据包，并在控制台显示
        byte[] data=dp.getData();
        int length=dp.getLength();
        System.out.println(new String(data,0,length));
//        5、释放资源
        ds.close();
    }
}
