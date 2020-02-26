package chatroom2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/26 15:32
 * 接收端
 */
public class Receive implements Runnable {
    private DataInputStream dis;
      private Socket client;
    private boolean isRunning;

    public Receive(Socket client){
        this.client=client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            release();
        }
    }
    @Override
    public void run() {
        while (isRunning){
            String msg=receive();
            if (!msg.equals("")){
                System.out.println(msg);
            }
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
    private void release(){
        this.isRunning=false;
        Utils.close(dis,client);
    }
}
