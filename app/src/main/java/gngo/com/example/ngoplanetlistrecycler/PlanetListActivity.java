package gngo.com.example.ngoplanetlistrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import gngo.com.example.ngoplanetlistrecycler.ui.main.PlanetListFragment;

public class PlanetListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_list_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PlanetListFragment.newInstance())
                    .commitNow();
        }
    }
}