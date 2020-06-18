package OJSolution.tool;

import OJSolution.application.DFSBFS.Node;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 */
public class MultiTreeBuilder {
    String s;
    private Node root;

    public static void main(String[] args) throws JsonProcessingException {
        String s = "{\"$id\":\"1\",\"children\":[{\"$id\":\"2\",\"children\":[{\"$id\":\"5\",\"children\":[],\"val\":5},{\"$id\":\"6\",\"children\":[],\"val\":6}],\"val\":3},{\"$id\":\"3\",\"children\":[],\"val\":2},{\"$id\":\"4\",\"children\":[],\"val\":4}],\"val\":1}";
        new MultiTreeBuilder().String2Tree(s);
    }

    /**
     * bwftag 多叉树 工具 状态ok
     *
     * @param json {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
     * @return
     */
    public static Node String2Tree(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Node root = objectMapper.readValue(json, Node.class);
        return root;
    }

    /**
     * bwftag 多叉树 工具 状态ok
     *
     * @param json {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
     * @return
     */
    public static Node json2Tree(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Node root = objectMapper.readValue(json, Node.class);
        return root;
    }
}
