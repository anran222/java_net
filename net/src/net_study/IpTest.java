package net_study;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author:xiang
 * @Date:2020/2/24 16:49
 * ip
 */
public class IpTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr=InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());//返回ip地址
        System.out.println(addr.getHostName());//返回计算机名称
        //根据域名得到InetAddress对象
        addr=InetAddress.getByName("www.baidu.com");
        System.out.println(addr.getHostAddress());//返回百度服务器的ip地址
        System.out.println(addr.getHostName());//输出www.baidu.com
        //根据ip得到InetAddress对象
        addr=InetAddress.getByName("39.156.66.18");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
