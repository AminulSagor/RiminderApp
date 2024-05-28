package com.example.reminder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;



public class yourActivityDetails extends Fragment {

    RecyclerView FailedActivityByTime;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView= inflater.inflate(R.layout.fragment_your_activity_details, container, false);

        FailedActivityByTime=myView.findViewById(R.id.FailedActivityByTime);


        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("Type","1");
        hashMap.put("failedTime","5");
        hashMap.put("time", "8:12 PM");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Type","1");
        hashMap.put("failedTime","5.6");
        hashMap.put("time", "4:12 PM");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Type","1");
        hashMap.put("failedTime","9");
        hashMap.put("time", "9:12 PM");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Type","1");
        hashMap.put("failedTime","45");
        hashMap.put("time", "8:12 PM");
        arrayList.add(hashMap);



        yourActivityDetails.yourActivityDetailsAdapter adapter= new yourActivityDetails.yourActivityDetailsAdapter();
        FailedActivityByTime.setAdapter(adapter);
        FailedActivityByTime.setLayoutManager(new LinearLayoutManager(getActivity()));
        return myView;
    }


    private class yourActivityDetailsAdapter extends RecyclerView.Adapter
    {
        int position;
        private class maleViewHolder extends RecyclerView.ViewHolder
        {
            TextView yourMaleReport,failedTime;

            public maleViewHolder(@NonNull View itemView) {
                super(itemView);
                yourMaleReport=itemView.findViewById(R.id.yourMaleReport);
                failedTime=itemView.findViewById(R.id.failedTime);



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
                return  new yourActivityDetails.yourActivityDetailsAdapter.maleViewHolder(myView);
            }
            else
            {
                View myView = inflater.inflate(R.layout.fail_report_date_f,parent,false);
                return  new yourActivityDetails.yourActivityDetailsAdapter.femaleViewHolder(myView);
            }

        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if(getItemViewType(position)==1)
            {
                yourActivityDetails.yourActivityDetailsAdapter.maleViewHolder myHolder= (yourActivityDetails.yourActivityDetailsAdapter.maleViewHolder) holder;

                hashMap = arrayList.get(position);

                String failedTime= hashMap.get("failedTime");
                String failedTimeHas= hashMap.get("time");

                myHolder.failedTime.setText(failedTimeHas);


                myHolder.yourMaleReport.setText("You have failed for "+failedTime+" minutes");

            }
            else
            {
                yourActivityDetails.yourActivityDetailsAdapter.femaleViewHolder myHolder= (yourActivityDetails.yourActivityDetailsAdapter.femaleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("NumberOfTimes");


                myHolder.yourFemaleReport.setText("You have failed for "+name+" Times");

            }

        }

        @Override
        public int getItemCount()
        {
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