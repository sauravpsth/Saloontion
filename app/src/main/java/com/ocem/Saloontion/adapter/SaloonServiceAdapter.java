package com.ocem.Saloontion.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ocem.Saloontion.Booking;
import com.ocem.Saloontion.LoginActivity;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.SaloonService;
import com.ocem.Saloontion.SignUp;
import com.ocem.Saloontion.model.Contact;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import java.util.List;

public class SaloonServiceAdapter extends RecyclerView.Adapter<SaloonServiceAdapter.MyViewHolder> {
    Button button;
    Context mContext;
    List<ServicesResponse> servicesResponses;
    SharedPrefsHelper sharedPrefsHelper;

    public SaloonServiceAdapter(Context mContext, List<ServicesResponse> servicesResponses) {

        this.mContext = mContext;
        this.servicesResponses = servicesResponses;
    }
    public void setSaloonService (List<ServicesResponse> servicesResponses){
        this.servicesResponses = servicesResponses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from( mContext ).inflate( R.layout.item_contact,parent,false );
        sharedPrefsHelper = SharedPrefsHelper.getInstance( v.getContext() );
        MyViewHolder vHolder = new MyViewHolder( v );

        return vHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText( servicesResponses.get( position ).getServiceName());
        holder.tv_phone.setText( "Rs. " + servicesResponses.get( position ).getPrice());
        holder.tvSub.setText( servicesResponses.get( position ).getDetails() );
        Glide.with(mContext)
                .load("http://saloon.oxfordcollege.edu.np/" + servicesResponses.get( position ).getImages() )
                .apply( RequestOptions.centerCropTransform() )
                .into( holder.img );



                holder.button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefsHelper = SharedPrefsHelper.getInstance( mContext );
                sharedPrefsHelper.saveValue( Constant.SERVICE_ID,servicesResponses.get( position ).getServiceId() );
                sharedPrefsHelper.saveValue( Constant.SALOON_ID,servicesResponses.get( position ).getSaloonId() );
                Intent intent = new Intent( mContext, Booking.class );
                mContext.startActivity( intent );

            }
        } );

    }

    @Override
    public int getItemCount() {
        return servicesResponses == null ? 0 :  servicesResponses.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_phone,tvSub;
        ImageView img;
       Button button;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            tv_name = (TextView) itemView.findViewById( R.id.name_contact );
            tv_phone = (TextView) itemView.findViewById( R.id.phone_contact );
            img = (ImageView) itemView.findViewById( R.id.img_contact);
            button = (Button) itemView.findViewById(R.id.bt1);
            tvSub = itemView.findViewById(R.id.descp);


        }
    }

}

