package org.example.demo.climb.consumer.contract;

import javax.inject.Named;
import java.util.List;

@Named
public interface Dao {

    // Create
    void add(Object o);

    // Get
    List getAll();

    Object getById(int id);

    // Update
    void update(Object o);

    // Delete
    void delete(Object o);


}
