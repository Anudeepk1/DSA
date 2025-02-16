package org.learning.graphs.adj_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    List<List<Integer>> adjList;

    BFS(List<List<Integer>> adjList){
        this.adjList = adjList;
    }
    public void traverseBFS(){
        boolean[] isVisited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i< adjList.size() ; i++){
            if(!isVisited[i]){
                queue.add(i);
                bfs(i, isVisited, queue, adjList);
            }
        }
    }

    private void bfs(int i, boolean[] isVisited, Queue<Integer> queue, List<List<Integer>> adjList) {

        while(queue.peek() != null){
            Integer poll = queue.poll();
            System.out.println(poll);
            isVisited[poll] = true;
            for(Integer nodeVal: adjList.get(poll)){
                if(!isVisited[nodeVal]){
                    queue.add(nodeVal);
                }
            }

        }
        if(queue.peek() != null){
            bfs(i, isVisited, queue, adjList);
        }

    }

}
