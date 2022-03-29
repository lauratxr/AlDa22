import java.io.FileNotFoundException;

public class ClientA {
    public static void main(String[] args) throws FileNotFoundException {
        In in = new In(args[0]);
        int [] a= in.readAllInts();

    }
}
