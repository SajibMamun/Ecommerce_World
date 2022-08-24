package com.sajibmamun.ecommeraceapp.Apdater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sajibmamun.ecommeraceapp.R;

import java.util.List;

public class MRVadapter extends RecyclerView.Adapter<MRVadapter.viewHolder> {


    List<ModelItem> productlist;
    Context context;

    public MRVadapter(List<ModelItem> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mainitemdesign,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Glide.with(context).load(productlist.get(position).image).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ImageViewid);
        }
    }
}
