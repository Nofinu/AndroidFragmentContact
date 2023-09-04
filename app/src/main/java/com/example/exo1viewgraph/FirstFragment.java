package com.example.exo1viewgraph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.exo1viewgraph.adapter.PersonnAdapter;
import com.example.exo1viewgraph.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PersonnAdapter personnAdapter = new PersonnAdapter(new PersonnAdapter.PersonDiff(),FirstFragment.this);
        binding.personRecyclerview.setAdapter(personnAdapter);
        binding.personRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        personnAdapter.submitList(PersonService.personList);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}