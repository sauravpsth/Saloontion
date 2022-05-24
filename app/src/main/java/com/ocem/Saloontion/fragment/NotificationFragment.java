package com.ocem.Saloontion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ocem.Saloontion.R;
import com.ocem.Saloontion.adapter.NotificationAdapter;
import com.ocem.Saloontion.adapter.SaloonAdapter;
import com.ocem.Saloontion.model.NotificationModel;
import com.ocem.Saloontion.model.SaloonModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    List<NotificationModel> notificationModels;
    View view;
    RecyclerView myrecylerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_notification, container, false );
        
        myrecylerview = (RecyclerView) view.findViewById( R.id.recyle9 );
        NotificationAdapter notificationAdapter = new NotificationAdapter( getContext(), notificationModels );
        myrecylerview.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );
        myrecylerview.setAdapter( notificationAdapter );

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        notificationModels = new ArrayList<>();
        notificationModels.add( new NotificationModel( "Appointment Status Changed","11/03/2021    |       1:21 PM","Your appointment have been delayed for....") );
        notificationModels.add( new NotificationModel( "Appointment Status Changed","11/03/2021    |       1:21 PM","Your appointment have been delayed for....") );
        notificationModels.add( new NotificationModel( "Appointment Status Changed","11/03/2021    |       1:21 PM","Your appointment have been delayed for....") );
        notificationModels.add( new NotificationModel( "Appointment Status Changed","11/03/2021    |       1:21 PM","Your appointment have been delayed for....") );
        notificationModels.add( new NotificationModel( "Appointment Status Changed","11/03/2021    |       1:21 PM","Your appointment have been delayed for....") );
    }
}
