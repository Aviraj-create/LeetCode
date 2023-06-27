class Solution {
    class Edge {
        String destination;
        double weight;

        public Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, ArrayList<Edge>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> temp = equations.get(i);

            if (!adj.containsKey(temp.get(0))) {
                adj.put(temp.get(0), new ArrayList<Edge>());
            }

            if (!adj.containsKey(temp.get(1))) {
                adj.put(temp.get(1), new ArrayList<Edge>());
            }

            adj.get(temp.get(0)).add(new Edge(temp.get(1), values[i]));
            adj.get(temp.get(1)).add(new Edge(temp.get(0), 1 / values[i]));
        }
        double[] ans = new double[queries.size()];
        for (int j = 0; j < queries.size(); j++) {
            List<String> list = queries.get(j);
            String source = queries.get(j).get(0);
            String d = queries.get(j).get(1);
            if (!adj.containsKey(list.get(0)) || !adj.containsKey(list.get(1))) {
                ans[j] = -1.0;
                continue;
            }
            if (source.equals(d)) {
                ans[j] = 1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();
            ans[j] = dfs(source, d, visited, adj);
        }

        return ans;
    }

    public double dfs(String curr, String desti, Set<String> visited, Map<String, ArrayList<Edge>> adj) {
        if (curr.equals(desti))
            return 1.0;

        if (!adj.containsKey(curr))
            return -1.0;

        visited.add(curr);

        for (Edge temp : adj.get(curr)) {
            if (!visited.contains(temp.destination)) {
                double result = dfs(temp.destination, desti, visited, adj);
                if (result != -1.0)
                    return result * temp.weight;
            }
        }

        return -1.0;
    }
}