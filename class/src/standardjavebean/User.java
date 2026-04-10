package standardjavebean;

/*
标准的 JavaBean 类的要求如下:

    1. 成员变量在定义时必须要使用 private 修饰

    2. 至少有两个构造方法:
        无参构造方法
        带有对应于所有成员变量的参数的构造方法

    3. 每个成员变量都要有一个对应的 set 方法和 get 方法
*/

public class User {
    private String userName;
    private String password;
    private String email;
    private String gender;
    private int age;

    // 无参构造方法
    public User () {}

    // 带有对应于所有成员变量的参数的构造方法
    public User(String userName, String password, String email, String gender, int age) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    // 对应于成员变量 userName 的 set 方法和 get 方法
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    // 对应于成员变量 password 的 set 方法和 get 方法
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // 对应于成员变量 email 的 set 方法和 get 方法
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // 对应于成员变量 gender 的 set 方法和 get 方法
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    // 对应于成员变量 age 的 set 方法和 get 方法
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
