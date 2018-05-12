import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by alanzhang211 on 2018/5/12.
 */
public class CyclicBarrierDemo {
    //4位运动员，都到达终点，结束
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new FinishPoint());

    static class FinishPoint implements Runnable {
        @Override
        public void run() {
            System.out.println("全部到达终点！");
        }
    }

    public static void main(String[] args) {
        List<Runner> runners = new ArrayList<Runner>(4);
        for (int i = 0; i < 4; i++) {
            runners.add(new Runner(cyclicBarrier, "runner" + "-" + i));
        }
        Executor executor = Executors.newFixedThreadPool(5);
        for (Runner runner : runners) {
            executor.execute(runner);
        }
    }
}
