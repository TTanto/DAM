package cat.udl.tidic.amb.invistation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cat.udl.tidic.amb.invistation.Controllers.FormPresenter;

public class MainActivity extends AppCompatActivity implements UserViewActions {

    private FormPresenter controller = new FormPresenter(this);
    private Button button_create;
    private TextView numEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_create = (Button) findViewById(R.id.b_create);
        numEvents = (TextView) findViewById(R.id.numEv);

        //Actualizem text numevents
        controller.showNumEv();
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obrim la activitat del formulari
                openForm();
            }
        });
    }
    private void openForm(){
        Intent intent = new Intent(this, Form.class);
        startActivity(intent);
    }

    @Override
    public void actualitzar(String message, String date) {

    }

    @Override
    public void actualitzar(String numEv) {
        numEvents.setText(numEv);
    }

}
