package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.TopoManager;
import org.example.demo.climb.model.bean.Topo;
import org.example.demo.climb.model.exception.NotFoundException;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CreationTopoAction extends LoginAction implements SessionAware {


    private Topo topo;
    private List<Topo> topoList;
    List<Integer> yearList = new ArrayList<>();
    private int id;



    @Inject
    private TopoManager topoManager;

    // Methods
    public String doCreateTopo() {
        System.out.println("trying to create a topo");
        String vResult= ActionSupport.INPUT;

        for(int i = 1900;i<2222;i++){
            yearList.add(i);
        }
        if(topo!=null){
            if(checkTopoForm(topo)){
                System.out.println("topo as such: "+topo);
                topoManager.addTopo(topo);
                vResult = ActionSupport.SUCCESS;
            }
        }
        return vResult;
    }

    public boolean checkTopoForm(Topo topo){
        int i=0;
        // Check Name
        if(topo.getName().length() < 2 || topo.getName().length() >50){
            this.addFieldError("topo.name", "name must be between 2-50");
            i++;
        }
        // Check Edition
        if(topo.getEdition().length() < 2 || topo.getEdition().length() > 50){
            this.addFieldError("topo.edition", "edition must be between 2-50");
            i++;
        }
        // Check Author
        if(topo.getAuthor().length() < 2 || topo.getAuthor().length() > 50){
            this.addFieldError("topo.author", "author must be between 2-50");
            i++;
        }
        // Check Published Year
        if(topo.getPublishedYear() < 1700 || topo.getPublishedYear() > 2222){
            this.addFieldError("topo.name", "Year must be between 1900-today");
            i++;
        }
        // Check Description
        if(topo.getDescription().length() < 3 || topo.getDescription().length() > 350){
            this.addFieldError("topo.description", "Description must be between 2-50");
            i++;
        }
        // Check Keywords
        if(topo.getKeywords().length() < 2 || topo.getKeywords().length() >50){
            this.addFieldError("topo.keywords", "Keywords must be between 3-350");
            i++;
        }

        // Check Owner
        System.out.println("id "+getSession().get("id"));
        System.out.println("name"+getSession().get("name"));
        System.out.println("values: "+getSession().values().toString());

        System.out.println("name: "+getSession().get("name"));
        System.out.println("id: "+getSession().get("id"));
        if(i>0){
            return false;
        }else{
            return true;
        }

    }

    public String doList() {
        topoList=topoManager.getListTopo();
        System.out.println("trying to get topoList");
        System.out.println("size: " + topoList.size());
        return ActionSupport.SUCCESS;
    }

    // BOOKING
    public String doBooking(){
        topo = topoManager.getTopo(id);
        return ActionSupport.SUCCESS;
    }

    public String doValidateBooking(){
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
    public List<Integer> getYearList() {
        return yearList;
    }

    public void setYearList(List<Integer> yearList) {
        this.yearList = yearList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
