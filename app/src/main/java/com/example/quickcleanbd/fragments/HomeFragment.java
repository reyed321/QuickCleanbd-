package com.example.quickcleanbd.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SearchView;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.quickcleanbd.Model.RecommendedModel;
import com.example.quickcleanbd.R;
import com.example.quickcleanbd.activity.Ironing;
import com.example.quickcleanbd.activity.Laundray;
import com.example.quickcleanbd.activity.Search;
import com.example.quickcleanbd.adapter.RecommendedAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Ironing ironing;

     private SearchView searchView;
    ImageView image_1;

    private RecyclerView recyclerView;
    private RecommendedAdapter recommendedAdapter;
    private List<RecommendedModel> itemList;



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = view.findViewById(R.id.recyclerview_recommended);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

       itemList = new ArrayList<>();

       itemList.add(new RecommendedModel(R.drawable.img,"Papa Laundry","$30-$40","1 Km"));
       itemList.add(new RecommendedModel(R.drawable.img_1,"Papa Laundry","$30-$40","1.3 Km"));
       itemList.add(new RecommendedModel(R.drawable.img_2,"Papa Laundry","$30-$40","1.2 Km"));
       itemList.add(new RecommendedModel(R.drawable.img_3,"Papa Laundry","$30-$40","1.4 Km"));
       itemList.add(new RecommendedModel(R.drawable.img_4,"Papa Laundry","$30-$40","1.5 Km"));

       
        recommendedAdapter = new RecommendedAdapter(getContext(), itemList, new RecommendedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int posistion) {
                Intent intent = new Intent(getContext(), Laundray.class);
                startActivity(intent);
            }

        });

        recyclerView.setAdapter(recommendedAdapter);

        ImageView imag1 = view.findViewById(R.id.image_1);

        imag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getContext(), Ironing.class);
                startActivity(intent);
            }
        });


        ConstraintLayout search = view.findViewById(R.id.searchArea);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Search.class); // Use requireContext()

                startActivity(intent);
            }
        });




        return view;
    }

}