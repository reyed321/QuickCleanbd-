package com.example.quickcleanbd.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickcleanbd.Model.RecommendedModel;
import com.example.quickcleanbd.R;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    private Context context;
    private List<RecommendedModel> itemList;
    private  OnItemClickListener listener;




    public interface OnItemClickListener{
        void onItemClick(int posistion);
    }



    public RecommendedAdapter(Context context, List<RecommendedModel> itemList, OnItemClickListener listener) {
        this.context = context;
        this.itemList = itemList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public RecommendedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.ViewHolder holder, int position) {

        RecommendedModel currentItem = itemList.get(position);

        holder.laundryImage.setImageResource(currentItem.getImageResId());
        holder.laundryName.setText(currentItem.getName());
        holder.orderPrice.setText(currentItem.getPrice());
        holder.laundryLocationIcon.setImageResource(R.drawable.ic_location); // Replace with your default icon resource
        holder.distanceText.setText("Distance");
        holder.distanceCount.setText(currentItem.getDistance());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView laundryImage;
        TextView laundryName;
        TextView orderPrice;
        ImageView laundryLocationIcon;
        TextView distanceText;
        TextView distanceCount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            laundryImage = itemView.findViewById(R.id.laundryImage);
            laundryName = itemView.findViewById(R.id.laundryName);
            orderPrice = itemView.findViewById(R.id.orderPrice);
            laundryLocationIcon = itemView.findViewById(R.id.laundryLocationIcon);
            distanceText = itemView.findViewById(R.id.distanceText);
            distanceCount = itemView.findViewById(R.id.distanceCount);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


}
