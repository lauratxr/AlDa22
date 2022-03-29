public class ThreeSum {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for(int k = j+1; k < n; k++){
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;

    }
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k= j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

//        int N = 10;
//        WeightedQUL qul = new WeightedQUL(N);
//
//        int p[] = {4,3,6,9,2,5,7,6,4};
//        int q[] = {3,8,5,4,1,0,2,1,8};
//
//        Stopwatch watch = new Stopwatch();
//        for (int i = 0; i < p.length; i++) {
//            if (qul.connected(p[i], q[i])) StdOut.println("Schon verbunden: " + p[i]
//                    + " und " + q[i]);
//            else {
//                qul.union(p[i], q[i]);
//                StdOut.println("Jetzt durch Aufruf der Union Methode verbunden " + p[i]
//                        + " und " + q[i]);
//            }
//        }
//
//        double time = watch.elapsedTime();
//        StdOut.println("elapsed time = " + time);


        int N2 = 8;
        int a[] = {30, -40, -20, -10, 40, 0, 10, 5};

        StdOut.println("Three Sum\n" + count(a));


    }
}
