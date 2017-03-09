package com.example.graph;

import java.util.LinkedList;

/**
 * Created by binea on 2016/11/10.
 */

public class GraphSearch {
    public enum State {
        Unvisited, Visited, Visiting;
    }

    public class Node {
        public int val;
        public State state = State.Unvisited;

        public Node(int val) {
            this.val = val;
        }

        Node[] nodes;

        public Node[] adjacent() {
            return nodes;
        }
    }

    public class Graph {
        public Node[] nodes;

        public Node[] getNodes() {
            return nodes;
        }
    }

    public boolean search(Graph graph, Node start, Node end) {
//        dfs(start);
        bfs(graph, start, end);
        if (end.state == State.Visited) {
            return true;
        }
        return false;
    }

    /**
     * bfs
     * @param root
     */
    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        root.state = State.Visited;
        for (Node node : root.adjacent()) {
            if (node.state != State.Visited) {
                dfs(node);
            }
        }
    }

    /**
     * bfs
     * @param start
     * @param end
     */
    public void bfs(Graph g, Node start, Node end) {
        LinkedList<Node> linkedList = new LinkedList<>();
        for(Node node : g.getNodes()) {
            node.state = State.Visited;
        }
        start.state = State.Visiting;
        linkedList.add(start);
        Node u;
        while(!linkedList.isEmpty()) {
            u = linkedList.removeFirst();
            if(u == null) {
                continue;
            }
            for(Node node : u.adjacent()) {
                if(node.state == State.Unvisited) {
                    if(node.val == end.val) {
                        break;
                    }else {
                        node.state = State.Visiting;
                        linkedList.add(node);
                    }
                }
            }
            u.state = State.Visited;
        }
    }
}
