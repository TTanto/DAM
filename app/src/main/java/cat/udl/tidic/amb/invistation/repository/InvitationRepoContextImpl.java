package cat.udl.tidic.amb.invistation.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import cat.udl.tidic.amb.invistation.MODELS.InvitationModel;
import cat.udl.tidic.amb.invistation.preferences.PreferencesProvider;

public class InvitationRepoContextImpl implements InvitationsRepoI {


   private SharedPreferences mPreferences;


    public InvitationRepoContextImpl() {
        this.mPreferences = PreferencesProvider.providePreferences();
    }

    @Override
    public void setEvent(InvitationModel i) {
        Gson gson = new Gson();
        String i_json = gson.toJson(i);
        this.mPreferences.edit().putString("Invitation",i_json).apply();
    }

    @Override
    public InvitationModel getEvent() {
        Gson gson = new Gson();
        String json = this.mPreferences.getString("Invitation", "");
        return gson.fromJson(json, InvitationModel.class);
    }

    @Override
    public int getEvents() {
        return this.mPreferences.getInt("Events",0);
    }

    @Override
    public void storeEvent() {
        int current = this.mPreferences.getInt("Events",0);
        this.mPreferences.edit().putInt("Events",current + 1).apply();
    }


}
