package com.example.thearbiter.pugdundeesafaris;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thearbiter.pugdundeesafaris.Adapters.AdapterForProgramR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aadesh Rana on 16-08-16.
 */
public class FragmentProgram extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View layout = inflater.inflate(R.layout.fragment_program_recycler,container,false);
        RecyclerView recyclerView =(RecyclerView)layout.findViewById(R.id.programRecycler);
        AdapterForProgramR adapterForProgramR = new AdapterForProgramR(getActivity(),getdata());
        recyclerView.setAdapter(adapterForProgramR);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        return  layout;
    }
    public static List<InformationProgram>getdata(){
        List<InformationProgram> data = new ArrayList<>();
        int[] icons={R.drawable.program_photography,
                R.drawable.program_cycling,
                R.drawable.program_flying,
                R.drawable.program_learning,
                R.drawable.program_walking,
                R.drawable.program_biking,
                R.drawable.program_satpura_explorer,
                R.drawable.program_kripling_trail,
                R.drawable.program_base,
                R.drawable.program_tiger,
                R.drawable.program_tiger2,
                R.drawable.program_temple,
                R.drawable.program_fivetiger,
                R.drawable.program_classictiger,
                R.drawable.program_junglebook,
                R.drawable.program_panna,
                R.drawable.program_kahna,
                R.drawable.program_pench,
                R.drawable.program_satpura,
                R.drawable.program_satpura2,
                R.drawable.program_pench_satpura,
                R.drawable.program_pench_kahna
        };
        String titles[]={"Photographer's Special","Walking & Mobile Safari","Cycling Pench, Kanha Corridor","Experiential Learning Programme","Flying Safari","Biking Tours",
                          "Satpura Explorer","Kripling Trail","Best of Central Highlands","Tiger Tiger\n","Wildlife Trail","Temple & Tiger Trails","Five Tiger Reserve Tour",
                          "Classic Tiger Trails\n","The Jungle Book Trails","Panna - Bandhavgarh","Bandhavgarh - Kanha","Bandhavgarh - Pench","Bandhavgarh - Satpura","Kanha - Pench\n",
                           "Kanha - Satpura","Pench - Satpura"};
        String secondText[]={"",
                "",
                "",
                "",
                "",
                "",
                "5 Nights / 6 Days\nWalking & Camping Experience in Satpura",
                "9 Nights / 10 Days\nKanha-Pench-Satpura\n ",
                "9 Nights / 10 Days\nSatpura-Kanha-Bandhavgarh",
                "9 Nights / 10 Days\nBandhavgarh-Kanha-Pench",
                "12 Nights/13 Days\nPanna-Bandhavgarh-Kanha-Pench",
                "5 Nights / 6 Days\nOrchha-Khajuraho-Panna-Bandhavgarh",
                "15 Nights / 16 Days\nPanna-Bandhavgarh-Kanha-Pench-Satpura",
                "7 Nights / 8 Days\nPanna-Bandhavgarh-Kanha",
                "12 Nights / 13 days\nSatpura – Pench – Kanha - Bandhavgarh",
                "\n6 Nights / 7 Days\n",
                "6 Nights / 7 Days",
                "6 Nights / 7 Days",
                "6 Nights / 7 Days",
                "6 Nights / 7 Days",
                "6 Nights / 7 Days",
                "6 Nights / 7 Days",

        };

        for(int i = 0; i<icons.length;i++){
            InformationProgram current = new InformationProgram();
            current.icons=icons[i];
            current.title=titles[i];
            current.subtext=secondText[i];

            data.add(current);
        }
        return data;
    }
}
