package com.lrw.other.netty.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String args[]) throws Exception {
        //打开channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //是否阻塞
        serverSocketChannel.configureBlocking(false);
        //服务端套接字
        ServerSocket serverSocket = serverSocketChannel.socket();

        InetSocketAddress address = new InetSocketAddress(8888);
        serverSocket.bind(address);
        Selector selector = Selector.open();
        //将serverSocket注册到selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("hello world".getBytes(Charset.forName("UTF-8")));
        while (true) {
            selector.select(); //等待需要处理的新事件，阻塞将一直持续到下一个传入事件
            //获取所有接收事件的SelectorKey的实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        //接受客户端并将它注册到选择器
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_WRITE, msg.duplicate());
                        System.out.println("Accept a connection from " + client);
                        if (key.isReadable()){
                            SocketChannel clientSocket = (SocketChannel) key.channel();
                            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                            while (byteBuffer.hasRemaining()) {
                               String clientMsg =String.valueOf(byteBuffer.get())  ;
                                if (clientSocket.read(byteBuffer)==-1) { //将数据写到已连接的客户端
                                    break;
                                }
                                System.out.println(clientMsg);
                            }
                        }


                        if (key.isWritable()) {//套接字已经准备好写数据
                            SocketChannel clientSocket = (SocketChannel) key.channel();
                            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                            while (byteBuffer.hasRemaining()) {
                                if (clientSocket.write(byteBuffer) == 0) { //将数据写到已连接的客户端
                                    break;
                                }
                            }
                            clientSocket.close();
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
