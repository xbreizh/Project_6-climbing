package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.climb.Spot;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotDao extends JpaRepository, Persistable {

    boolean update(Spot spot);

    boolean addSpot(Spot spot);
}
