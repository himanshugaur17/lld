import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerInventory {
    private Queue<String> queue = new LinkedList<>();
    private final int capacity = 10;
    private Semaphore produce = new Semaphore(capacity);
    private Semaphore consume = new Semaphore(0);
    private ReentrantLock reentrantLock = new ReentrantLock(true);

    private static class Producer implements Runnable {
        private final int id;
        private final ProducerConsumerInventory producerConsumerInventory;

        public Producer(int id, ProducerConsumerInventory producerConsumerInventory) {
            this.id = id;
            this.producerConsumerInventory = producerConsumerInventory;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    producerConsumerInventory.produce.acquire();
                    producerConsumerInventory.reentrantLock.lock();
                    int item = produceItem();
                    producerConsumerInventory.queue.offer(String.format("item: %s added by %s", item, id));
                    producerConsumerInventory.consume.release();
                } catch (InterruptedException e) {
                    System.out.println("producer" + id + " got interrupted while dormantly waiting for permi");
                } catch (Exception e) {
                    // make up of lost permit
                    producerConsumerInventory.produce.release();
                } finally {
                    producerConsumerInventory.reentrantLock.unlock();
                }
            }
        }

        private int produceItem() {
            return (int) (Math.random() * 100);
        }

    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ProducerConsumerInventory pci = new ProducerConsumerInventory();

        for (int i = 0; i < 5; i++) {
            Producer producer = new Producer(i, pci);
            executorService.submit(producer);
        }
    }
}
