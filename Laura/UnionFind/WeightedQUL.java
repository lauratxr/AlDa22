public class WeightedQUL {

    private int[] id;
    private int[] sz;

    public WeightedQUL(int N){
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q ){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[pRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String[] args) {

        int N = 10;
        WeightedQUL qul = new WeightedQUL(N);

        int p[] = {4,3,6,9,2,5,7,6,4};
        int q[] = {3,8,5,4,1,0,2,1,8};

//        In in = new In(args[0]);
//        int[] x = in.readAllInts();


        StdOut.println("Ich nutze die WeightedQu API");

        Stopwatch watch = new Stopwatch();
        watch.elapsedTime();

        for (int i = 0; i < p.length; i++) {
            if (qul.connected(p[i], q[i])) StdOut.println("Schon verbunden: " + p[i]
                    + " und " + q[i]);
            else {
                qul.union(p[i], q[i]);
                StdOut.println("Jetzt durch Aufruf der Union Methode verbunden " + p[i]
                        + " und " + q[i]);
            }
        }

        StdOut.println(watch.elapsedTime());

    }
}
