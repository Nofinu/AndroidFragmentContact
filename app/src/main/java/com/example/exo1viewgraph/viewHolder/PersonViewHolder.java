package com.example.exo1viewgraph.viewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.exo1viewgraph.FirstFragment;
import com.example.exo1viewgraph.FirstFragmentDirections;
import com.example.exo1viewgraph.R;
import com.example.exo1viewgraph.entity.Person;
import org.jetbrains.annotations.NotNull;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    private Fragment fragment;
    private TextView firstnameTextView;
    private Button buttonDetails;

    public PersonViewHolder(@NonNull @NotNull View itemView,Fragment fragment) {
        this(itemView);
        this.fragment = fragment;
        this.firstnameTextView = itemView.findViewById(R.id.textPersonItem);
        this.buttonDetails = itemView.findViewById(R.id.buttonDetail);
    }

    public PersonViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
    }

    public void display (Person person){
        firstnameTextView.setText(person.getFirstname()+" "+person.getLastname());

        buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = com.example.exo1viewgraph.FirstFragmentDirections.actionFirstFragmentToPersonFragment().setFirstname(person.getFirstname()).setLastname(person.getLastname()).setEmail(person.getEmail());
                NavHostFragment.findNavController(fragment)
                        .navigate(action);
            }
        });
    }

    public static PersonViewHolder create(ViewGroup parent, Fragment fragment) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(view, fragment);
    }
}
