package cat.udl.tidic.amb.invistation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import cat.udl.tidic.amb.invistation.Controllers.FormPresenter;

public class ResultForm extends AppCompatActivity implements FormViewActions {


    private TextView ed_desc;
    private TextView ed_date;
    private FormPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String type = Objects.requireNonNull(extras).getString("type");


        switch (Objects.requireNonNull(type)){

            case "birth":
                setContentView(R.layout.activity_result_birth);
                break;
            case "lparty":
                setContentView(R.layout.activity_result__lparty);
                break;
            default:
                setContentView(R.layout.activity_result_birth);

        }

        ed_desc = (TextView) findViewById(R.id.descrip);
        ed_date = (TextView) findViewById(R.id.date);
        Button accept =  findViewById(R.id.accept);
        Button cancel =  findViewById(R.id.cancel_r);

        presenter = new FormPresenter(this);
        presenter.getInvitation();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), MainActivity.class);
                presenter.storeEvent();
                startActivity(intent);
            }
        });



    }


    @Override
    public void showInvitation(String desc, String date, String type) throws Exception {
        ed_date.setText(date);
        ed_desc.setText(desc);
    }
}
