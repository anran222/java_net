package net_study;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/24 22:34
 * 创建服务器
 * 1、指定端口，使用ServerSocket创建服务器
 * 2、阻塞式等待连接accpt
 *3、操作：输入输出流操作
 * 4、释放资源
 */
public class TcpServe {
    public static void main(String[] args) throws IOException {
       // 1、指定端口，使用ServerSocket创建服务器
        ServerSocket server=new ServerSocket(8888);
        //2、阻塞式等待连接accpt
        Socket client= server.accept();
        System.out.println("一个客户端建立了连接");
        //3、操作：输入输出流操作
        DataInputStream dis=new DataInputStream(client.getInputStream());
        String data=dis.readUTF();
        System.out.println(data);
        dis.close();
        client.close();
        server.close();
    }
}
