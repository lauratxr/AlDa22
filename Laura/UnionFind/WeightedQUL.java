public class WeightedQUL {

    private int[] id;
    private int[] sz;

    public WeightedQUL(int N){
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++){
            id[i] = i;                          //Array
            sz[i] = 1;                          //Size "Wurzel" bei 1
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
        if (sz[pRoot] < sz[qRoot]){                 //Wenn Wurzel p kleiner als Wurzel von q
            id[pRoot] = qRoot;                      //dann Wurzel von p gleich Wurzel von q
            sz[pRoot] += sz[pRoot];                 //Wurzel von p plus Wurzel von p
        } else {
            id[qRoot] = pRoot;                      //sonst Wurzel von q gleich Wurzel von p
            sz[pRoot] += sz[qRoot];                 //Wurzel p plus Wurzel von q
        }
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }


    public static void main(String[] args){

//        "test1" "test2"

        In in = new In(args[2]);
        int[] x = in.readAllInts();

        In in2 = new In(args[3]);
        int[] y = in2.readAllInts();

        Stopwatch time = new Stopwatch();
        WeightedQUL a = new WeightedQUL(x.length);

        for (int i = 0; i < x.length; i++) {
            if (a.connected(x[i], y[i])) StdOut.println("Schon verbunden: " + x[i]
                    + " und " + y[i]);
            else {
                a.union(x[i], y[i]);
                StdOut.println("Jetzt durch Aufruf der Union Methode verbunden " + x[i]
                        + " und " + y[i]);
            }
        }

        double watch = time.elapsedTime();
        StdOut.println("elapsed time = " + watch);

    }
}
