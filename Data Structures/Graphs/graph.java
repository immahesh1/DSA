import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dst, boolean[] visited, String psf, int wsf){
        if(src == dst){
            psf += dst;
            System.out.println(psf+" @ "+wsf);
            return;
        }
        visited[src] = true;
        for(Edge ed : graph[src]){
            if(visited[ed.nbr] == false){
                printAllPaths(graph, ed.nbr, dst, visited, psf+src,wsf+ed.wt);
            }
        }
        visited[src] = false;
    }
    public static void getConnectedCom(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> comp){
        vis[src] = true;
        comp.add(src);

        for(Edge e : graph[src]){
            int nbr = e.nbr;
            if(vis[nbr] == false){
                getConnectedCom(graph, nbr, vis, comp);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge>[] graph){
    	int n = graph.length;
    	boolean[] vis = new boolean[n];
    	ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    	for(int i=0; i<n; i++){
    		if(vis[i] == false){
    			comps.add(getComp(graph,i,vis,new ArrayList<Integer>()));
    		}
    	}
    	return comps;
    }  
    public static ArrayList<Integer> getComp(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> comp){
    	vis[src] = true;
    	comp.add(src);
    	for(Edge e : graph[src]){
    		if(vis[e.nbr] == false){
    			getComp(graph,e.nbr,vis,comp);
    		}
    	}
    	return comp;
    }
    public static void isConnected(ArrayList<Edge>[] graph){
        if(gcc(graph).size() == 1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }   
    public static boolean isConnectedE(ArrayList<Edge>[] graph){
        int count = 0;
        int n = graph.length;
        boolean[] vis = new boolean[n];
        for(int v=0; v<n; v++){
            if(vis[v] == false){
                count++;
                if(count > 1){
                    return false;
                }
                gcc2(graph, v, vis);
            }
        }
        return true;
    }
    public static void gcc2(ArrayList<Edge>[] graph,int src, boolean[] vis){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(vis[e.nbr] == false){
                gcc2(graph, e.nbr, vis);
            }
        }
    }
    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    // static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dst, boolean[] vis, int criteria, int k, String psf, int wsf) {
        if(src == dst){
            // smallest
            if(spathwt > wsf){
                spathwt = wsf;
                spath = psf+dst;
            }
            if(lpathwt < wsf){
                lpathwt = wsf;
                lpath = psf+dst;
            }
            // ceil
            if(wsf > criteria){
                if(wsf<cpathwt){
                    cpathwt = wsf;
                    cpath = psf+dst;
                }
            }
            if(wsf<criteria){
                if(wsf>fpathwt){
                    fpathwt = wsf;
                    fpath = psf+dst;
                }
            }
            System.out.println(psf+dst +" -- "+wsf);
            return;
        }
        vis[src] = true;
        for(Edge e : graph[src]){
            int nbr = e.nbr;
            int wt = e.wt;
            if(vis[nbr] == false){
                multisolver(graph, nbr, dst, vis, criteria, k, psf+src, wsf+wt);
            }
        }
        vis[src] = false;
    }
    public static boolean bfsForCycle(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(src);

        while(qu.size() > 0) {
            // 1. get + remove
            int rem = qu.remove();
            // 2. mark *
            if(vis[rem] == true) {
                // already visited -> cycle is detected
                return true;
            } else {
                // unvisited -> mark it as visited
                vis[rem] = true;
            }
            // 3. work*
            // 4. add unvisited neighbours
            for(Edge e : graph[rem]) {
                if(vis[e.nbr] == false) {
                    qu.add(e.nbr);
                }
            }
        }
        return false;
    }
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];

        for(int v = 0; v < n; v++) {
            if(vis[v] == false) {
                boolean res = bfsForCycle(graph, v, vis);
                if(res == true) return true;
            }
        }
        return false;
    }
    public class BPair{
        int vtx;
        int level;
        public BPair(int vtx, int level){
            this.vtx = vtx;
            this.level = level;
        }
    }
    // public static boolean isBipartiteComp(ArrayList<Edge>[] graph, int src, int[] vis){
    //     Queue<BPair> qu = new LinkedList<>();
    //     qu.add(new BPair(src, 0));
    //     while(qu.size() > 0){
    //         BPair rem = qu.remove();
    //         if(vis[rem.vtx] != -1){
    //             if(vis[rem.vtx] == rem.level)
    //                 continue;
    //             else
    //                 return false;
    //         }
    //         vis[rem.vtx] = rem.level;
    //         for(Edge e : graph[rem.vtx]){
    //             int nbr = e.nbr;
    //             if(vis[nbr] == -1){
    //                 qu.add(new BPair(nbr,rem.level+1));
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static boolean isBipartite(ArrayList<Edge>[] graph){
    //     int n = graph.length;
    //     int[] vis = new int[n];
    //     Arrays.fill(vis, -1);
        
    //     for(int v=0; v<n; v++){
    //         if(vis[v] == -1){
    //             boolean res = isBipartiteComp(graph,v,vis);
    //             if(res == false)    return false;
    //         }
    //     }
    //     return true;
    // }

    // public static int spreadInfection(ArrayList<Edge>[] graph,)


    // ##########################################################################
    // ##########################################################################
    
    public static class BFSPair{
        int vtx;
        String psf;
        public BFSPair(int vtx, String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void bfs(ArrayList<Edge>[] graph, int src){
        Queue<BFSPair> qu = new LinkedList<>();
        qu.add(new BFSPair(src, ""+src));
        boolean[] vis = new boolean[graph.length]; 
        while(qu.size()>0){
            // 1. peek and remove
            BFSPair rem = qu.remove();
            if(vis[rem.vtx] == false){
                vis[rem.vtx] = true;
                // 2. add children
                for(Edge e:graph[rem.vtx]){
                    qu.add(new BFSPair(e.nbr, rem.psf+e.nbr));
                }
                // 3. work (print)
                System.out.println(rem.vtx+"@"+rem.psf);
            }
        }
    }

    public static int noOfIsland(int[][] graph){
        int count = 0;
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[0].length; j++){
                if(graph[i][j] == 0){
                    count++;
                    gccIsland(graph,i,j);
                }
            }
        }
        return count;
      }
        
    public static int[] xdir = {-1,0,1,0};
    public static int[] ydir = {0,-1,0,1};
    public static void gccIsland(int[][] graph, int x, int y){
        graph[x][y] = -1;
        for(int i=0; i<4; i++){
            int xx = x + xdir[i];
            int yy = y + ydir[i];
            if(xx >= 0 && xx<graph.length && yy>=0 && yy<graph[0].length  && graph[xx][yy] == 0){
                gccIsland(graph,xx,yy);
            }
        }
    }
    // discussed by sir
    public static void bfs_s(ArrayList<Edge>[] graph, int src) {
        Queue<BFSPair> qu = new LinkedList<>();
        qu.add(new BFSPair(src, "" + src));
        boolean[] vis = new boolean[graph.length];

        while(qu.size() > 0) {
            // 1. get + remove
            BFSPair rem = qu.remove();
            // 2. mark *
            if(vis[rem.vtx] == true) {
                // already visited -> continue
                continue;
            } else {
                // unvisited -> mark it as visited
                vis[rem.vtx] = true;
            }
            // 3. work -> printing
            System.out.println(rem.vtx + " @ " + rem.psf);
            // 4. add unvisited neighbours
            for(Edge e : graph[rem.vtx]) {
                if(vis[e.nbr] == false) {
                    qu.add(new BFSPair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }

    public static class DPair implements Comparable<DPair>{
        int vtx;
        int wsf;
        String psf;
        public DPair(int vtx, int wsf, String psf){
            this.psf = psf;
            this.vtx = vtx;
            this.wsf = wsf;
        }
        public int compareTo(DPair o){
            return this.wsf - o.wsf;
        }
    }
    public static void dijsktra(ArrayList<Edge>[] graph, int src){
        PriorityQueue<DPair> pq = new PriorityQueue<>();
        pq.add(new DPair(src,0,""+src));

        boolean[] vis = new boolean[graph.length];
        while(pq.size() > 0){
            // 1. peek + remove
            DPair rem = pq.remove();

            if(vis[rem.vtx] == true){
                continue;
            }
            vis[rem.vtx] = true;
            // 3. work
            System.out.println(rem.vtx +" Via " + rem.psf + " @ "+rem.wsf);
            // 4. add neighbour

            for(Edge e : graph[rem.vtx]){
                int nbr = e.nbr;
                if(vis[nbr] == false){
                    pq.add(new DPair(nbr, rem.wsf+e.wt, rem.psf+nbr));
                }
            }
        }
    }
    
    // public static class PHelper implements Comparable<PHelper>{
    //     int src;
    //     int parent;
    //     int wt;
    //     public PHelper(int src, int parent, int wt){
    //         this.src = src;
    //         this.parent = parent;
    //         this.wt = wt;
    //     }
    //     public int comparetTo(){
            
    //     }
    // }
    // public static void prims(ArrayList<Edge>[] graph){

    // }
    public static void fun(){
        int n = 7;
        ArrayList<Edge>[] graph = createGraph();
        boolean[] visited = new boolean[n];
        boolean ans = hasPath(graph, 0, 6, visited);
        System.out.println(ans);
        display(graph);
        boolean[] v = new boolean[n];
        printAllPaths(graph, 0, 6, v, "",0);
        System.out.println("Multisolver..");
        multisolver(graph,0,6,v,30,4,"",0);
        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + 40 + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + 40 + " = " + fpath + "@" + fpathwt);
        System.out.println("****bfs******");
        bfs(graph,2);
        int[][] arr = { {0,0,1,1},
                        {0,0,1,1},
                        {1,1,0,0},
                        {1,1,0,0}};
        System.out.println("No of Island: "+ noOfIsland(arr));
    }
    public static void main(String[] args){
        fun();
    }    
}
