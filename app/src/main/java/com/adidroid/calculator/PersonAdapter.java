package com.adidroid.calculator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    List<Person> persons;

    public PersonAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder holder, int position) {
        holder.name.setText(persons.get(position).getName());
        holder.bday.setText(persons.get(position).getBday());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView bday;

        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            bday = itemView.findViewById(R.id.bday);
        }
    }
}
