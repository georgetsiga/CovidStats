package com.example.covidstats.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.covidstats.models.StatsResponse;
import com.example.covidstats.repositories.StatsRepository;

public class StatsViewModel extends AndroidViewModel {
    private StatsRepository statsRepository;
    private LiveData<StatsResponse> statsResponseLiveData;

    public StatsViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        statsRepository = new StatsRepository();
        statsResponseLiveData = statsRepository.getStatsResponseLiveData();
    }

    public void searchStatsByCountry(String country){
        statsRepository.searchStatsByCountry(country);
    }

    public void searchStats(){
        statsRepository.searchStats();
    }

    public LiveData<StatsResponse> getStatsResponseLiveData() {
        return statsResponseLiveData;
    }
}
