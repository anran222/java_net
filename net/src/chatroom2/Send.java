package chatroom2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/2/26 15:31
 * 发送端
 */
public class Send implements Runnable{
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;
    public Send(Socket client){
        this.client=client;
        console=new BufferedReader(new InputStreamReader(System.in));
        try {
            DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            this.release();
        }
    }
    @Override
    public void run() {
        while (isRunning){
            String msg=getStrFromConsole();
            if(!msg.equals("")){
                send(msg);
            }
        }
    }
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            release();
        }
    }

    private String getStrFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //释放资源
    private void release(){
        this.isRunning=false;
        Utils.close(dos,client);
    }
}
