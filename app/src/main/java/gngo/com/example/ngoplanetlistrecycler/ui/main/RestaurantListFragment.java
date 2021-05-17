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

    private RestaurantListViewModel mViewModel;

    private int mPosition;
    private List<Restaurant> restaurant_data;
    RestaurantRecyclerAdapter restaurantRecyclerAdapter;

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
        mViewModel = new ViewModelProvider(this).get(RestaurantListViewModel.class);

        Button whatButton = getActivity().findViewById(R.id.planetWhatIsItBtn);
        whatButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                clickWhatIsItButton();
            }
        });

        // Set up the data
        restaurant_data = setupRestaurants();

        // Instantiate the recyclerView
        RecyclerView recyclerView = getActivity().findViewById(R.id.planetRecyclerView);

        // Instantiate the layoutManager and add it into the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Instantiate the recyclerViewAdapter, pass in data and reference to this object
        restaurantRecyclerAdapter = new RestaurantRecyclerAdapter(restaurant_data, this);

        // Add the adapter to the recyclerView
        recyclerView.setAdapter(restaurantRecyclerAdapter);
    }

    private void clickWhatIsItButton(){
        String message = restaurant_data.get(mPosition).name + " "
                + getResources().getString(R.string.message_is_a) + " "
                + restaurant_data.get(mPosition).type
                + " restaurant in "
                + restaurant_data.get(mPosition).location
                + ".";
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private List<Restaurant> setupRestaurants(){
        /*String type_planet = getResources().getString(R.string.type_planet).toString();
        String type_minor_planet = getResources().getString(R.string.type_minor_planet).toString();*/
        List<Restaurant> restaurant_data_list;

        Restaurant[] planets = new Restaurant[]{
                new Restaurant(R.drawable.mercury_symbol, getString(R.string.name_spoon_house), getString(R.string.type_italian),
                        getString(R.string.cost_two), getString(R.string.location_gardena)),
                new Restaurant(R.drawable.venus_symbol, getString(R.string.name_leos_tacos), getString(R.string.type_mexican),
                        getString(R.string.cost_one), getString(R.string.location_los_angeles)),
                new Restaurant(R.drawable.earth_symbol, getString(R.string.name_sam_woo), getString(R.string.type_chinese),
                        getString(R.string.cost_two), getString(R.string.location_alhambra)),
                new Restaurant(R.drawable.mars_symbol, getString(R.string.name_phillipe), getString(R.string.type_sandwich),
                        getString(R.string.cost_two), getString(R.string.location_los_angeles)),
                new Restaurant(R.drawable.jupiter_symbol, getString(R.string.name_apple_pan), getString(R.string.type_burger),
                        getString(R.string.cost_two), getString(R.string.location_los_angeles)),

        };

        // Convert array to List.
        restaurant_data_list = new ArrayList<>(Arrays.asList(planets));
        return restaurant_data_list;

    }

    @Override
    public void onItemSelected(Restaurant restaurant, Integer position) {
        String item = restaurant.getName();
        Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
        mPosition = position;
    }
}