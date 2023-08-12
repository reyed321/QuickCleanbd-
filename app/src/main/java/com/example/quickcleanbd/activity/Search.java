package com.example.quickcleanbd.activity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;

import com.example.quickcleanbd.R;
import com.example.quickcleanbd.databinding.ActivitySearchBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class Search extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

   private SearchView searchView;
    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.SearchView);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

     searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            String location = searchView.getQuery().toString();

            List<Address> addressList = null;

            if (location != null || location.equals("")) {

                Geocoder geocoder = new Geocoder(Search.this);
                try {

                    addressList = geocoder.getFromLocationName(location, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
            }
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s ){
            return false;
        }
    });
        mapFragment.getMapAsync(Search.this);

}

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }
}