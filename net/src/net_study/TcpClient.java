package net_study;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/24 22:39
 * 创建客户端
 * 1、建立连接，使用ServerSocket创建客户端+服务器的地址和端口
 *2 、操作：输入输出流操作
 * 3、释放资源
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1、建立连接，使用ServerSocket创建客户端+服务器的地址和端口
        Socket  client=new Socket("localhost",8888);
        //2 、操作：输入输出流操作
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        String data="hello";
        dos.writeUTF(data);
        dos.flush();
        //、释放资源
        dos.close();
    }
}
