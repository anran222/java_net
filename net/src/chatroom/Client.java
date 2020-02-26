package chatroom;

import java.io.*;
import java.net.ServerSocket;
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
        BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning=true;
        while (isRunning) {
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            //3、获取消息
            msg = dis.readUTF();
            System.out.println(msg);
        }
        dos.close();
        dis.close();
        client.close();

    }
}
