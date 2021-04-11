package Achitecture.Lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        /*
        7.1 Приведите пример графа.
        Железнодорожные пути
        кабинеты в больницах(они бывают связан
         */
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);

        long t1;
        //7.3
        t1 = System.nanoTime();
        graph.dfs();
        System.out.println("Метод обходиа в глубину " + (System.nanoTime() - t1));
        //graph.DFS(0);
        //7.4
        t1 = System.nanoTime();
        graph.bfs();
        System.out.println("Метод обхоида в ширину " + (System.nanoTime() - t1));
    }
}
