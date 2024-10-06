class Solution {
    static class Pair{
        String var;
        double wt;

        Pair(String var, double wt){
            this.var = var;
            this.wt = wt;
        }

    }

    //step3: write bfs [and call for each query]
    static double bfs(String src, String tar, Map<String, ArrayList<Pair>> adj){
        if(!adj.containsKey(src) || !adj.containsKey(tar)){ //note2
            return -1;
        }

        Set<String> vis = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<Pair>();

        queue.add(new Pair(src, 1)); //note3
        vis.add(src);

        while(!queue.isEmpty()){
            Pair pr = queue.poll();
            String crrStr = pr.var;
            double crrWt = pr.wt;

            if(crrStr.equals(tar)) return crrWt; //note4 use vvvimp .equals when string not ==

            for(Pair nxtPr: adj.get(crrStr)){
                if(!vis.contains(nxtPr.var)){
                    queue.add(new Pair(nxtPr.var, crrWt * nxtPr.wt));
                    vis.add(nxtPr.var);
                }
            }
        }

        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, ArrayList<Pair>> adj = new HashMap<String, ArrayList<Pair>>();

        double[] ans = new double[queries.size()];

        //step 1: create a graph
        for(int i=0; i<equations.size(); i++){
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            double value = values[i];

            adj.putIfAbsent(var1, new ArrayList<>());
            adj.putIfAbsent(var2, new ArrayList<>());

            adj.get(var1).add(new Pair(var2, value));
            adj.get(var2).add(new Pair(var1, 1 / value)); //note1
        }


        //step2: run bfs frm each query
        for(int i=0; i<queries.size(); i++){
            ans[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adj);
        }

        return ans;

    }
}
