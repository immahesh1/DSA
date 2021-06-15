import java.util.ArrayList;

public class graph {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt){
        graph[src].add(new Edge(src,nbr,wt));
        graph[nbr].add(new Edge(nbr,src,wt));
    }
    public static void display(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            String str = "["+i+"]" + " -> ";
            for(Edge ed : graph[i]){
                str += "(" + ed.src + " <-> " + ed.nbr + " @ " + ed.wt +"), ";
            }
            System.out.println(str);
        }
    }
    public static ArrayList<Edge>[] createGraph(){
        int n = 7;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        int[][] data = {
            {0,1,10},
            {0,3,40},
            {1,2,10},
            {2,3,10},
            {3,4,2},
            {4,5,3},
            {5,6,3},
            {6,4,8}
        };

        for(int[]  arr : data){
            addEdge(graph,arr[0],arr[1],arr[2]);
        }
        return graph;
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dst, boolean[] visited){
        if(src == dst){
            return true;
        }
        visited[src] = true;
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                boolean res = hasPath(graph, e.nbr, dst, visited);
                if(res == true){
                    return true;
                }
            }
        }
        return false;
    }
    public static void fun(){
        int n = 7;
        ArrayList<Edge>[] graph = createGraph();
        boolean[] visited = new boolean[n];
        boolean ans = hasPath(graph, 0, 6, visited);
        System.out.println(ans);
        display(graph);
    }
    public static void main(String[] args){
        fun();
    }    
}
