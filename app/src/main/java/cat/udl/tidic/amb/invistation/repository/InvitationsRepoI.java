package cat.udl.tidic.amb.invistation.repository;

import cat.udl.tidic.amb.invistation.MODELS.InvitationModel;

public interface InvitationsRepoI {

    public void setEvent(InvitationModel i);
    public InvitationModel getEvent();
    public int getEvents();
    public void storeEvent();

}
