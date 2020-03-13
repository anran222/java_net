package uploadFiles;

import java.io.*;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/3/13 16:10
 * 上传文件客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",10002);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\网络编程\\src\\uploadFiles\\b.jpg"));
        OutputStream os=socket.getOutputStream();
        BufferedOutputStream bos=new BufferedOutputStream(os);
        int b;
        while ((b=bis.read())!=1){
            bos.write(b);
        }
        socket.shutdownOutput();
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }

        socket.close();
        bis.close();
    }
}
