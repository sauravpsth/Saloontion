package com.ocem.Saloontion.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ocem.Saloontion.AvailableSaloon;
import com.ocem.Saloontion.MyAppointments;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.model.CategoryModel;
import com.ocem.Saloontion.model.Datum;
import com.ocem.Saloontion.model.HistoryResponse;
import com.ocem.Saloontion.model.UpComingHistoryModel;

import java.nio.Buffer;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAppointmentAdapter extends RecyclerView.Adapter<MyAppointmentAdapter.ViewHolder> {
    HistoryResponse category;
    Context context;

    public MyAppointmentAdapter(HistoryResponse category, Context context) {
        this.category = category;
        this.context = context;
    }

    public void setBookingList (HistoryResponse category){
        this.category = category;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_upcoming, parent,false);
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(category.getData().get( position ).getSaloonname());
        holder.subName.setText("Type: " + category.getData().get( position ).getServicename());
        holder.date.setText(category.getData().get( position ).getDate());
        holder.time.setText( category.getData().get( position ).getTime() );
        holder.price.setText("Rs. " + category.getData().get( position ).getAmount() );
        Glide.with(context)
                .load("http://saloon.oxfordcollege.edu.np/" + category.getData().get( position ).getImages() )
                .apply( RequestOptions.centerCropTransform() )
                .into( holder.image );


        holder.button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.button.setVisibility( View.INVISIBLE );
                holder.cancel.setVisibility( View.VISIBLE );
          /*      Intent intent = new Intent(context, MyAppointments.class );
                intent.putExtra( "Saloon",category.getData().get( position ).getName() );
                intent.putExtra( "Service", "saloon" );
                intent.putExtra( "Date",category.getData().get( position ).getDate() );
                intent.putExtra( "Time",category.getData().get( position ).getTime());
                intent.putExtra( "Price", category.getData().get( position ).getAmount() );
                context.startActivity( intent );*/
            }
        } );
    }

    @Override
    public int getItemCount(){return category.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name,subName,date,time,price,cancel;
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_contact1);
            subName=itemView.findViewById(R.id.descp1);
            date=itemView.findViewById(R.id.tvDate);
            time=itemView.findViewById(R.id.tvTime);
            price=itemView.findViewById(R.id.tvAmount);
            button = itemView.findViewById( R.id.bt11 );
            cancel = itemView.findViewById( R.id.tvCancel );
            image = itemView.findViewById( R.id.img_contact1 );
        }
    }

}
