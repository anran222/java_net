package chatroom2;

import java.io.*;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/25 17:07
 * 在线聊天室：服务器端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、建立连接 使用ServerSocket创建客户端+服务器的地址和端口
        Socket client=new Socket("localhost",8888);
        //2、客户端发送消息
        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();
    }
}
