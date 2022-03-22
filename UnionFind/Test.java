public class Test {

    public static void main(String[] args) {

        int N = 10;
        UF uf = new UF(N);

        int p[] = {4,3,6,9,2,5,7,6,4};
        int q[] = {3,8,5,4,1,0,2,1,8};

        StdOut.println("Ich nutze die UF API");

        for (int i = 0; i < p.length; i++){
            if(uf.connected(p[i], q[i])) StdOut.println("Schon verbunden: " + p[i]
            + " und " + q[i]);
            else {
            uf.union(p[i], q[i]);
            StdOut.println("Jetzt durch Aufruf der Union Methode verbunden " + p[i]
            + " und " + q[i]);
        }
      }
    }
}
