package objectmemorylayout;

public class MultipleDataTest {
    public static void main(String[] args) {
        /*
        即使创建多个 Data 类的对象, Data 类的字节码文件 Data.class 也只会被加载一次,
        即方法区中只会保存一份 Data.class 的实例.
        */
        Data dataObj1 = new Data();
        Data dataObj2 = new Data();

        System.out.println(dataObj1);
        System.out.println(dataObj2);

        dataObj1.showData();
        dataObj2.showData();

        dataObj1.data = "data1";
        dataObj2.data = "data2";

        dataObj1.showData();
        dataObj2.showData();
    }
}
