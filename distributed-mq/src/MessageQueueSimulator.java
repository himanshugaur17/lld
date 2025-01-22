import api.queue.MessageQueue;
import api.queue.Publisher;
import api.queue.impl.DistMQImpl;
import api.queue.impl.PositiveThoughtsPublisher;
import message.Message;
import message.Topic;

public class MessageQueueSimulator {
    public static void main(String[] args) throws Exception {
        MessageQueue mq = new DistMQImpl();
        Topic mindTopic = new Topic("1", "MindTopic");
        Publisher mPosPublisher = new PositiveThoughtsPublisher(mindTopic, mq);
        Publisher mPosPublisher2 = new PositiveThoughtsPublisher(mindTopic, mq);
        Publisher mPosPublisher3 = new PositiveThoughtsPublisher(mindTopic, mq);
        Thread th1 = new Thread(() -> {
            mPosPublisher.publish(new Message<String>("id-1", "my-first-message"));
            System.out.println(Thread.currentThread().getName() + "waited for the mq to confirm message publication");
        }, "mpos-thread-1");
        Thread th2 = new Thread(() -> {
            mPosPublisher2.publish(new Message<String>("id-2", "my-first-message-pub-2"));
            System.out.println(Thread.currentThread().getName() + "waited for the mq to confirm message publication");
        }, "mpos-thread-2");
        Thread th3 = new Thread(() -> {
            mPosPublisher3.publish(new Message<String>("id-2", "my-first-message-pub-3"));
            System.out.println(Thread.currentThread().getName() + "waited for the mq to confirm message publication");
        }, "mpos-thread-3");
        th1.setDaemon(true);
        th2.setDaemon(true);
        th1.start();
        th2.start();
        th3.start();
        th1.join();
        th2.join();
        th3.join();
    }
}
