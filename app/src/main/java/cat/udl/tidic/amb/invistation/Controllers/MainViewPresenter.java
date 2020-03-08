package cat.udl.tidic.amb.invistation.Controllers;

import cat.udl.tidic.amb.invistation.FormViewActions;
import cat.udl.tidic.amb.invistation.MODELS.InvitationModel;
import cat.udl.tidic.amb.invistation.MainViewActions;
import cat.udl.tidic.amb.invistation.repository.InvitationRepoContextImpl;
import cat.udl.tidic.amb.invistation.repository.InvitationsRepoI;

public class MainViewPresenter {
    private InvitationsRepoI repo;
    private MainViewActions view;


    public MainViewPresenter(MainViewActions view) {
        this.view = view;
        this.repo = new InvitationRepoContextImpl();
    }

    public void getEvents(){
        int events = this.repo.getEvents();
        this.view.showEvents(events);
    }

}
