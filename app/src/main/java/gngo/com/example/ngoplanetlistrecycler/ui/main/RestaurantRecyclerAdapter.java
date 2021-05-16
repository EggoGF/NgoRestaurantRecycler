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
        void onItemSelected(Planet planet, Integer position);
    }

    private final List<Planet> mvalues;
    final OnAdapterItemInteraction mListener;

    public RestaurantRecyclerAdapter(List<Planet> items, OnAdapterItemInteraction listener){
        mvalues = items;
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        final ImageView planetLogolv;
        final TextView planetNameTv;
        final TextView planetTypeTv;

        public ViewHolder(View view){
            super(view);
            mView = view;
            planetLogolv = view.findViewById(R.id.restaurant_logo);
            planetNameTv = view.findViewById(R.id.restaurant_name);
            planetTypeTv = view.findViewById(R.id.restaurant_type);
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
        holder.planetNameTv.setText(mvalues.get(position).getName());
        holder.planetTypeTv.setText(mvalues.get(position).getType());
        holder.planetLogolv.setImageResource(mvalues.get(position).getLogo());

        final Planet selectedPlanet = mvalues.get(position);
        final int pos = holder.getAdapterPosition();

        holder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (null != mListener){
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemSelected(selectedPlanet, pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mvalues.size();
    }

    public void add(Planet item){
        mvalues.add(item);
        notifyItemInserted(mvalues.size()-1);
    }
}
