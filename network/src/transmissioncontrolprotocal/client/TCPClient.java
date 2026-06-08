package transmissioncontrolprotocal.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        /*
        创建客户端的 Socket 对象, 用于与服务器的 ServerSocket 对象之间通过 TCP 协议进行数据传输.

        Socket 类的构造方法的两个参数 host 和 port 分别表示服务器的 IP 地址和端口号, Socket 对象一旦被创建就会立刻通过 TCP 的三次握手协议
        与服务器的 ServerSocket 对象之间建立连接, 如果连接建立失败, 那么 Socket 类的构造方法会抛出 IOException 异常.
         */
        Socket socket = new Socket("127.0.0.1", 1764);

        // 这时客户端的 Socket 对象与服务器的 ServerSocket 对象之间的 TCP 连接已经建立, 我们可以获取该连接的输出流, 用于向服务器发送数据
        OutputStream out = socket.getOutputStream();

        // 向输出流写入数据
        out.write("Is there anybody out there?".getBytes());

        /*
        向输出流写入结束标记, 使得服务器从客户端的 Socket 对象得到的输入流能够读取到结束标记（文件结尾）. 由于输入流的 read 方法是阻塞的,
        因此如果不向服务器发送结束标记, 那么服务器从客户端的 Socket 对象获得的输入流的 read 方法将一直等待读取.
         */
        socket.shutdownOutput();

        // 从输入流中获取来自服务器的数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int c;
        while ((c = reader.read()) != -1)
            System.out.print((char) c);

        System.out.println();

        // 关闭客户端的 Socket 对象与服务器的 ServerSocket 对象之间的连接, 同时连接中的输出流也会被关闭
        socket.close();
    }
}
