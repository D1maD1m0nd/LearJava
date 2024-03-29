package Achitecture.Lesson7;

import java.util.LinkedList;
import java.util.Queue;
//7.2
public class Graph {
    private final int MAX_VERTS = 32;
    private Stack stack;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph(){
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    private int getAdjTwistedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] == 1 && !vertexList[i].wasVisited){
                return i;
            }
        }
        return -1;
    }

    public void  dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getAdjTwistedVertex(stack.peek());
            if (v == -1){
               stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
    public void DFS(int f){
        vertexList[f].wasVisited = true;
        for (int i = 0; i < size; i++) {
            int v = getAdjTwistedVertex(f);
            if(!vertexList[i].wasVisited && v != -1){
                fullDisplayVerterx(f, v);
                DFS(i);
            }
        }


    }

    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()){
            int v1 = queue.remove();
            while ((v2 = getAdjTwistedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
    public void fullDisplayVerterx(int vertex1, int vertex2){
        System.out.println("Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
}
