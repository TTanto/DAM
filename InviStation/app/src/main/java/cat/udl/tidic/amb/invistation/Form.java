package cat.udl.tidic.amb.invistation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;

import cat.udl.tidic.amb.invistation.Controllers.FormPresenter;

public class Form extends AppCompatActivity implements UserViewActions {

    private RadioButton r_birth;
    private RadioButton r_lparty;
    private CalendarView calendar;
    private FormPresenter controller = new FormPresenter(this);;
    private Button create;
    private EditText descripcion;
    private Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);

        create = (Button) findViewById(R.id.b_create);
        descripcion = (EditText) findViewById(R.id.editText_desc);
        calendar = (CalendarView) findViewById(R.id.calendarView);
        cancel = (Button) findViewById(R.id.cancel);
        r_birth = (RadioButton) findViewById(R.id.r_birth);
        r_lparty = (RadioButton) findViewById(R.id.r_lparty);



        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                controller.getCalendarResource(year, month, dayOfMonth);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descri = descripcion.getText().toString();
                String date = controller.getDate();
                Intent intent = new Intent();

                if (r_birth.isChecked()) {
                    Log.i("setInvitation/", "-----------------birht122");
                    intent = new Intent(Form.this, Result_Birth.class);
                    Log.i("setInvitation/", "-----------------form ---> BIRTH");
                    controller.setInfo(descri, date, "birth");

                }
                if (r_lparty.isChecked()) {
                    Log.i("setInvitation/", "-----------------elparty122");
                    intent = new Intent(Form.this, Result_Lparty.class);
                    Log.i("setInvitation/", "-----------------form ---> LPARTY");
                    controller.setInfo(descri, date, "lparty");
                }

                Log.i("OnClick/FORM/setinfo", " s'han actualitzat els valors correctament");
                controller.putExtraInIntent(intent);
                startActivity(intent);


            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form.this, MainActivity.class);

                startActivity(intent);


            }
        });

    }


    @Override
    public void actualitzar(String message, String date) {

    }

    @Override
    public void actualitzar(String num_events) {

    }
}


