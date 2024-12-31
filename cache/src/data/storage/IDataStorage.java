package data.storage;

public interface IDataStorage<KEY,VALUE> {
    VALUE get(KEY key);
    void put(KEY key, VALUE value);
}
