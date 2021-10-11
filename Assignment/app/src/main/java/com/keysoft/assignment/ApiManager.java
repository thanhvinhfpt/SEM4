package com.keysoft.assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {

    @GET("v1/hourly/12hour/353412?apikey=UDseOxA8VFrMOGpDnyH6gsH1fpUBhiFT&language=vi-vn&metric=true")
    Call<List<Item>> getData();
}
