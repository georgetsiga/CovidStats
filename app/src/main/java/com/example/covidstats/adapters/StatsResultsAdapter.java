package com.example.covidstats.adapters;

import android.view.LayoutInflater;
//import android.view.View;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidstats.R;
import com.example.covidstats.models.Statistics;

import java.util.ArrayList;
import java.util.List;

public class StatsResultsAdapter  extends RecyclerView.Adapter<StatsResultsAdapter.StatsResultsHolder> {

    private List<Statistics> results = new ArrayList<>();

    @NonNull
    @Override
    public StatsResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_list_item, parent, false);
        return new StatsResultsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsResultsHolder holder, int position) {
        Statistics statistics = results.get(position);

        holder.country.setText(statistics.getCountry());
        holder.date.setText(statistics.getDay());
        holder.newCases.setText(holder.itemView.getContext().getString(R.string.new_case, statistics.getCases().getNew()));
        holder.totalDeaths.setText(holder.itemView.getContext().getString(R.string.total_deaths, statistics.getDeaths().getTotal()));
        holder.totalCases.setText(holder.itemView.getContext().getString(R.string.total_cases, statistics.getCases().getTotal()));
    }

    @Override
    public int getItemCount() {
        return results != null ? results.size(): 0;
    }

    public void setResults(List<Statistics> results){
        this.results = results;
        notifyDataSetChanged();
    }

    public class StatsResultsHolder extends RecyclerView.ViewHolder {
        private TextView country;
        private TextView date;
        private TextView newCases;
        private TextView totalDeaths;
        private TextView totalCases;

        public StatsResultsHolder(View itemView) {
            super(itemView);

            country = itemView.findViewById(R.id.tv_country);
            date = itemView.findViewById(R.id.tv_date);
            newCases = itemView.findViewById(R.id.tv_new_cases);
            totalDeaths = itemView.findViewById(R.id.tv_total_deaths);
            totalCases = itemView.findViewById(R.id.tv_total_cases);
        }
    }


}
