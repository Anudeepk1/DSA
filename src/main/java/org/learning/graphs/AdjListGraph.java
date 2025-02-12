package org.learning.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph {
    public static void main(String[] args) {
        int[][] matrix = { {0, 2}, {1, 0}, {2, 0} };
        int[][] matrixWithWeight = { {0, 2, 10}, {1, 0, 20}, {2, 0, 30} };
        boolean isDirectional = false;
        GraphUsingList gul = new GraphUsingList(matrix.length);
//        gul.addNodesToAdjList(matrix, isDirectional);
        gul.addNodesToAdjListWithWeights(matrixWithWeight, isDirectional);
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


    void addNodesToAdjList(int[][] matrix, boolean isDirectional){
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


}
