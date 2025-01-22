package api.queue.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import api.queue.MessageQueue;
import api.queue.Subscriber;
import message.Message;
import message.Topic;

public class DistMQImpl<T> implements MessageQueue<T> {
    private final ExecutorService publishExecutorService;
    private final List<Topic<T>> topics;

    public DistMQImpl() {
        this.publishExecutorService = Executors.newFixedThreadPool(2);
        this.topics = new ArrayList<>();
    }

    @Override
    public boolean publish(Topic<T> topic, Message<T> message) {
        try {
            publishExecutorService.submit(() -> {
                try {
                    Thread.sleep(3000 + new Random().nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                topic.addMessage(message);
                System.out.println(Thread.currentThread().getName() + " Added:  " + message.getData());
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public boolean subscribe(Topic<T> topic, Subscriber subscriber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subscribe'");
    }

    @Override
    public void addTopic(Topic<T> topic) {
        topics.add(topic);
    }

}
