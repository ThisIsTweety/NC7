
import java.util.ArrayList;

public class BlockingQueue {

    ArrayList<Client> clients = new ArrayList<>();

    public synchronized void put(Client client) {
        clients.add(client);
        notify();
    }

    public synchronized Client get() {
        while (clients.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Client client = clients.get(0);
        clients.remove(client);
        return client;
    }
    public synchronized int getLength(){
        return clients.size();
    }
}
