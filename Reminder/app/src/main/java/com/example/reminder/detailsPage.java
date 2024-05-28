package com.example.reminder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class detailsPage extends Fragment {

    RecyclerView FailedActivityByDatePerson;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView=inflater.inflate(R.layout.fragment_details_page, container, false);

        FailedActivityByDatePerson=myView.findViewById(R.id.FailedActivityByDatePerson);

        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("Type","1");
        hashMap.put("NumberOfTimes","5");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("Type","2");
        hashMap.put("NumberOfTimes","7");
        arrayList.add(hashMap);





        detailsPage.detailsPageAdapter adapter= new detailsPage.detailsPageAdapter();
        FailedActivityByDatePerson.setAdapter(adapter);
        FailedActivityByDatePerson.setLayoutManager(new LinearLayoutManager(getActivity()));


        return myView;

    }

    private class detailsPageAdapter extends RecyclerView.Adapter
    {
        private class maleViewHolder extends RecyclerView.ViewHolder
        {
            TextView yourMaleReport;
            LinearLayout clickDetailsFail;

            public maleViewHolder(@NonNull View itemView) {
                super(itemView);
                yourMaleReport=itemView.findViewById(R.id.yourMaleReport);
                clickDetailsFail=itemView.findViewById(R.id.clickDetailsFail);



            }
        }

        private class femaleViewHolder extends RecyclerView.ViewHolder
        {
            TextView yourFemaleReport;

            public femaleViewHolder(@NonNull View itemView) {
                super(itemView);

                yourFemaleReport=itemView.findViewById(R.id.yourFemaleReport);


            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater= getLayoutInflater();
            if(viewType==1)
            {
                View myView = inflater.inflate(R.layout.fail_report_date,parent,false);
                return  new detailsPage.detailsPageAdapter.maleViewHolder(myView);
            }
            else
            {
                View myView = inflater.inflate(R.layout.fail_report_date_f,parent,false);
                return  new detailsPage.detailsPageAdapter.femaleViewHolder(myView);
            }

        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if(getItemViewType(position)==1)
            {
                detailsPage.detailsPageAdapter.maleViewHolder myHolder= (detailsPage.detailsPageAdapter.maleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("NumberOfTimes");


                myHolder.yourMaleReport.setText("Sagor has failed for "+name+" Times");

                myHolder.clickDetailsFail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.homeFragment, new yourActivityDetails());
                        fragmentTransaction.addToBackStack(null); // Allowing back navigation
                        fragmentTransaction.commit();

                    }
                });



            }
            else
            {
                detailsPage.detailsPageAdapter.femaleViewHolder myHolder= (detailsPage.detailsPageAdapter.femaleViewHolder) holder;


                hashMap = arrayList.get(position);
                String name = hashMap.get("NumberOfTimes");


                myHolder.yourFemaleReport.setText("You have failed for "+name+" Times");


            }

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        @Override
        public int getItemViewType(int position) {

            hashMap =arrayList.get(position);
            String type = hashMap.get("Type");

            if (type.contains("1") ) return 1;
            else return 0;
        }
    }
}