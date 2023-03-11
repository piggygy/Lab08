package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return 0;
    }
    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }
    /**
     * This returns true if city in list, false if not in
     * @param city
     * check if city in list
     * @return
     * Return the boolean value
     */
    public boolean hasCity(City city){
        for (City c : cities){
            if (c.getCityName()==city.getCityName()){
                return true;
            }
        }
        return false;
    }

    /**
     * This returns nothing delete a city if exist
     * @param city
     * This is a city to delete
     */
    public void delete(City city){
        if (hasCity(city)){
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException("City not in list");
        }
    }

}
