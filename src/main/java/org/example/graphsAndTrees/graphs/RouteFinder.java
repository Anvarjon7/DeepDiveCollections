package org.example.graphsAndTrees.graphs;

import org.example.stackAndQueues.queuePractice.MyQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum State {
    UNVISITED,
    VISITING,
    VISITED
}

class Node {
    String name;
    List<Node> neighbors = new ArrayList<>();
    State state = State.UNVISITED;

    public Node(String name) {
        this.name = name;
    }

    void addNeighbor(Node n) {
        neighbors.add(n);
    }
}

class Graph{
    List<Node> nodes = new ArrayList<>();

    void addNode(Node n){
        nodes.add(n);
    }

    List<Node> getNodes(){
        return nodes;
    }
}

public class RouteFinder {

    public static boolean hasRoute(Graph g, Node start, Node end){
        if (start == end) return true;

        for (Node n : g.getNodes()){
            n.state = State.UNVISITED;
        }

        Queue<Node> queue = new LinkedList<>();
        start.state = State.VISITING;
        queue.add(start);

        while (!queue.isEmpty()){
            Node current = queue.poll();
             for (Node neighbor : current.neighbors){
                 if (neighbor.state == State.UNVISITED){
                     if (neighbor == end){
                         return true;
                     }
                 }
                 neighbor.state = State.VISITING;
                 queue.add(neighbor);
             }
             current.state = State.VISITED;
        }
        return false;
    }


    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");

        a.addNeighbor(b);
        b.addNeighbor(c);
        c.addNeighbor(d);
        d.addNeighbor(e);
        e.addNeighbor(a);

        Graph g = new Graph();
        g.addNode(a);
        g.addNode(b);
        g.addNode(c);
        g.addNode(d);
        g.addNode(e);


        System.out.println(hasRoute(g, e,a));
    }
}
