package inheritance;

public class Child extends Parent {
    String dataInChild;

    public Child() {}
    public Child(String dataInChild) {
        this.dataInChild = dataInChild;
    }

    public void changePrivateDataInParent(String dataInParent) {
        setPrivateDataInParent(dataInParent);
    }

    public void displayPrivateDataInParent() {
        System.out.println(getPrivateDataInParent());
    }

    public void changePublicDataInParent(String dataInParent) {
        publicDataInParent = dataInParent;
    }

    public void displayPublicDataInParent() {
        System.out.println(publicDataInParent);
    }

    public void setDataInChild(String dataInChild) {
        this.dataInChild = dataInChild;
    }

    public String getDataInChild() {
        return dataInChild;
    }
}