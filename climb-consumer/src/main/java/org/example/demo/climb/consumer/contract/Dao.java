package org.example.demo.climb.consumer.contract;


import javax.inject.Named;
import java.util.List;

@Named
public interface Dao {

    void setCl(Class cl);

    List getAll();

    void add(Object o);

    Object getById(int id);

    void delete(int id);

    void update(Object o, int id);


}
