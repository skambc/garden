package com.skambc.algorithm.struct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlGraph {

    List<HeadNode> headNodes = new ArrayList<HeadNode>();

    void addVertex(HeadNode node) {
        headNodes.add(node);
    }

    void addArc(HeadNode head, HeadNode tail) {
        if (head.firstArcNode == null)
            head.firstArcNode = new ArcNode(tail);
        else {
            ArcNode arcNode = head.firstArcNode;
            while (arcNode.nextArcNode != null) {
                arcNode = arcNode.nextArcNode;
            }
            arcNode.nextArcNode = new ArcNode(tail);
        }
    }

    public void DFSTraverse() {
        InitVisited();
        DFS(headNodes.get(0));
    }
    public void BFSTraverse() {
        InitVisited();
        BFS(headNodes.get(0));
    }
    private void DFS(HeadNode node) {
        node.isVisited = true;
        System.out.print(node.name);
        System.out.print(" -> ");

        ArcNode arcNode = node.firstArcNode;
        while (arcNode != null) {
            if (arcNode.headNode.isVisited != true)
                DFS(arcNode.headNode);
            arcNode = arcNode.nextArcNode;
        }
    }
    private void BFS(HeadNode node) {
        // LinkedList实现了Queue接口
        Queue<HeadNode> q = new LinkedList<HeadNode>();
        for (int i = 0; i < headNodes.size(); i++) {
            if (headNodes.get(i).isVisited == false) {
                headNodes.get(i).isVisited=true;
                System.out.print(headNodes.get(i).name);
                System.out.print(" -> ");
                q.add(headNodes.get(i));
                while (!q.isEmpty()) {
                    ArcNode arc = q.remove().firstArcNode;
                    while (arc != null) {
                        if (arc.headNode.isVisited == false) {
                            arc.headNode.isVisited = true;
                            System.out.print(arc.headNode.name);
                            System.out.print(" -> ");
                            q.add(arc.headNode);
                        }
                        arc = arc.nextArcNode;
                    }
                }
            }
        }
    }

    private void InitVisited() {
        for (HeadNode node : headNodes) {
            node.isVisited = false;
            node.isHead = false;
        }
    }

    static AlGraph createAlGraph() {
        AlGraph alGraph = new AlGraph();

        HeadNode V1 = new HeadNode("V1");
        HeadNode V2 = new HeadNode("V2");
        HeadNode V3 = new HeadNode("V3");
        HeadNode V4 = new HeadNode("V4");
        HeadNode V5 = new HeadNode("V5");
        HeadNode V6 = new HeadNode("V6");
        HeadNode V7 = new HeadNode("V7");
        HeadNode V8 = new HeadNode("V8");

        alGraph.addVertex(V1);
        alGraph.addVertex(V2);
        alGraph.addVertex(V3);
        alGraph.addVertex(V4);
        alGraph.addVertex(V5);
        alGraph.addVertex(V6);
        alGraph.addVertex(V7);
        alGraph.addVertex(V8);

        alGraph.addArc(V1, V2);
        alGraph.addArc(V1, V3);
        alGraph.addArc(V2, V1);
        alGraph.addArc(V2, V4);
        alGraph.addArc(V2, V5);
        alGraph.addArc(V3, V1);
        alGraph.addArc(V3, V6);
        alGraph.addArc(V3, V7);
        alGraph.addArc(V4, V2);
        alGraph.addArc(V4, V8);
        alGraph.addArc(V5, V2);
        alGraph.addArc(V5, V8);
        alGraph.addArc(V6, V3);
        alGraph.addArc(V6, V8);
        alGraph.addArc(V7, V3);
        alGraph.addArc(V7, V8);
        alGraph.addArc(V8, V4);
        alGraph.addArc(V8, V5);
        alGraph.addArc(V8, V6);
        alGraph.addArc(V8, V7);

        return alGraph;
    }

    void print() {
        for (HeadNode head : headNodes) {
            System.out.print(head.name);
            if (head.firstArcNode != null) {
                ArcNode arcNode = head.firstArcNode;
                System.out.print(" -> ");
                System.out.print(arcNode.headNode.name);
                while (arcNode.nextArcNode != null) {
                    arcNode = arcNode.nextArcNode;
                    System.out.print(" -> ");
                    System.out.print(arcNode.headNode.name);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AlGraph.createAlGraph().print();
        System.out.println("\nAlGraph DFSTraverse !!");
        AlGraph.createAlGraph().DFSTraverse();
        System.out.println();
        AlGraph.createAlGraph().BFSTraverse();
    }
}

class ArcNode {
    HeadNode headNode;

    ArcNode nextArcNode;

    public ArcNode(HeadNode tail)
    {
        this.headNode = tail;
    }
}

class HeadNode {
    String name;

    ArcNode firstArcNode;

    boolean isVisited;

    boolean isHead;

    HeadNode(String name)
    {
        this.name = name;
    }
}
