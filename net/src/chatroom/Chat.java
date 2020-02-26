package chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/25 17:07
 * 在线聊天室：客户端
 * 使用多线程实现多个客户正常收发消息
 */
public class Chat {
    public static void main(String[] args) throws IOException {
        ServerSocket serve = new ServerSocket(8888);
        //2、阻塞式等待连接accept
        while (true) {
            Socket client = serve.accept();
            System.out.println("一个客户端已连接");
            new Thread(()->{
               DataInputStream dis=null;
               DataOutputStream dos=null;
                try {
                    dis=new DataInputStream(client.getInputStream());
                    dos=new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    //3、接收消息
                    String datas = null;
                    try {
                        datas = dis.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //4、返回消息
                    try {
                        dos.writeUTF(datas);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //5、释放资源
                    try {
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        isRunning = false;
                    }
                }
                try {
                    if(null!=dos) {
                        dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(null!=dis) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (null!=client) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
