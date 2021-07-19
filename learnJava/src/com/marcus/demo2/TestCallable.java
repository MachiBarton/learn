package com.marcus.demo2;


import com.marcus.demo1.WebDownLoader;

import java.util.concurrent.*;

// 线程创建方式三 ：实现callable接口
public class TestCallable implements Callable<Boolean> {

    private final String url;
    private final String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test1.png");
        TestCallable t2 = new TestCallable("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test2.png");
        TestCallable t3 = new TestCallable("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test3.png");
        TestCallable t4 = new TestCallable("https://stres.quectel.com:8139/quectel1/M00/06/05/wKgXZmDid8qAcl8JAC4j9RJ8LZw346.png", "test4.png");

        ExecutorService ser = Executors.newFixedThreadPool(4);
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        Future<Boolean> r4 = ser.submit(t4);

        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        boolean rs4 = r4.get();

        ser.shutdown();
    }
}
