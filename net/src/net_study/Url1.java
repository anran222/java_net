package net_study;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:xiang
 * @Date:2020/2/24 19:15
 * URL:统一资源定位符，区分资源
 * 1、协议
 * 2、域名或计算机名
 * 3、端口
 * 4、请求资源
 */
public class Url1 {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("https://www.bilibili.com/video/av59814573?p=238");
        System.out.println("协议:"+url.getProtocol());
        System.out.println("域名|ip:"+url.getHost());
        System.out.println("端口;"+url.getPort());
        System.out.println("请求资源1："+url.getFile());
        System.out.println("请求资源1："+url.getPath());
        //参数
        System.out.println("参数："+url.getQuery());
        //锚点
        System.out.println("锚点："+url.getRef());
    }
}
