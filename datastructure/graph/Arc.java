package OJSolution.datastructure.graph;

/**
 * 图的带权重有向边数据结构
 */
public class Arc {
    private int tail;
    private int weight;

    Arc(int tail, int weight) {
        this.tail = tail;
        this.weight = weight;
    }

    int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
