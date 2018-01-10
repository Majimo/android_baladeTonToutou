package com.pierrefervel.android.baladetontoutou;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean isInfoWindowShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Montreuil Le Gast and move the camera
        LatLng NukeMontreuil = new LatLng(48.246294, -1.726943);
        LatLng ManiMontreuil = new LatLng(48.246939, -1.725649);
        LatLng HorkaLaViennais = new LatLng(48.182052, -0.966724);
        mMap.addMarker(new MarkerOptions().position(NukeMontreuil).title("Nuke / Morgane & Pierre"));
        mMap.addMarker(new MarkerOptions().position(ManiMontreuil).title("Mani / Jacques"));
        mMap.addMarker(new MarkerOptions().position(HorkaLaViennais).title("Horka / Marine & Guillaume"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(NukeMontreuil));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(NukeMontreuil, 12));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
               if (!isInfoWindowShown) {
                   marker.showInfoWindow();
                   isInfoWindowShown = true;
               } else {
                   marker.hideInfoWindow();
                   isInfoWindowShown = false;
               }
               return true;
            }
        });


    }
}
