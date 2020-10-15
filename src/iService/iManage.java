package iService;

import java.util.List;

public interface iManage<T> {
    void add(T item);
    void update(long phone,T item);
    List<T> delete(long phone);
    List<T> findAll();
    T findByPhone(long phone);
    List<T> findByName(String name);
}
