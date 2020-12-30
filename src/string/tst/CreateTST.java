package string.tst;

public class CreateTST {

    public static void main(String[] args) {
        var tst = new TernarySearchTree();
        tst.add("apple");
        tst.add("me");

        System.out.println(tst.search("me"));
        tst.delete("me");
        System.out.println(tst.search("me"));
    }
}
