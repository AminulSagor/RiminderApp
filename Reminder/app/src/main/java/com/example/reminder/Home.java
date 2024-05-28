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


public class Home extends Fragment {

    RecyclerView addPartner;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        View myView=inflater.inflate(R.layout.fragment_home, container, false);

        addPartner=myView.findViewById(R.id.addPartner);

        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("Type","1");
        hashMap.put("userName","Aminul");
        hashMap.put("ReminderTime","20 minutes");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("Type","2");
        hashMap.put("userName","Sagorika");
        hashMap.put("ReminderTime","20 minutes");
        arrayList.add(hashMap);



        Home.homeAdapter adapter= new Home.homeAdapter();
        addPartner.setAdapter(adapter);
        addPartner.setLayoutManager(new LinearLayoutManager(getActivity()));
        return myView;
    }

    private class homeAdapter extends RecyclerView.Adapter
    {
        private class maleViewHolder extends RecyclerView.ViewHolder
        {
            TextView name,reminderTime;

            public maleViewHolder(@NonNull View itemView) {
                super(itemView);
                name=itemView.findViewById(R.id.Name);
                reminderTime=itemView.findViewById(R.id.reminderTime);


            }
        }

        private class femaleViewHolder extends RecyclerView.ViewHolder
        {
            TextView name,reminderTime;

            public femaleViewHolder(@NonNull View itemView) {
                super(itemView);

                name=itemView.findViewById(R.id.fName);
                reminderTime=itemView.findViewById(R.id.freminderTime);

            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater= getLayoutInflater();
            if(viewType==1)
            {
                View myView = inflater.inflate(R.layout.accountable_partner,parent,false);
                return  new Home.homeAdapter.maleViewHolder(myView);
            }
            else
            {
                View myView = inflater.inflate(R.layout.accountable_fpartner,parent,false);
                return  new Home.homeAdapter.femaleViewHolder(myView);
            }

        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if(getItemViewType(position)==1)
            {
                Home.homeAdapter.maleViewHolder myHolder= (Home.homeAdapter.maleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("userName");
                String reminderTime = hashMap.get("ReminderTime");

                myHolder.name.setText(name);
                myHolder.reminderTime.setText(reminderTime);
            }
            else
            {
                Home.homeAdapter.femaleViewHolder myHolder= (Home.homeAdapter.femaleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("userName");
                String reminderTime = hashMap.get("ReminderTime");

                myHolder.name.setText(name);
                myHolder.reminderTime.setText(reminderTime);
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