package com.ocem.Saloontion.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ocem.Saloontion.AvailableSaloon;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.SaloonService;
import com.ocem.Saloontion.model.RecommendedModel;
import com.ocem.Saloontion.model.SaloonListResponse;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.model.Specialmodel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    List<SaloonListResponse> category;
    Context context;

    public RecommendedAdapter(List<SaloonListResponse> category, Context context) {
        this.category = category;
        this.context = context;
    }

    public void setSaloonList(List<SaloonListResponse> category){
        this.category = category;
        notifyDataSetChanged();
    }



    @Override
    public RecommendedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_category, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        Glide.with(context)
                .load("http://saloon.oxfordcollege.edu.np/" + category.get( position ).getImage() )
                .apply( RequestOptions.centerCropTransform() )
                .into( holder.image );
        holder.name.setText(category.get(position).getName());

        holder.image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SaloonService.class );
                intent.putExtra( "Thumbnail","http://saloon.oxfordcollege.edu.np/" + category.get(position).getImage() );
                intent.putExtra( "Title",category.get(position).getName() );
                intent.putExtra( "Address",category.get(position).getAddress() );
                intent.putExtra( "Phone",category.get(position).getPhone() );
                context.startActivity( intent );

            }
        } );

    }


    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image_view);
            name=itemView.findViewById(R.id.name);
        }
    }

}

