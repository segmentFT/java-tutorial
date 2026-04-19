package inheritance;

public class Parent {
    private String privateDataInParent;
    public String publicDataInParent;

    public Parent() {}
    public Parent(String privateDataInParent, String publicDataInParent) {
        this.privateDataInParent = privateDataInParent;
        this.publicDataInParent = publicDataInParent;
    }

    public void setPrivateDataInParent(String privateDataInParent) {
        this.privateDataInParent = privateDataInParent;
    }

    public String getPrivateDataInParent() {
        return privateDataInParent;
    }
}