package inheritance;

public class TestParentAndChild {
    public static void main(String[] args) {
        Child child = new Child("I wanna live and breathe");

        System.out.println(child.getDataInChild());

        child.setDataInChild("I wanna be a part of the human race");

        System.out.println(child.getDataInChild());

        child.changePrivateDataInParent("Where do we go from here?");
        child.changePublicDataInParent("The words are coming out all weird");

        child.displayPrivateDataInParent();
        child.displayPublicDataInParent();
    }
}
