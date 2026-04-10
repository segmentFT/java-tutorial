package standardjavebean;

public class UserTest {
    public static void main(String[] args) {
        // 调用 User 类的无参构造函数创建 User 类的对象
        User user1 = new User();

        System.out.println(user1.getUserName());
        System.out.println(user1.getPassword());
        System.out.println(user1.getEmail());
        System.out.println(user1.getGender());
        System.out.println(user1.getAge());

        System.out.println();

        // 调用 User 类的带参构造函数创建 User 类的对象
        User user2 = new User("name", "password", "email", "gender", 255);

        System.out.println(user2.getUserName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getEmail());
        System.out.println(user2.getGender());
        System.out.println(user2.getAge());
    }
}
