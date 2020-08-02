package com.example.covidstats.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.covidstats.apis.APIClient;
import com.example.covidstats.apis.CovidStatsSearchService;
import com.example.covidstats.models.StatsResponse;

public class StatsRepository {

    private CovidStatsSearchService covidStatsSearchService;
    private MutableLiveData<StatsResponse> statsResponseLiveData;

    public StatsRepository(){
        statsResponseLiveData = new MutableLiveData<>();
        covidStatsSearchService = APIClient.getClient().create(CovidStatsSearchService.class);
    }

    public void searchStatsByCountry(String country){
        covidStatsSearchService.searchStatsByCountry(country)
                .enqueue(new Callback<StatsResponse>() {
                    @Override
                    public void onResponse(Call<StatsResponse> call, Response<StatsResponse> response) {
                        if(response.body()!= null){
                            statsResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<StatsResponse> call, Throwable t) {

                        statsResponseLiveData.postValue(null);
                    }
                });
    }

    public void searchStats(){
        covidStatsSearchService.searchStats()
                .enqueue(new Callback<StatsResponse>() {
                    @Override
                    public void onResponse(Call<StatsResponse> call, Response<StatsResponse> response) {
                        if(response.body()!= null){
                            statsResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<StatsResponse> call, Throwable t) {

                        statsResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<StatsResponse> getStatsResponseLiveData(){
        return statsResponseLiveData;
    }
}
