package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.ZoneDao;
import org.example.demo.climb.consumer.contract.manager.ZoneManager;
import org.example.demo.climb.model.bean.Zone;
import org.example.demo.climb.model.bean.member.Member;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("zoneManager")
public class ZoneManagerImpl implements ZoneManager {

    @Inject
    private ZoneDao zoneDao;
    private Zone zone;
    @Inject
    private MemberDao memberDao;

    @Override
    public List<Zone> getListZone() {
        return zoneDao.getAll();
    }

    @Override
    public void addZone(Zone zone) {
        Member m = (Member) memberDao.getById(1);
        zone.setCreatorZone(m);
        zoneDao.add(zone);
    }

    @Override
    public Zone getZone(Integer pId) {
        return (Zone) zoneDao.getById(pId);
    }

    @Override
    public Zone getZone(String name) {
        return null;
    }

    @Override
    public void updateZone(Zone zone) {

    }

    @Override
    public void deleteZone(int id) {
        zoneDao.delete(id);
    }

}
