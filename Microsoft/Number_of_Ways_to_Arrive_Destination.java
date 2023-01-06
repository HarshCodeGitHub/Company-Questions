package com.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Number_of_Ways_to_Arrive_Destination {
	static int mod = (int)(Math.pow(10, 9)+7);

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i< n; i++)
            adj.add(new ArrayList<>());
        

        for(int[] e: roads){
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.weight- b.weight);

        pq.offer(new Pair(0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;


        int[] count = new int[n];
        count[0] = 1;
        while(!pq.isEmpty()){
            Pair front = pq.poll();

            for(Pair e: adj.get(front.node)){

                if(e.weight+ front.weight < dist[e.node]){
                    dist[e.node] = e.weight+ front.weight;
                    pq.offer(new Pair(e.node, dist[e.node]));
                    count[e.node] = count[front.node];
                }
                else if(e.weight+ front.weight == dist[e.node]){
                    count[e.node] = (count[e.node]+ count[front.node]) %mod;
                }
            }
        }

        return count[n-1]%mod;

    }

    class Pair{
        int node, weight;
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
}
