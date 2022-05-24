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
import com.ocem.Saloontion.model.CategoryModel;
import com.ocem.Saloontion.model.HomeServiceResponse;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.model.Specialmodel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.ViewHolder> {

    List<HomeServiceResponse> category;
    Context context;

    public SpecialAdapter(List<HomeServiceResponse> category, Context context) {
        this.category = category;
        this.context = context;
    }

    public void setSpecialService(List<HomeServiceResponse> category){
        this.category = category;
        notifyDataSetChanged();
    }



    @Override
    public SpecialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_category, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

            holder.name.setText( category.get( position ).getServicename() );
            Glide.with( context )
                    .load( "http://saloon.oxfordcollege.edu.np/" + category.get( position ).getImages() )
                    .apply( RequestOptions.centerCropTransform() )
                    .into( holder.image );

            holder.image.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( context, AvailableSaloon.class );
                    intent.putExtra( "Title1", category.get( position ).getServicename() );
                    intent.putExtra( "Image1", "http://saloon.oxfordcollege.edu.np/" + category.get( position ).getImages() );
                    intent.putExtra( "Description", category.get( position ).getDetails() );
                    context.startActivity( intent );
                }
            } );


    }


    @Override
    public int getItemCount() {
        return category == null ? 0 :  category.size();
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

