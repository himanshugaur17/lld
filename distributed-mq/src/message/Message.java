package message;

public class Message<T> {
    String id;
    T data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Message(String id, T data) {
        this.id = id;
        this.data = data;
    }
}
