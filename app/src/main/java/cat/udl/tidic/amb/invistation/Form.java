package cat.udl.tidic.amb.invistation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cat.udl.tidic.amb.invistation.Controllers.FormPresenter;

public class Form extends AppCompatActivity implements FormViewActions{

    private RadioButton r_birth;
    private RadioButton r_lparty;
    private CalendarView calendar;
    private FormPresenter presenter = new FormPresenter(this);
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
                //String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                Calendar c = Calendar.getInstance();
                c.set(year,month,dayOfMonth);
                calendar.setDate(c.getTimeInMillis());
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descri = descripcion.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                String date = sdf.format(new Date(calendar.getDate()));
                String type = "";


                if (r_birth.isChecked()) {
                    type =  "birth";

                }
                else if (r_lparty.isChecked()) {
                    type = "lparty";
                }

                Log.i("OnClick/FORM/setinfo", " s'han actualitzat els valors correctament");

                presenter.setInvitation(descri,date,type);
                presenter.getInvitation();

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
    public void showInvitation(String desc, String date, String type) throws Exception {

        Intent intent = new Intent();
        intent = new Intent(getApplicationContext(), ResultForm.class);
        intent.putExtra("type",type);
        startActivity(intent);

    }


}


