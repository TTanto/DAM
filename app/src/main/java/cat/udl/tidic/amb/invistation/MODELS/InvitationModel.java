package cat.udl.tidic.amb.invistation.MODELS;

import android.graphics.drawable.Drawable;

public class InvitationModel {

    private String desc;
    private String type;
    private String date;


    public InvitationModel(String desc, String date, String type) {
        this.desc = desc;
        this.type = type;
        this.date = date;

    }


    public String getDesc() {
        return desc;
    }
    public String getType() {
        return type;
    }
    public String getDate() {
        return date;
    }


}
