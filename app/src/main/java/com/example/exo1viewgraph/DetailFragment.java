package com.example.exo1viewgraph;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.exo1viewgraph.databinding.FragmentDetailBinding;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = FragmentDetailBinding.inflate(inflater, container, false);
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable  Bundle savedInstanceState) {

        if (getArguments() != null) {
            DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
            binding.firstnameContent.setText(args.getFirstname());
            binding.lastnameContent.setText(args.getLastname());
            binding.emailContent.setText(args.getEmail());
        }
    }
}