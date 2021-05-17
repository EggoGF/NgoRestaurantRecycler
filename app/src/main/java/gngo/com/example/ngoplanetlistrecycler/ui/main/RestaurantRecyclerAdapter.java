package gngo.com.example.ngoplanetlistrecycler.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gngo.com.example.ngoplanetlistrecycler.R;

public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RestaurantRecyclerAdapter.ViewHolder> {
    public interface OnAdapterItemInteraction{
        void onItemSelected(Restaurant restaurant, Integer position);
    }

    private final List<Restaurant> mvalues;
    final OnAdapterItemInteraction mListener;

    public RestaurantRecyclerAdapter(List<Restaurant> items, OnAdapterItemInteraction listener){
        mvalues = items;
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        final ImageView restaurantLogolv;
        final TextView restaurantNameTv;
        final TextView restaurantTypeTv;

        public ViewHolder(View view){
            super(view);
            mView = view;
            restaurantLogolv = view.findViewById(R.id.restaurant_logo);
            restaurantNameTv = view.findViewById(R.id.restaurant_name);
            restaurantTypeTv = view.findViewById(R.id.restaurant_type);
        }

        @Override
        public String toString(){
            return super.toString();
        }
    }



    @NonNull
    @Override
    public RestaurantRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantRecyclerAdapter.ViewHolder holder, int position) {
        holder.restaurantNameTv.setText(mvalues.get(position).getName());
        holder.restaurantTypeTv.setText(mvalues.get(position).getType());
        holder.restaurantLogolv.setImageResource(mvalues.get(position).getLogo());

        final Restaurant selectedRestaurant = mvalues.get(position);
        final int pos = holder.getAdapterPosition();

        holder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (null != mListener){
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemSelected(selectedRestaurant, pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mvalues.size();
    }

    public void add(Restaurant item){
        mvalues.add(item);
        notifyItemInserted(mvalues.size()-1);
    }
}
