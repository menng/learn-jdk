package demo.thread;

public class ThreadLocalDemo {
    // 1.8 +
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    // 1.7
//    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
//        @Override
//        public Integer initialValue() {
//            return 0;
//        }
//    };

    public ThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo sn = new ThreadLocalDemo();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private ThreadLocalDemo sn;
        public TestClient(ThreadLocalDemo sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for(int i=0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] -- > sn[" + sn.getNextNum() + "]");
            }
        }
    }
}
