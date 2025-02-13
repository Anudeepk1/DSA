package org.learning.graphs.adj_list;

import java.util.List;

public class DFS {
    List<List<Integer>> adjList;
    DFS(List<List<Integer>> adjList){
        this.adjList = adjList;
    }

    public void traverseDFSUsingList(){
        boolean[] isVisited = new boolean[adjList.size()];
        for(int i=0 ; i<adjList.size(); i++){
            if(!isVisited[i]){
                dfs(i ,adjList, isVisited);
            }
        }
    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] isVisited) {
        isVisited[node] = true;
        System.out.println(node);
        for(Integer nodeVal: adjList.get(node)){
            if(!isVisited[nodeVal]){
                dfs(nodeVal ,adjList, isVisited);
            }
        }
    }


}
