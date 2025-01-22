package api.queue;
import java.util.List;

import message.Message;

public interface Subscriber {
    void consumeViaPush(List<Message<?>> message);

    void consumeViaPull();

    boolean resetOffset();

    int getOffSet();
}
