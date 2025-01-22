package api.queue;
import message.Message;
import message.Topic;

public interface Publisher extends Runnable {
    boolean publish(Message<?> message);
    void setTopic(Topic topic);
}
