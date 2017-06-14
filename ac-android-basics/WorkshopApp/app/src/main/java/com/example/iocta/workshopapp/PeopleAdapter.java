package com.example.iocta.workshopapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {

    private List<People> peopleList;

    public PeopleAdapter(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.people_row, parent, false);
        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        People people = peopleList.get(position);
        holder.peopleName.setText(people.getName());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    static class PeopleViewHolder extends RecyclerView.ViewHolder {

        TextView peopleName;

        PeopleViewHolder(View itemView) {
            super(itemView);

            peopleName = (TextView) itemView.findViewById(R.id.name_value);
        }
    }
}
