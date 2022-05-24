package com.ocem.Saloontion.adapter;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ocem.Saloontion.NotificationDetail;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.model.CategoryModel;
import com.ocem.Saloontion.model.NotificationModel;
import com.ocem.Saloontion.model.SaloonModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationModel> notificationModels;
    private Context mcontext;

    public NotificationAdapter(Context mcontext, List<NotificationModel> notificationModels) {
        this.mcontext = mcontext;
        this.notificationModels = notificationModels;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from( mcontext );
        view = mInflater.inflate( R.layout.item_notification, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {

        holder.textView.setText( notificationModels.get( position ).getTitle() );
        holder.textView1.setText( notificationModels.get( position ).getTime() );
        holder.textView2.setText( notificationModels.get( position ).getDetail() );
        holder.constraintLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcontext.startActivity( new Intent(mcontext, NotificationDetail.class ) );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return notificationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TextView textView1;
        TextView textView2;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            textView = (TextView) itemView.findViewById( R.id.tvti );
            textView1 = (TextView) itemView.findViewById( R.id.tvde );
            textView2 = (TextView) itemView.findViewById( R.id.tvda );
            constraintLayout = itemView.findViewById( R.id.cons );
        }
    }
}