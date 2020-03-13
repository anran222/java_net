package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/3/13 15:22
 * Tcp服务端
 */
public class Server {
    public static void main(String[] args) throws Exception {
//        1、创建服务器端的Socket对象（ServerSocket）
        ServerSocket ss=new ServerSocket(10001);
//        2、监听客户端连接，返回一个Socket
        Socket accept=ss.accept();
//        3、获取输入流，读数据，并把数据显示在控制台
        InputStream is=accept.getInputStream();
        int b;
        while ((b=is.read())!=-1){
            System.out.print((char)b);
        }
//        4、释放资源
        is.close();
        ss.close();
    }
}
