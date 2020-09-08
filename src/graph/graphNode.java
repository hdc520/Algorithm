package graph;

import java.util.*;

public class graphNode {
    public int val;
    public List<graphNode> neighbors;
    public boolean visited;

    public graphNode() {
        val = 0;
        neighbors = new ArrayList<graphNode>();
    }

    public graphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<graphNode>();
    }

    public graphNode(int _val, ArrayList<graphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
