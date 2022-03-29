public class WQUN {

    private int[] id;
    private int[] sz;

    public WQUN(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

//
//    public class TwoSum {
//
//        // print distinct pairs (i, j) such that a[i] + a[j]  = 0
//        public static void printAll(int[] a) {
//            int n = a.length;
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    if (a[i] + a[j] == 0) {
//                        StdOut.println(a[i] + " " + a[j]);
//                    }
//                }
//            }
//        }


        public static void main(String[] args) {

            int N = 10;
            WQUN wqun = new WQUN(N);
            Stopwatch stopwatch = new Stopwatch();

            int p[] = {4, 3, 6, 9, 2, 5, 7, 6, 4};
            int q[] = {3, 8, 5, 4, 1, 0, 2, 1, 8};

            In in = new In(args[0]);
            int[] x = in.readAllInts();
            WQUN a = new WQUN(x.length);

            In in2 = new In(args[1]);
            int[] y = in2.readAllInts();
            WQUN b = new WQUN(y.length);


            StdOut.println("");
            stopwatch.elapsedTime();

            for (int i = 0; i < x.length; i++) {
                if (wqun.connected(x[i], y[i]))
                    StdOut.println("P " + x[i] + " und Q " + y[i] + " sind schon verbunden");
                else {
                    wqun.union(x[i], y[i]);
                    StdOut.println("P " + x[i] + " und Q " + y[i] + " sind jetzt durch den WQU verbunden");
                }
            }
            StdOut.println(stopwatch.elapsedTime());



        }


}