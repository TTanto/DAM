package cat.udl.tidic.amb.invistation.MODELS;

import android.graphics.drawable.Drawable;

public class InvitationModel {

    private String desc;
    private String type;
    private String date;


    public InvitationModel(String desc, String type, String date) {
        this.desc = desc;
        this.type = type;
        this.date = date;

    }

    public InvitationModel() {
        this.desc = "";
        this.type = "";
        this.date = "";

    }



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
