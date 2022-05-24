package com.ocem.Saloontion.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.SaloonService;
import com.ocem.Saloontion.model.SaloonModel;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import java.util.List;

public class SaloonAdapter extends RecyclerView.Adapter<SaloonAdapter.MyViewHolder>{

    private Context mcontext;
    private List<ServicesResponse> mData;
    SharedPrefsHelper sharedPrefsHelper;

    public SaloonAdapter(Context mcontext, List<ServicesResponse> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }
    public void setSaloonName (List<ServicesResponse> mData){
        this.mData = mData;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from( mcontext );
        view = mInflater.inflate( R.layout.cardview_salons, parent, false );
      sharedPrefsHelper = SharedPrefsHelper.getInstance( view.getContext() );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView4.setText( mData.get( position ).getName() );
        Glide.with(mcontext)
                .load("http://saloon.oxfordcollege.edu.np/" + mData.get( position ).getImage() )
                .apply( RequestOptions.centerCropTransform() )
                .into( holder.imageView4 );

        holder.cardView.setOnClickListener( new View.OnClickListener() {
            @Override
           public void onClick(View view) {

                sharedPrefsHelper.saveValue( Constant.PHONE,mData.get( position ).getPhone() );
                Intent intent = new Intent(mcontext, SaloonService.class );
                intent.putExtra( "Title",mData.get(position).getName());
                intent.putExtra( "Address",mData.get(position).getAddress() );
                intent.putExtra( "Phone",mData.get(position).getPhone() );
                intent.putExtra("Thumbnail", "http://saloon.oxfordcollege.edu.np/" + mData.get( position ).getImage() );
                mcontext.startActivity( intent );

            }
        } );

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView4;
        ImageView imageView4;
        CardView cardView;
        Bitmap bitmap;
        Intent intent;


        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            textView4 = (TextView) itemView.findViewById( R.id.tvtitle );
            imageView4 = (ImageView) itemView.findViewById( R.id.img );
           cardView = (CardView) itemView.findViewById( R.id.cardview_id );


        }
    }
}
