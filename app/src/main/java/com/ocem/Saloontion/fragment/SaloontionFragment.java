package com.ocem.Saloontion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.SaloonService;
import com.ocem.Saloontion.adapter.SaloonAdapter;
import com.ocem.Saloontion.model.SaloonModel;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaloontionFragment extends Fragment {

    List<ServicesResponse> servicesResponses;
    View view;
    RecyclerView myrecylerview;
    SaloonAdapter saloonAdapter;
    SharedPrefsHelper sharedPrefsHelper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_saloontion,container,false );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( getContext() );
        ImageSlider imageSlider = view.findViewById( R.id.imgslider );
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add( new SlideModel( R.drawable.discount1) );
        slideModels.add( new SlideModel( R.drawable.discount2 ) );

        imageSlider.setImageList( slideModels, true );

        myrecylerview = (RecyclerView) view.findViewById( R.id.recyle6 );
        saloonAdapter = new SaloonAdapter(getContext(),servicesResponses);
        saloonName();
        return view;

    }
    private void saloonName() {
        Services apiService = ApiUtils.getServices();
        apiService.getSaloonService().enqueue( new Callback<List<ServicesResponse>>() {
            @Override
            public void onResponse(Call<List<ServicesResponse>> call, Response<List<ServicesResponse>> response) {
                if(response.isSuccessful()){
                    servicesResponses = response.body();
                    saloonAdapter.setSaloonName( servicesResponses );
                    myrecylerview.setLayoutManager(new GridLayoutManager( getActivity(),3,GridLayoutManager.VERTICAL,false)  );
                    myrecylerview.setAdapter( saloonAdapter );
                }
            }

            @Override
            public void onFailure(Call<List<ServicesResponse>> call, Throwable t) {
                Toast.makeText(getActivity(),"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }
}
