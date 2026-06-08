package transmissioncontrolprotocal.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        /*
        创建客户端的 ServerSocket 对象. 在创建时需要通过 ServerSocket 类的构造方法给创建出的对象指定一个监听端口
         */
        ServerSocket serverSocket = new ServerSocket(1764);

        /*
        调用 ServerSocket 对象的 accept 方法, 不断等待来自客户端的连接, 一旦有客户端的 Socket 对象与该 ServerSocket 对象建立连接,
        那么 accept 方法就会返回该 Socket 对象.

        并且 accept 方法是阻塞的, 即, 只要没有客户端在指定的端口上与 ServerSocket 对象建立连接, 那么 accept 方法内的死循环就不会终止.
         */
        Socket socket = serverSocket.accept();

        // 从与 ServerSocket 对象建立连接的 Socket 对象中获取输入流, 用于从客户端的 Socket 对象接收数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int c;
        while ((c = reader.read()) != -1)
            System.out.print((char) c);

        System.out.println();

        // 从与 ServerSocket 对象建立连接的 Socket 对象中获取输出流, 用于向客户端的 Socket 对象发送数据
        OutputStream out = socket.getOutputStream();

        out.write("I'll be back one day.".getBytes());

        socket.shutdownOutput();

        // 断开与客户端的 Socket 对象之间的连接
        socket.close();

        // 关闭服务器的 ServerSocket 对象
        serverSocket.close();
    }
}
