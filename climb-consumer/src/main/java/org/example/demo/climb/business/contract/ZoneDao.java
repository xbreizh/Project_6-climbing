package org.example.demo.climb.business.contract;

import org.example.demo.climb.model.bean.Zone;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneDao extends JpaRepository, Persistable {

    boolean update(Zone zone);

    boolean addZone(Zone zone);
}
