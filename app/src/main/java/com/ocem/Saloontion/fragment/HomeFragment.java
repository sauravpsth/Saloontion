package com.ocem.Saloontion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.ocem.Saloontion.SaloonService;
import com.ocem.Saloontion.adapter.RecommendedAdapter;
import com.ocem.Saloontion.adapter.SpecialAdapter;
import com.ocem.Saloontion.model.CategoryModel;
import com.ocem.Saloontion.model.HomeServiceResponse;
import com.ocem.Saloontion.model.MenuModel;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.adapter.categoryAdapter;
import com.ocem.Saloontion.model.RecommendedModel;
import com.ocem.Saloontion.model.SaloonListResponse;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.model.Specialmodel;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    List<SaloonListResponse> recommendedModelList;
    List<HomeServiceResponse> specialmodelList;
    List<HomeServiceResponse> categoryModelList;
    categoryAdapter adapter;
    RecommendedAdapter adapter3;

    View view;
    SpecialAdapter adapter2;
    RecyclerView rcv,rcv1,rcv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_home, container, false );

        ImageSlider imageSlider = view.findViewById( R.id.slider );
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add( new SlideModel( R.drawable.slide1) );
        slideModels.add( new SlideModel( R.drawable.slide2 ) );
        slideModels.add( new SlideModel( R.drawable.slide3 ) );
        slideModels.add( new SlideModel( R.drawable.slide4 ) );

        imageSlider.setImageList( slideModels, true );


        rcv = view.findViewById( R.id.rcvCategory );
        rcv1 = view.findViewById( R.id.rcvSeller );
        rcv2 = view.findViewById( R.id.rvc3 );
        adapter = new categoryAdapter( categoryModelList, getContext() );
        adapter2 = new SpecialAdapter( specialmodelList, getContext() );
        adapter3 = new RecommendedAdapter( recommendedModelList, getContext() );
        saloonPopular();

        saloonService();
        saloonList();
        return view;


    }




    private void saloonService() {
        Services apiService = ApiUtils.getServices();
        apiService.getSaloonListService().enqueue( new Callback<List<HomeServiceResponse>>() {
            @Override
            public void onResponse(Call<List<HomeServiceResponse>> call, Response<List<HomeServiceResponse>> response) {
                if(response.isSuccessful()){
                    categoryModelList = response.body();
                    LinearLayoutManager layoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );
                    adapter.getPopularService( categoryModelList);
                    rcv.setLayoutManager( layoutManager );
                    rcv.setAdapter( adapter );
                }
            }

            @Override
            public void onFailure(Call<List<HomeServiceResponse>> call, Throwable t) {
                Toast.makeText(getActivity(),"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }



    private void saloonPopular() {
        Services apiService = ApiUtils.getServices();
        apiService.getSaloonListService().enqueue( new Callback<List<HomeServiceResponse>>() {
            @Override
            public void onResponse(Call<List<HomeServiceResponse>> call, Response<List<HomeServiceResponse>> response) {
                if(response.isSuccessful()){
                    specialmodelList = response.body();
                    LinearLayoutManager layoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );
                    adapter2.setSpecialService( specialmodelList);
                    rcv1.setLayoutManager( layoutManager );
                    rcv1.setAdapter( adapter2 );
                }
            }

            @Override
            public void onFailure(Call<List<HomeServiceResponse>> call, Throwable t) {
                Toast.makeText(getActivity(),"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }

    private void saloonList() {
        Services apiService = ApiUtils.getServices();
        apiService.getSaloonList().enqueue( new Callback<List<SaloonListResponse>>() {
            @Override
            public void onResponse(Call<List<SaloonListResponse>> call, Response<List<SaloonListResponse>> response) {
                if(response.isSuccessful()){
                    recommendedModelList = response.body();
                    adapter3.setSaloonList( recommendedModelList);
                    LinearLayoutManager layoutManager1 = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );
                    rcv2.setLayoutManager( layoutManager1 );
                    rcv2.setAdapter( adapter3 );
                }
            }

            @Override
            public void onFailure(Call<List<SaloonListResponse>> call, Throwable t) {
                Toast.makeText(getActivity(),"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }




}
