package cat.udl.tidic.amb.invistation.Controllers;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import cat.udl.tidic.amb.invistation.Form;
import cat.udl.tidic.amb.invistation.MODELS.InvitationModel;
import cat.udl.tidic.amb.invistation.UserViewActions;

public class FormPresenter {

    /***
     * model = objecte invitació
     * numEvents = String que conté el numero de events
     * nEv = numero de events creats
     */
    protected InvitationModel model;
    private UserViewActions view;
    private String numEvents;
    private int nEv;

    public FormPresenter(UserViewActions view) {
        this.view = view;
        this.model = new InvitationModel();
        this.numEvents = "";
        this.nEv = 0;
    }




    // Actualitzem la informació del nostre Model
    public void setInfo(String desc, String date, String type) {
        this.model.setDate(date);
        this.model.setDesc(desc);
        this.model.setType(type);


    }

    //insertar atributs per a passar entre activitat Form ---> Result
    public void putExtraInIntent(Intent intent) {
        intent.putExtra("descripcio", model.getDesc());
        intent.putExtra("date", model.getDate());
        intent.putExtra("type", model.getType());

    }

    //Recollim els atributs que hem solicitat al formulari
    public void getExtraParameters(Bundle extras) {
        String data = extras.getString("date");
        String descr = extras.getString("descripcio");
        String type = extras.getString("type");
        setInfo(descr, data, type);


    }
    //Recollir la data de la vista del calendari
    public void getCalendarResource(int year, int month, int day) {

        String Date = day + "-" + (month + 1) + "-" + year;
        model.setDate(Date);
    }

    public String getDate() {
        return this.model.getDate();
    }

    //Acutalitzem els valors del resultat
    public void showBio() {
        view.actualitzar(model.getDesc(), model.getDate());
    }

    //Actualitzar el num events
    public void showNumEv() {
        view.actualitzar(this.numEvents);
    }


    public String getNumEv() {
        return this.numEvents;
    }

    //Actualitzem el valor
    public void increaseNumEvents() {
        this.numEvents = this.numEvents + "X";
        this.nEv++;

    }

    public int getnEv() {
        return this.nEv;
    }
}