import java.util.*;

public class PerfectFriends {
    public static int friends(ArrayList<Integer>[] graph){
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        ArrayList<Integer> comp = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        gcc(graph,src,vis,comp);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // no of vertices
        int k = sc.nextInt();   // no of edges

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                graph[i].add(sc.nextInt());
                graph[i].add(sc.nextInt());
            }
        }

        int count = friends(graph);    
    }    
}
