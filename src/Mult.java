import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Mult implements Callable<double[][]> {
    ArrayList<ArrayList<Double>> A;
    ArrayList<ArrayList<Double>> B;
    int start;
    int end;
    public double[][] C;

    public Mult(ArrayList<ArrayList<Double>> a,
                ArrayList<ArrayList<Double>> b, int s, int e) {
        A = a;
        B = b;
        C = new double[a.size()][b.get(0).size()];
        //System.out.println("A[" + A.length + "x" + A[0].length + "], " + "B[" + B.length + "x" + B[0].length + "]," + "C[" + C.length + "x" + C[0].length + "]");
        start = s;
        end = e;
    }

    @Override
    public double[][] call() {
        for (int i = start; i < end; i++) {
            for (int k = 0; k < B.size(); k++) {
                for (int j = 0; j <  B.get(0).size(); j++) {
                    C[i][j] += A.get(i).get(k) * B.get(k).get(j);
                }
            }
        }
        return C;
    }
}