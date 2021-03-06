package string.tries;

public class CreateTrie {

    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("sanjay");
        trie.insert("sanja");
        System.out.println(trie.search("sanjay"));
        System.out.println(trie.search("sanja"));

        System.out.println(trie.search("ranjay"));
        trie.insert("ranjay");
        System.out.println(trie.search("ranjay"));

        trie.delete("ranjay");
        System.out.println(trie.search("ranjay"));

        trie.insert("ranjay");
        System.out.println(trie.search("ranjay"));
    }
}
