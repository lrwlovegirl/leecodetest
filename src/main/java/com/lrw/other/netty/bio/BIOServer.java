package com.lrw.other.netty.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            //OutputStream os = socket.getOutputStream();
            //os.write("你好，服务端接收到了".getBytes());
            InputStream is = socket.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            int len = 0;
            while ((len = bf.read()) != -1) {
                System.out.print((char) len);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
