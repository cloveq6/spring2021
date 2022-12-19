package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            if (N == TimeAList.countSize) {
                TimeAList.countSize = TimeAList.countSize * 2;
                System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
            }
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int i = 1;
        AList<Integer> ns = new AList<>();
        AList<Double> time = new AList<>();
        Stopwatch sw = new Stopwatch();
        while (i <= 128000 * 20) {
            ns.addLast(i);
            double timeInSeconds = sw.elapsedTime();
            time.addLast(timeInSeconds);
            i = i + 1;
        }
        printTimingTable(ns, time, ns);
    }

    public static int countSize = 1000;

}
