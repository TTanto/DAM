package cat.udl.tidic.amb.invistation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cat.udl.tidic.amb.invistation.Controllers.FormPresenter;


public class Result_Lparty extends AppCompatActivity implements UserViewActions {

    private TextView ed_desc;
    private TextView ed_date;
    private Button accept;
    private Button cancel;


    private FormPresenter controller = new FormPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__lparty);
        ed_desc = (TextView) findViewById(R.id.descrip);
        ed_date = (TextView) findViewById(R.id.date);
        accept = (Button) findViewById(R.id.accept);
        cancel = (Button)  findViewById(R.id.cancel_r) ;


        Bundle extras = getIntent().getExtras();
        controller.getExtraParameters(extras);
        controller.showBio();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result_Lparty.this, Form.class);
                startActivity(intent);
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Result_Lparty.this, MainActivity.class);
                controller.increaseNumEvents();
                startActivity(intent);
            }
        });



    }


    @Override
    public void actualitzar(String desc, String date) {
        ed_desc.setText(desc);
        ed_date.setText(date);
    }

    @Override
    public void actualitzar(String date) {

    }

}
