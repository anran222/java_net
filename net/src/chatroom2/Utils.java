package chatroom2;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author:xiang
 * @Date:2020/2/26 15:08
 * 工具类
 */
public class Utils {
     //释放资源

    public static void close(Closeable...targets){
        for (Closeable target:targets) {
                try {
                    if (null!=target) {
                        target.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
