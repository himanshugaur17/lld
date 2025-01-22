package api.queue;

import message.Message;
import message.Topic;

public interface MessageQueue<T> {
    boolean publish(Topic<T> topic, Message<T> message);

    boolean subscribe(Topic<T> topic, Subscriber subscriber);

    void addTopic(Topic<T> topic);
}
