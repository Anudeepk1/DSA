package org.learning.graphs.adj_list;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph {
    public static void main(String[] args) {
        int[][] matrix = { {0, 2}, {1, 0}, {2, 0} };
        int[][] matrixWithWeight = { {0, 2, 10}, {1, 0, 20}, {2, 0, 30} };
        boolean isDirectional = true;
        GraphUsingList gul = new GraphUsingList(matrix.length);
        gul.addNodesToAdjList(matrix, isDirectional);
        gul.findDegreeForDirectedGraph();
        gul.addNodesToAdjListWithWeights(matrixWithWeight, isDirectional);
        gul.findDegreeForUnDirectedGraph();
        //
        int[][] traverseMatrix = {{0, 1}, {1, 2},{2, 3},{2, 4},{4, 5},{4, 6},{5, 7},{6, 7}};
        GraphUsingList dfsGraph = new GraphUsingList(traverseMatrix.length);
        List<List<Integer>> lists = dfsGraph.addNodesToAdjList(traverseMatrix, false);
        DFS graphDfs = new DFS(lists);
        graphDfs.traverseDFSUsingList();

        int[][] bfsMatrix = {{0,3}, {1,5}, {2, 2}, {7, 7}, {3, 5}, {4,6}, {5,6}, {6,4}};
        GraphUsingList bfsGraph = new GraphUsingList(bfsMatrix.length);
        List<List<Integer>> lists1 = bfsGraph.addNodesToAdjList(bfsMatrix, false);
        lists1.get(2).clear();
        lists1.get(7).clear();
        BFS graphBfs = new BFS(lists1);
        graphBfs.traverseBFS();


    }
}

class GraphUsingList{

    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return "( "+node+" , "+weight+" )";
        }
    }
    List<List<Integer>> arrList;
    List<List<Pair>> weightedArrList;

    GraphUsingList(int nodes){
        arrList = new ArrayList<>();
        for(int i=0; i<nodes; i++){
            arrList.add(new ArrayList<>());
        }

        //
        weightedArrList = new ArrayList<>();
        for(int i=0; i<nodes ; i++){
            weightedArrList.add(new ArrayList<>());
        }
    }

    void addNodesToAdjListWithWeights(int[][] matrix, boolean isDirectional){
        for(int[] arr: matrix){
            int v = arr[0];
            int u = arr[1];
            int w = arr[2];

            if(isDirectional){
                Pair pair = new Pair(u, w);
                weightedArrList.get(v).add(pair);
            }else{
                Pair pair = new Pair(u, w);
                Pair pair2 = new Pair(v, w);
                weightedArrList.get(v).add(pair);
                weightedArrList.get(u).add(pair2);
            }
        }
        printWeightedAdjList(weightedArrList);
    }


    List<List<Integer>> addNodesToAdjList(int[][] matrix, boolean isDirectional){
        for(int[] arr: matrix){

            int v = arr[0];
            int u = arr[1];

            if(isDirectional){
                arrList.get(v).add(u);
            }else{
                arrList.get(v).add(u);
                arrList.get(u).add(v);
            }
        }
        printAdjList(arrList);
        return arrList;
    }

    private void printAdjList(List<List<Integer>> arrList) {
        int counter = 0;
        for(List<Integer> arr: arrList){
            System.out.print(counter + " -> ");
            for(Integer val: arr){
                System.out.print(val + " ");
            }
            counter++;
            System.out.println();
        }
    }

    private void printWeightedAdjList(List<List<Pair>> arrList) {
        int counter = 0;
        for(List<Pair> arr: arrList){
            System.out.print(counter + " -> ");
            for(Pair val: arr){
                System.out.print(val.toString());
            }
            counter++;
            System.out.println();
        }
    }

    void findDegreeForDirectedGraph(){
        int[] inDegree = new int[arrList.size()];
        int[] outDegree = new int[arrList.size()];
        for(int i=0; i< arrList.size(); i++){
            List<Integer> arr = arrList.get(i);
            outDegree[i]++;
            for(Integer num: arr){
                inDegree[num]++;
            }
        }

        for(int i=0; i< arrList.size(); i++){
            System.out.println(i +" -> In-degree: " + inDegree[i] +", Out-degree: "+ outDegree[i]);

        }
    }

    void findDegreeForUnDirectedGraph(){
        int[] degree = new int[arrList.size()];
        for(int i=0 ; i < arrList.size() ; i++){
            degree[i]++;
            for(Integer num: arrList.get(i)){
                degree[num]++;
            }
        }

        for(int i=0; i< arrList.size(); i++){
            System.out.println(i +" -> degree: " + degree[i] );

        }
    }



}
