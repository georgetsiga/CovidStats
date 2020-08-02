package com.example.covidstats;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.covidstats.adapters.StatsResultsAdapter;
import com.example.covidstats.models.StatsResponse;
import com.example.covidstats.viewmodels.StatsViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class StatsSearchFragment extends Fragment {
    private StatsViewModel viewModel;
    private StatsResultsAdapter adapter;

    private TextInputEditText searchEditText;
    private Button btnSearch;

    public StatsSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new StatsResultsAdapter();

        viewModel = new ViewModelProvider(this).get(StatsViewModel.class);
        viewModel.init();
        viewModel.getStatsResponseLiveData().observe(this, new Observer<StatsResponse>() {
            @Override
            public void onChanged(StatsResponse statsResponse) {
                if(statsResponse !=null){
                    adapter.setResults(statsResponse.getStatistics());
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats_search, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        searchEditText = view.findViewById(R.id.fragment_country_search);
        btnSearch = view.findViewById(R.id.fragment_btn_search);

        btnSearch.setOnClickListener(view1 -> searchCountryStats());

        searchCountryStats();
        // Inflate the layout for this fragment
        return view;
    }

    private void searchCountryStats() {
        if (TextUtils.isEmpty(searchEditText.getEditableText().toString().trim())) {
            viewModel.searchStats();
        } else {
            viewModel.searchStatsByCountry(searchEditText.getEditableText().toString().trim());
        }
    }
}