package org.learning.graphs.adj_matrix;

public class DFSMatrix {
    int[][] adjMatrix;
    DFSMatrix(int[][] adjMatrix){
        this.adjMatrix = adjMatrix;
    }

    public void traverseDFSUsingMatrix(){
        boolean[] isVisited = new boolean[adjMatrix.length];
        for(int i=0 ; i<adjMatrix.length ; i++){
            if(!isVisited[0]){
                dfs(i, adjMatrix, isVisited);
            }
        }
    }

    private void dfs(int node, int[][] adjMatrix, boolean[] isVisited) {
        isVisited[node] = true;
        System.out.print(node + " ");
        for(int i=0 ;  i < adjMatrix[node].length ; i++){
            if((!isVisited[i]) && (adjMatrix[node][i] == 1)){
                dfs(i, adjMatrix, isVisited);
            }
        }
    }

}
