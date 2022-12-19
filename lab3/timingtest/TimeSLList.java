package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }


    public static void genStatics(SLList<Integer> data, AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts){
        Ns.addLast(data.size());
        int i = 0;
        Stopwatch sw = new Stopwatch();
        while (i < 10000){
            data.getLast();
            i++;
        }
        double timeInSeconds = sw.elapsedTime();
        times.addLast(timeInSeconds);
        opCounts.addLast(10000);

    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList<Integer> data = new SLList<>();
        AList<Integer> ns = new AList<>();
        AList<Integer> ops = new AList<>();
        AList<Double> times = new AList<>();
        int i = 1;
        while (i <= 128000){
            data.addLast(i);
            if (data.size() == TimeSLList.countSize){
                genStatics(data, ns, times, ops);
                TimeSLList.countSize *= 2;
            }
            i++;
        }
        printTimingTable(ns, times, ops);
    }
    public static int countSize = 1000;

}
