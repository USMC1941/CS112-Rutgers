package Graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Neighbor {
    public int vertexNum;
    public Neighbor next;

    public Neighbor(int vnum, Neighbor nbr) {
        this.vertexNum = vnum;
        next = nbr;
    }
}

class Vertex {
    String name;
    Neighbor adjList;

    Vertex(String name, Neighbor neighbors) {
        this.name = name;
        this.adjList = neighbors;
    }
}

public class Graph {

    Vertex[] adjLists;

    boolean undirected = true;

    public Graph(String file) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(file));

        String graphType = sc.next();
        if (graphType.equals("directed")) {
            undirected = false;
        }

        adjLists = new Vertex[sc.nextInt()];

        // read vertices
        for (int v = 0; v < adjLists.length; v++) {
            adjLists[v] = new Vertex(sc.next(), null);
        }

        // read edges
        while (sc.hasNext()) {

            // read vertex names and translate to vertex numbers
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());

            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
            if (undirected) {
                adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
            }
        }
    }

    int indexForName(String name) {
        for (int v = 0; v < adjLists.length; v++) {
            if (adjLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (Vertex adjList : adjLists) {
            System.out.print(adjList.name);
            for (Neighbor nbr = adjList.adjList; nbr != null; nbr = nbr.next) {
                System.out.print(" --> " + adjLists[nbr.vertexNum].name);
            }
            System.out.println("\n");
        }
    }

    public void dfs() {
        boolean[] visited = new boolean[adjLists.length];
        for (int v = 0; v < visited.length; v++) {
            if (!visited[v]) {
                System.out.println("\nSTARTING AT " + adjLists[v].name + "\n");
                dfs(v, visited);
            }
        }
    }

    // recursive dfs
    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println("\tvisiting " + adjLists[v].name);
        for (Neighbor e = adjLists[v].adjList; e != null; e = e.next) {
            if (!visited[e.vertexNum]) {
                System.out.println("\t" + adjLists[v].name + "--" + adjLists[e.vertexNum].name);
                dfs(e.vertexNum, visited);
            }
        }
    }

    public int[] dfsTopsort() {
        boolean[] visited = new boolean[adjLists.length];
        int[] topseq = new int[adjLists.length];
        int num = adjLists.length - 1;
        for (int v = 0; v < visited.length; v++) {
            if (!visited[v]) {
                System.out.println("\nSTARTING AT " + adjLists[v].name + "\n");
                num = dfsTopsort(v, visited, topseq, num);
            }
        }
        return topseq;
    }

    /**
     * recursive dfs based topsort topseq[i]=x => vertex x's topological number is i num is the
     * current largest topological number that can be dealt out
     */
    private int dfsTopsort(int v, boolean[] visited, int[] topseq, int num) {
        visited[v] = true;
        System.out.println("\tvisiting " + adjLists[v].name);
        for (Neighbor e = adjLists[v].adjList; e != null; e = e.next) {
            if (!visited[e.vertexNum]) {
                System.out.println("\t" + adjLists[v].name + "--" + adjLists[e.vertexNum].name);
                num = dfsTopsort(e.vertexNum, visited, topseq, num);
            }
        }
        // assign number
        topseq[num] = v;
        return num - 1;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        Graph graph = new Graph(file);
        graph.print();

        System.out.println("Doing DFS...");
        graph.dfs();

        // try this for website2.txt
        /*
        System.out.println("Doing DFS topsort...");
        int[] topseq = graph.dfsTopsort();
        for (int i=0; i < topseq.length; i++) {
        	System.out.println(graph.adjLists[topseq[i]].name);
        }
        */
    }
}
