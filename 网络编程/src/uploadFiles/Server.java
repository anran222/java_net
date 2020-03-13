package uploadFiles;

import javax.management.MBeanAttributeInfo;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/3/13 16:10
 * 上传文件服务器端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10002);
        Socket accept=ss.accept();
        BufferedInputStream bis=new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("uploadFiles1/copy.jpg"));
        int b;
        while ((b=bis.read())!=-1){
            bos.write(b);
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("上传成功！");
        bw.newLine();
        bw.flush();
        bos.close();
        accept.close();
        ss.close();
    }
}
