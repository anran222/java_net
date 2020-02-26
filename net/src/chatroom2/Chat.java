package chatroom2;

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
            new Thread(new Channel(client)).start();
        }
    }
    static class Channel implements Runnable{
        private DataInputStream dis=null;
        private DataOutputStream dos=null;
        private Socket client;
        private boolean isRunning;
        //接收消息
        public Channel(Socket client){
            this.client=client;
            try {
                dis=new DataInputStream(client.getInputStream());
                dos=new DataOutputStream(client.getOutputStream());
                isRunning=true;
            } catch (IOException e) {
                release();
            }
        }
        private String receive(){
            String msg="";
            try {
                msg= dis.readUTF();
            } catch (IOException e) {
                release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                release();
            }
        }
        //释放资源
        private void release(){
            this.isRunning=false;
            Utils.close(dis,dos,client);
        }
        @Override
        public void run() {
            while (isRunning){
                String msg=receive();
                if (!msg.equals("")){
                    send(msg);
                }
            }
        }
    }
}
