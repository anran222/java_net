package net_study;

import java.io.*;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/24 22:55
 */
public class TcpLoginClient {
    public static void main(String[] args) throws IOException {
        BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String username=console.readLine();
        System.out.println("请输入密码：");
        String password=console.readLine();
        //1、建立连接，使用ServerSocket创建客户端+服务器的地址和端口
        Socket client=new Socket("localhost",8888);
        //2 、操作：输入输出流操作
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        dos.writeUTF("username="+username+"&"+"password="+password);
        dos.flush();
        DataInputStream dis=new DataInputStream(client.getInputStream());
        String result=dis.readUTF();
        System.out.println(result);
        //、释放资源
        dos.close();
        client.close();
    }
}
