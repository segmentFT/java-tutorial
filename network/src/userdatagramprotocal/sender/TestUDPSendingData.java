package userdatagramprotocal.sender;

import java.io.IOException;
import java.net.*;

public class TestUDPSendingData {
    public static void main(String[] args) throws IOException {
        /*
        创建 DatagramSocket 类的对象, 它需要与一个指定的端口进行绑定, 从而可以通过 UDP 协议在该端口上发送或者接收数据.

            如果使用 DatagramSocket 类的空参构造方法创建对象, 那么创建出的对象会随机地与系统中可用的端口号进行绑定.
            如果使用 DatagramSocket 类的具有 int 类型参数 port 的构造方法创建对象, 那么创建出的对象会与 port 进行绑定.
         */
        DatagramSocket socket = new DatagramSocket(1764);

        /*
        创建 DatagramPacket 对象, 将需要发送的数据以 byte 数组的形式存入该对象中.

        DatagramPacket 类的构造函数的参数列表的完整形式如下:

            buf: 一个 byte 类型的数组, 其中存储了需要发送的数据.

            offset: 表示发送的数据的第一个字节在数组 buf 中的位置. buf 的元素 buf[offset] 是发送数据的第一个字节.

            len: 发送的数据的字节数量.

            address: 一个 InetAddress 类的对象, 它表示数据的接收者的 IP 地址.

            port: 数据的接收者的端口号.
         */
        byte[] data = "Is there anybody out there?".getBytes();

        DatagramPacket packet = new DatagramPacket(
                data,
                0,
                data.length,
                InetAddress.getByName("127.0.0.1"),
                3528
        );

        // 调用 DatagramPacket 的实例方法 send, 发送通过 DatagramPacket 对象封装的数据
        socket.send(packet);

        // 关闭套接字
        socket.close();
    }
}
