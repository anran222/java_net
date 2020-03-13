package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author:xiang
 * @Date:2020/3/13 15:13
 * tcp客户端
 */
public class Client {
    public static void main(String[] args) throws Exception {
//        1、创建客户端的Socket对象（Socket）与指定服务端连接
        Socket socket=new Socket("127.0.0.1",10001);
//        2、获取IO输出流，写数据
        OutputStream os=socket.getOutputStream();
        os.write("hello world".getBytes());
//        3、释放资源
        os.close();
        socket.close();
    }
}
