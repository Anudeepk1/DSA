package org.learning.graphs;

public class AdjMatrixGraph {
    public static void main(String[] args) {
        int[][] matrix = { {0, 2}, {1, 0}, {2, 0} };
        int[][] matrixWithWeight = { {0, 2, 10}, {1, 0, 20}, {2, 0, 30} };
        Graph gh = new Graph(matrix.length);
        boolean isDirectional = true;
//        gh.addNodesToAdjMatrix(matrix, isDirectional);
//    gh.addNodesToAdjMatrixWithWeight(matrixWithWeight, isDirectional);
        int[][] matrix1 = { {0, 2}, {1, 0}, {1, 2} };
        gh.findDegreeForDirectedGraph(matrix1);
        System.out.println();
        gh.findDegreeForUndirectedGraph(matrix1);
    }
}

class Graph{
    int[][] matrix;
    Graph(int nodes){
        this.matrix = new int[nodes][nodes];
    }

    void addNodesToAdjMatrixWithWeight(int[][] edges, boolean isDirectional){
        for(int[] edge: edges){
            int v = edge[0];
            int u = edge[1];
            int w = edge[2];

            if(isDirectional){
                matrix[v][u] = w;
            } else {
                matrix[v][u] = w;
                matrix[u][v] = w;
            }
        }
        printMatrix(matrix);
    }


    void addNodesToAdjMatrix(int[][] edges, boolean isDirectional){
        for(int[] edge: edges){
            int v = edge[0];
            int u = edge[1];

            if(isDirectional){
                matrix[v][u] = 1;
            } else {
                matrix[v][u] = 1;
                matrix[u][v] = 1;
            }

        }
//        for(int i=0 ; i< edges.length ; i++){
//                matrix[edges[i][0]][edges[i][1]] = 1;
//        }
        printMatrix(matrix);
    }

    void printMatrix(int[][] edges){
        for(int i=0 ; i< edges.length ; i++){
            for(int j=0 ; j<edges[i].length ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    void findDegreeForDirectedGraph(int[][] matrix){
        int[] inDegree = new int[matrix.length];
        int[] outDegree = new int[matrix.length];
        for(int[] arr: matrix){
            int v = arr[0];
            int u = arr[1];
            inDegree[u]++;
            outDegree[v]++;
        }

        for(int i=0; i<matrix.length ; i++){
            System.out.println(i +" -> In-degree: " + inDegree[i] +", Out-degree: "+ outDegree[i]);
        }

    }

    void findDegreeForUndirectedGraph(int[][] matrix){
        int[] degree = new int[matrix.length];
        for(int[] arr: matrix){
            int v = arr[0];
            int u = arr[1];
            degree[u]++;
            degree[v]++;
        }

        for(int i=0; i<matrix.length ; i++){
            System.out.println(i +" -> In-degree: " + degree[i] +", Out-degree: "+ degree[i]);
        }

    }

}

