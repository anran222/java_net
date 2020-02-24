package net_study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/24 22:55
 */
public class TcpLoginServe {
    public static void main(String[] args) throws IOException {
    // 1、指定端口，使用ServerSocket创建服务器
    ServerSocket server=new ServerSocket(8888);
    //2、阻塞式等待连接accpt
    Socket client= server.accept();
        System.out.println("一个客户端建立了连接");
    //3、操作：输入输出流操作
    DataInputStream dis=new DataInputStream(client.getInputStream());
    String datas=dis.readUTF();
    String username="";
    String password="";
    //分析
        String[] dataArray=datas.split("&");
        for (String info:dataArray) {
            String[] userInfo=info.split("=");
            if (userInfo[0].equals("username")){
                System.out.println("你的用户名为："+userInfo[1]);
                username=userInfo[1];
            }else if (userInfo[0].equals("password")){
                System.out.println("你的密码为："+userInfo[1]);
                password=userInfo[1];
            }
        }
        //输出
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        dos.flush();
        if (username.equals("xiang")&&password.equals("1234567")){
            dos.writeUTF("登录成功！");
        }else{
            dos.writeUTF("登录失败，请检查你的用户名和密码！");
        }
        dis.close();
        client.close();
        server.close();
}
}
