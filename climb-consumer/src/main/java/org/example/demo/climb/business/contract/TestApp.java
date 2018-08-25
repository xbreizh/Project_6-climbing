package org.example.demo.climb.business.contract;

import javax.inject.Inject;

public class TestApp {

    @Inject
    private MemberDao memberDao;

    public void testage() {

        if (memberDao == null) {
            System.out.println(memberDao.getMemberList().size());
        }
    }
}
