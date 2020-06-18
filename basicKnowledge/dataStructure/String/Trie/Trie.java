package Algorithm.basicKnowledge.dataStructure.String.Trie;

/**
 * 字典树
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 执行结果：
 * 通过
 */
public class Trie {
    TrieNode[] roots;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        roots = new TrieNode[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = new TrieNode();
        TrieNode[] childs = roots;
        for (int i = 0; i < chars.length; i++) {
            node = childs[chars[i] - 'a'];
            if (node == null) {
                node = new TrieNode();
                childs[chars[i] - 'a'] = node;
            }
            childs = node.nodes;
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = new TrieNode();
        TrieNode[] childs = roots;
        for (int i = 0; i < word.length(); i++) {
            node = childs[word.charAt(i) - 'a'];
            if (node == null) {
                return false;
            }
            childs = node.nodes;
        }
        if (node.isEnd == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = new TrieNode();
        TrieNode[] childs = roots;
        for (int i = 0; i < prefix.length(); i++) {
            node = childs[prefix.charAt(i) - 'a'];
            if (node == null) {
                return false;
            }
            childs = node.nodes;
        }
        return true;
    }

    class TrieNode {
        public TrieNode[] nodes;
        public boolean isEnd;

        public TrieNode() {
            nodes = new TrieNode[26];
            isEnd = false;
        }
    }
}
