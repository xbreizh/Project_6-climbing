package org.example.demo.climb.business;

import org.example.demo.climb.business.contract.Logino;

import javax.inject.Inject;
import javax.inject.Named;

@Named("df")
public class Baro {

    @Inject
    private Logino logino;

    public void Kro() {
        if (logino == null) {
            System.out.println("Login is null");
        } else {
            System.out.println(logino.checkLogin().getName());
        }
    }
}
