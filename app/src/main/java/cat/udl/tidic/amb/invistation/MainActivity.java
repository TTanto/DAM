package cat.udl.tidic.amb.invistation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cat.udl.tidic.amb.invistation.Controllers.FormPresenter;
import cat.udl.tidic.amb.invistation.Controllers.MainViewPresenter;

public class MainActivity extends AppCompatActivity implements MainViewActions {

    private TextView numEvents;
    private MainViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_create = findViewById(R.id.b_create);
        numEvents = findViewById(R.id.numEvents);


        presenter = new MainViewPresenter(this);
        this.presenter.getEvents();

        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obrim la activitat del formulari
                openForm();
            }
        });
    }
    private void openForm(){
        Intent intent = new Intent(getApplicationContext(), Form.class);
        startActivity(intent);
    }


    @Override
    public void showEvents(int events) {
        numEvents.setText(String.valueOf(events));
    }
}
