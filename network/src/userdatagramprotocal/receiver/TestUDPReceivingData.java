package userdatagramprotocal.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDPReceivingData {
    public static void main(String[] args) throws IOException {
        /*
        创建一个 DatagramSocket 对象, 由于我们需要使用该对象接收数据, 因此在创建时必须要使用 DatagramSocket 类的有参构造方法,
        并且将发送端的目标端口作为参数传递给该构造方法, 使得创建出的 DatagramSocket 对象与发送端的目标端口绑定,
        从而该对象可以在发送端的目标端口上接受来自发送端的数据.
         */
        DatagramSocket socket = new DatagramSocket(3528);

        /*
        创建一个 DatagramPacket 对象用于存储接收到的数据, 由于该对象用于接受数据, 并且 DatagramPacket 类的构造函数的参数列表的完整形式
        中的最后两个参数 address 和 port 用于指定在发送数据时接收端的 IP 地址和端口号, 因此我们不需要考虑这两个参数, 从而我们使用
        DatagramPacket 类的只包含参数 buf, offset, len 的构造函数.
         */
        DatagramPacket packet = new DatagramPacket(new byte[1024], 0, 1024);

        /*
        调用 DatagramSocket 的实例方法 receive 在指定的端口上接收数据, 并且 receive 方法是阻塞的, 即它的内部存在一个无限循环,
        用于一直等待接受来自指定端口上的数据, 直到接收到数据 receive 方法的该内部的无限循环才结束, 从而程序才能够继续向下执行.
         */
        socket.receive(packet);

        // 获取接收到的数据
        byte[] data = packet.getData();

        // 获取接收到的数据的字节数量
        int dataSize = packet.getLength();

        // 获取发送端的 IP 地址
        InetAddress senderAddress = packet.getAddress();

        // 获取发送端的端口
        int senderPort = packet.getPort();

        System.out.println("from port: " + senderPort + " at IP address: " + senderAddress);
        System.out.println("received message: \"" + new String(data, 0, dataSize) + "\"");

        // 关闭套接字
        socket.close();
    }
}
