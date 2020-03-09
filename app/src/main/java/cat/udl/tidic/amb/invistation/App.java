package cat.udl.tidic.amb.invistation;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

import cat.udl.tidic.amb.invistation.preferences.PreferencesProvider;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PreferencesProvider.init(this);
    }
}