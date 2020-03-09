package cat.udl.tidic.amb.invistation.Controllers;

import android.content.Intent;
import android.os.Bundle;

import cat.udl.tidic.amb.invistation.MODELS.InvitationModel;
import cat.udl.tidic.amb.invistation.FormViewActions;
import cat.udl.tidic.amb.invistation.repository.InvitationRepoContextImpl;
import cat.udl.tidic.amb.invistation.repository.InvitationsRepoI;

public class FormPresenter {

    /***
     * model = objecte invitació
     * numEvents = String que conté el numero de events
     * nEv = numero de events creats
     */

    private InvitationsRepoI repo;
    private FormViewActions view;



    //private String numEvents;
    //private int nEv;

    public FormPresenter(FormViewActions view) {
        this.view = view;
        this.repo = new InvitationRepoContextImpl();
        //this.numEvents = "";
        //this.nEv = 0;
    }

    public void setInvitation(String desc, String date, String type){
        InvitationModel i = new InvitationModel(desc,date,type);
        repo.setEvent(i);
    }


    public void getInvitation(){
        InvitationModel i = repo.getEvent();
        try {
            this.view.showInvitation(i.getDesc(),i.getDate(), i.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeEvent() {
        this.repo.storeEvent();
    }

}