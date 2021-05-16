package gngo.com.example.ngoplanetlistrecycler.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gngo.com.example.ngoplanetlistrecycler.R;

public class RestaurantListFragment extends Fragment implements RestaurantRecyclerAdapter.OnAdapterItemInteraction{

    private PlanetListViewModel mViewModel;

    private int mPosition;
    private List<Planet> planet_data;
    RestaurantRecyclerAdapter planetRecyclerAdapter;

    public static RestaurantListFragment newInstance() {
        return new RestaurantListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.restaurant_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlanetListViewModel.class);

        Button whatButton = getActivity().findViewById(R.id.planetWhatIsItBtn);
        whatButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                clickWhatIsItButton();
            }
        });

        // Set up the data
        planet_data = setupPlanets();

        // Instantiate the recyclerView
        RecyclerView recyclerView = getActivity().findViewById(R.id.planetRecyclerView);

        // Instantiate the layoutManager and add it into the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Instantiate the recyclerViewAdapter, pass in data and reference to this object
        planetRecyclerAdapter = new RestaurantRecyclerAdapter(planet_data, this);

        // Add the adapter to the recyclerView
        recyclerView.setAdapter(planetRecyclerAdapter);
    }

    private void clickWhatIsItButton(){
        String message = planet_data.get(mPosition).name + " "
                + getResources().getString(R.string.message_is_a) + " "
                + planet_data.get(mPosition).type;
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private List<Planet> setupPlanets(){
        String type_planet = getResources().getString(R.string.type_planet).toString();
        String type_minor_planet = getResources().getString(R.string.type_minor_planet).toString();
        List<Planet> planet_data_list;

        Planet[] planets = new Planet[]{
                new Planet(R.drawable.mercury_symbol, getString(R.string.planet_mercury), type_planet),
                new Planet(R.drawable.venus_symbol, getString(R.string.planet_venus), type_planet),
                new Planet(R.drawable.earth_symbol, getString(R.string.planet_earth), type_planet),
                new Planet(R.drawable.mars_symbol, getString(R.string.planet_mars), type_planet),
                new Planet(R.drawable.jupiter_symbol, getString(R.string.planet_jupiter), type_planet),

        };

        // Convert array to List.
        planet_data_list = new ArrayList<>(Arrays.asList(planets));
        return planet_data_list;

    }

    @Override
    public void onItemSelected(Planet planet, Integer position) {
        String item = planet.getName();
        Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
        mPosition = position;
    }
}