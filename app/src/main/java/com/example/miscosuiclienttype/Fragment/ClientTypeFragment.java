package com.example.miscosuiclienttype.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miscosuiclienttype.ModalDataClass.DataClassExpandedRV;
import com.example.miscosuiclienttype.AdapterClass.ItemAdapterExpandedRV;
import com.example.miscosuiclienttype.R;
import com.example.miscosuiclienttype.databinding.FragmentClientTypeBinding;

import java.util.ArrayList;
import java.util.List;


public class ClientTypeFragment extends Fragment {


    private List<DataClassExpandedRV> mList;
    private ItemAdapterExpandedRV adapter;
    private FragmentClientTypeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentClientTypeBinding.inflate(inflater, container, false);

        binding.mainRecyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));

        mList = new ArrayList<>();

        //list1
        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("Pune-Satara Road Widening");
        nestedList1.add("Nipani-Chikodi Road Widening");
        nestedList1.add("Daund - Bhigwan Line Survey");
        nestedList1.add("Chyawanprash and Health Foods");


        List<String> nestedList2 = new ArrayList<>();
        nestedList2.add("Book");
        nestedList2.add("Pen");
        nestedList2.add("Office Chair");
        nestedList2.add("Pencil");
        nestedList2.add("Eraser");
        nestedList2.add("NoteBook");
        nestedList2.add("Map");
        nestedList2.add("Office Table");

        List<String> nestedList3 = new ArrayList<>();
        nestedList3.add("Decorates");
        nestedList3.add("Tea Table");
        nestedList3.add("Wall Paint");
        nestedList3.add("Furniture");
        nestedList3.add("Bedsits");
        nestedList3.add("Certain");
        nestedList3.add("Namkeen and Snacks");
        nestedList3.add("Honey and Spreads");

        List<String> items = new ArrayList<>();
        items.add("State Public Works Department(SPWD)");
        items.add("Drone Survey");
        items.add("MMRDA Daund");

        mList.add(new DataClassExpandedRV(nestedList1 , items.get(0)));
        mList.add(new DataClassExpandedRV( nestedList2, items.get(1)));
        mList.add(new DataClassExpandedRV( nestedList3, items.get(2)));

        adapter = new ItemAdapterExpandedRV(mList);
        binding.mainRecyclerview.setAdapter(adapter);
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
}