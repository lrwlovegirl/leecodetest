package com.lrw.other.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            int len;
            byte[] bytes = new byte[1024];
            OutputStream os = socket.getOutputStream();
            os.write("hello,服务器,我是客户端".getBytes());
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            while ((len = is.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
