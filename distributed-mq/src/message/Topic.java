package message;

import java.util.ArrayList;
import java.util.List;

public class Topic<T> {
    String topicId;
    String topicName;
    List<Message<T>> messages;

    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.messages = new ArrayList<>();
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void addMessage(Message<T> message) {
        this.messages.add(message);
    }

}
