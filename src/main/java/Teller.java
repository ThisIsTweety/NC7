public class Teller extends Thread {
    private String name;
    private BlockingQueue blockingQueue;
    final int SERVICE_TIME = 3000;
    Teller(String name, BlockingQueue blockingQueue) {
        this.name = name;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            Client client = blockingQueue.get();
            System.out.println("Start " + name);
            try {
                sleep(SERVICE_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client.operation();
            System.out.println("end " + name);
        }

    }

}
