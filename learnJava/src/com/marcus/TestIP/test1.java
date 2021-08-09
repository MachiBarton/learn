package com.marcus.TestIP;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class test1 {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress1);

        InetAddress inetAddress2 = InetAddress.getLocalHost();
        System.out.println(inetAddress2);

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",8080);

        System.out.println(socketAddress);
        System.out.println(socketAddress1);

        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getPort());
    }
}
