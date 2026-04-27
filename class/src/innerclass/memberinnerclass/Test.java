package innerclass.memberinnerclass;

public class Test {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("karma police");

        System.out.println(outerClass.getPrivateInnerClassInstance("no surprises"));

        outerClass.displayPrivateInnerClassInfo("high and dry");

        OuterClass.PackageAccessInnerClass packageAccessInnerClass =
                outerClass.new PackageAccessInnerClass("paranoid android");

        System.out.println(packageAccessInnerClass.dataOfPackageAccessInnerClass);

        OuterClass.PublicInnerClass publicInnerClass = outerClass.new PublicInnerClass("fitter happier");

        publicInnerClass.display();
    }
}
