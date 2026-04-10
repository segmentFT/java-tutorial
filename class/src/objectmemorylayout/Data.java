package objectmemorylayout;

public class Data {
    String data = "explicit initialization";

    public Data() {
        System.out.println(data);

        System.out.println("constructor has been called.");
    }

    public void showData() {
        System.out.println("member method has been called.");
        System.out.println(data);
    }
}
