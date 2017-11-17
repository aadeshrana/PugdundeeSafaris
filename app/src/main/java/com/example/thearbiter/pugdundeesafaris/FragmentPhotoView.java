package com.example.thearbiter.pugdundeesafaris;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thearbiter.pugdundeesafaris.Adapters.AdapterForPhotoViewR;
import com.example.thearbiter.pugdundeesafaris.Adapters.SectionedGridRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aadesh Rana on 16-08-16.
 */
public class FragmentPhotoView extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_program_recycler,container,false);
        RecyclerView recyclerView =(RecyclerView)layout.findViewById(R.id.programRecycler);
        AdapterForPhotoViewR adapterForProgramR = new AdapterForPhotoViewR(getActivity(),getdata());
        recyclerView.setAdapter(adapterForProgramR);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<SectionedGridRecyclerViewAdapter.Section> sections =
                new ArrayList<SectionedGridRecyclerViewAdapter.Section>();
        sections.add(new SectionedGridRecyclerViewAdapter.Section(0,"Barahi"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(5, "Kenriver"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(10, "KingsLodge"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(14, "Pench"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(19, "TreeHouse"));

        SectionedGridRecyclerViewAdapter.Section[] dummy = new SectionedGridRecyclerViewAdapter.Section[sections.size()];
        SectionedGridRecyclerViewAdapter mSectionedAdapter = new
                SectionedGridRecyclerViewAdapter(getActivity(),R.layout.section,R.id.section_text,recyclerView,adapterForProgramR);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        recyclerView.setAdapter(mSectionedAdapter);

        return  layout;
    }
    public static List<InformationRecycler> getdata(){
        List<InformationRecycler> data = new ArrayList<>();
        int[] icons={R.drawable.barahi,
                R.drawable.barahi1,
                R.drawable.barahi2,
                R.drawable.barahi3,
                R.drawable.barahi4,

                R.drawable.kenriver,
                R.drawable.kenriver1,
                R.drawable.kenriver2,
                R.drawable.kenriver3,
                R.drawable.kenriver4,

                R.drawable.kingslodge,
                R.drawable.kingslodge1,
                R.drawable.kingslodge2,
                R.drawable.kingslodge3,

                R.drawable.pench1,
                R.drawable.pench2,
                R.drawable.pench3,
                R.drawable.pench4,
                R.drawable.pench5,

                R.drawable.treehouse1,
                R.drawable.treehouse2,
                R.drawable.treehouse3,
                R.drawable.treehouse4,
                R.drawable.treehouse5


        };


        for(int i = 0; i<icons.length;i++){
            InformationRecycler current = new InformationRecycler();
            current.imageIcon=icons[i];


            data.add(current);
        }
        return data;
    }
}
