package cache;

public interface Cache<KEY, VALUE> {
    public VALUE get(KEY key);

    public void set(KEY key, VALUE value);
}
