package api.queue.impl;

import api.queue.MessageQueue;
import api.queue.Publisher;
import message.Message;
import message.Topic;

public class PositiveThoughtsPublisher implements Publisher {
    private Topic topic;
    private MessageQueue mq;

    public PositiveThoughtsPublisher(Topic topic, MessageQueue mq) {
        this.topic = topic;
        this.mq = mq;
    }

    @Override
    public boolean publish(Message<?> message) {
        mq.publish(topic, message);
        return true;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    @Override
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
