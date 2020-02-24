package net_study;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:xiang
 * @Date:2020/2/24 19:27
 * 网络爬虫原理
 */
public class WebSpider {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url=new URL("https://www.jd.com");
        //下载资源
        InputStream is=url.openStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));
        String msg=null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理

    }
}
