package com.midtermmad3125.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.utils.ReadJSONUtils;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainCityActivity extends AppCompatActivity
{
    private TextView name;
    private TextView lat;
    private TextView lon;
    private TextView code;
    private TextView population;
    private Button details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.City);
        lat = findViewById(R.id.Lat);
        lon = findViewById(R.id.Long);
        code = findViewById(R.id.Code);
        population = findViewById(R.id.population);

        getJsonData();


    }
    public void weatherDetailsclick(View v) {
        Intent iIntend = new Intent(MainCityActivity.this, WeatherListActivity.class);
        startActivity(iIntend);
    }
        public void getJsonData()
    {
        String JsonData = ReadJSONUtils.loadJSONFromAsset(this,"moscow_weather.json");

        try {
            JSONObject Data = new JSONObject(JsonData);
            JSONObject cityObject= Data.getJSONObject("city");
            name.setText(cityObject.getString("name"));

            JSONObject cityCoordObject= cityObject.getJSONObject("coord");
            lon.setText("Longitude: "+cityCoordObject.getString("lon"));
            lat.setText("Latitude: "+cityCoordObject.getString("lat"));

            code.setText("Country: "+cityObject.getString("country"));
            population.setText("Population: "+cityObject.getString("population"));

            JSONArray wList = Data.getJSONArray("list");
            for(int y2 = 0; y2 < wList.length(); y2++){
                JSONObject weatherDetail = wList.getJSONObject(y2);
                String weatherdate = weatherDetail.getString("dt");


                String weatherDate = weatherDetail.getString("dt");
                String weatherpressure = weatherDetail.getString("pressure");
                String weatherhumidity = weatherDetail.getString("humidity");
                String weatherspeed = weatherDetail.getString("speed");
                String weatherdeg = weatherDetail.getString("deg");
                String weatherclouds = weatherDetail.getString("clouds");
                String weatherrain = weatherDetail.getString("rain");

//                weatherclassArray.add(new weatherList())
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
}