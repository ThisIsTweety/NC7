public class Main {
    public static void main(String[] args) {
        int N = 3;
        CashBox cashBox = new CashBox();
        cashBox.setMoney(100);
        BlockingQueue[] queues = new BlockingQueue[N];
        Thread[] teller = new Thread[N];

        for(int i = 0; i<N;i++){
            queues[i] = new BlockingQueue();
            teller[i] = new Teller("Teller" + i, queues[i]);
            teller[i].start();
        }

        Thread generator = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    BlockingQueue queue = min(queues);
                    queue.put(new Client(cashBox, rnd(1)));
                    try {
                        Thread.sleep(900);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        generator.start();



    }

    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }
    public static BlockingQueue min(BlockingQueue[] blockingQueues){
        int min = 9999;
        BlockingQueue bqmin=null;
        for(BlockingQueue blockingQueue : blockingQueues)
            if(blockingQueue.getLength() < min){
                bqmin = blockingQueue;
                min = blockingQueue.getLength();
            }

        return bqmin;
    }
}
