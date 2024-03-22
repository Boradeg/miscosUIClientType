package com.example.miscosuiclienttype;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.miscosuiclienttype.databinding.FragmentListBinding;

import java.util.ArrayList;
import java.util.List;

public class AttributeFragment extends Fragment {
    private AttributeAdapter attributeAdapter;

    private List<AttributeModalClass> attributeList;
    private FragmentListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize attributeList
        attributeList = new ArrayList<>();

        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false);

        binding.idCreateNewProjectType.setText("Create New Project Type");
        binding.idCreateNewProjectType.setPaintFlags(binding.idCreateNewProjectType.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.idAddNewAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate ID for the new attribute
                int newId = attributeList.size() + 1;
                // Add a new item to the RecyclerView with the ID and attribute name
                attributeList.add(new AttributeModalClass(newId, newId + ". Necessary Attribute"));
                attributeAdapter.notifyDataSetChanged();
            }
        });
        binding.dropDownForClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ClientTypeFragment());

            }
        });

        binding.idCreateNewProjectType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an instance of the new fragment
                ProjectTypeFragment projectTypeFragment = new ProjectTypeFragment();
                replaceFragment(projectTypeFragment);


            }
        });

        attributeList.add(new AttributeModalClass(1, 1 + ". Necessary Attribute"));
        // Initialize attributeAdapter using the field variable
        attributeAdapter = new AttributeAdapter(attributeList);
        binding.recyclerViewForAttribute.setAdapter(attributeAdapter);
        binding.recyclerViewForAttribute.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }
    public void replaceFragment(Fragment fragment) {
        // Get the FragmentManager
        FragmentManager fragmentManager = getParentFragmentManager();

        // Begin a FragmentTransaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the new one
        transaction.replace(R.id.fragment_container, fragment);


        // Commit the transaction
        transaction.commit();
    }
    public void test() {
        Toast.makeText(requireContext(), "vcx", Toast.LENGTH_SHORT).show();
    }

}
