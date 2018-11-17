package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.TopoManager;
import org.example.demo.climb.model.bean.Topo;
import org.example.demo.climb.model.exception.NotFoundException;
import javax.inject.Inject;
import java.util.List;

public class CreationTopoAction extends LoginAction implements SessionAware {


    private Topo topo;
    private List<Topo> topoList;


    @Inject
    private TopoManager topoManager;

    // Methods
    public String doCreateTopo() throws NotFoundException {
        System.out.println("trying to create a topo");
        String vResult= ActionSupport.INPUT;
        if(topo!=null){
            topoManager.addTopo(topo);
            vResult = ActionSupport.SUCCESS;
        }
        return vResult;
    }

    public String doList() {
        topoList=topoManager.getListTopo();
        System.out.println("trying to get topoList");
        System.out.println("size: " + topoList.size());
        return ActionSupport.SUCCESS;
    }

    // Getters and Setters

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }
}
