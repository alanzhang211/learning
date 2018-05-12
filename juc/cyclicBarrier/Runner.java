import java.util.concurrent.CyclicBarrier;

/**
 * 运动员实现类
 * Created by alanzhang211 on 2018/5/12.
 */
public class Runner implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String name;

    public Runner(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("运动员：" + name + " 到达终点！");
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
        }
    }
}
