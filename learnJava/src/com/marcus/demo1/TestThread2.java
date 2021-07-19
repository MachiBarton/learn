package com.marcus.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread {

    private final String url;
    private final String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test1.png");
        TestThread2 t2 = new TestThread2("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test2.png");
        TestThread2 t3 = new TestThread2("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test3.png");
        TestThread2 t4 = new TestThread2("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test4.png");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}


