package com.lrw.other.netty.bio;

import lombok.SneakyThrows;
import org.apache.commons.lang3.CharSet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                final  Socket client = serverSocket.accept();
                System.out.println("access a clinet socket from:"+client.getLocalPort());
                new Thread(() -> {
                    try {
                        InputStream inputStream = client.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        String requestMsg;

                        // TODO 没读取到数据会阻塞
                        while ((requestMsg = reader.readLine()) != null) {
                            if (requestMsg.length() != 0) {
                                System.out.println(requestMsg);
                            }
                        }
                        OutputStream outputStream = client.getOutputStream();
                        outputStream.write("hello world".getBytes(Charset.forName("UTF-8")) );
                        outputStream.flush();
                        //serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
