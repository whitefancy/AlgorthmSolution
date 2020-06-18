package Algorithm.basicKnowledge.dataStructure.String.Trie;

/**
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * 执行结果：
 * 通过
 */
public class AddSearchWord {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public AddSearchWord() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode[] nodes = node.nodes;
            if (null == nodes[word.charAt(i) - 'a']) {
                node = new TrieNode();
                nodes[word.charAt(i) - 'a'] = node;
            }
            node = nodes[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    boolean search(String word, int i, TrieNode node) {
        while (i < word.length()) {
            TrieNode[] nodes = node.nodes;
            if ('.' != word.charAt(i)) {
                if (null == nodes[word.charAt(i) - 'a']) {
                    return false;
                }
                node = nodes[word.charAt(i) - 'a'];
            } else {
                i++;
                for (int j = 0; j < 26; j++) {
                    if (null != nodes[j]) {
                        node = nodes[j];
                        if (true == search(word, i, node)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            i++;
        }
        if (node.isEnd == true) {
            return true;
        } else {
            return false;
        }
    }

    private class TrieNode {
        public boolean isEnd;
        public TrieNode[] nodes;

        public TrieNode() {
            nodes = new TrieNode[26];
            isEnd = false;
        }
    }
}
