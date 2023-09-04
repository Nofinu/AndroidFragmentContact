package com.example.exo1viewgraph.adapter;

import android.view.FrameMetrics;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.exo1viewgraph.entity.Person;
import com.example.exo1viewgraph.viewHolder.PersonViewHolder;
import org.jetbrains.annotations.NotNull;

public class PersonnAdapter extends ListAdapter<Person, PersonViewHolder> {

    private Fragment fragment;

    public PersonnAdapter(@NonNull @NotNull DiffUtil.ItemCallback<Person> diffCallback, Fragment fragment) {
        super(diffCallback);
        this.fragment = fragment;
    }

    @NonNull
    @NotNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return PersonViewHolder.create(parent,fragment);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PersonViewHolder holder, int position) {
        Person person = getItem(position);
        holder.display(person);
    }

    public static class PersonDiff extends DiffUtil.ItemCallback<Person> {
        @Override
        public boolean areItemsTheSame(@NonNull @NotNull Person oldItem, @NonNull @NotNull Person newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull Person oldItem, @NonNull @NotNull Person newItem) {
            return oldItem.equals(newItem);
        }
    }
}
