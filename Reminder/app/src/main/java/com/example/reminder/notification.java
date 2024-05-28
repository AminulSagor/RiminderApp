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


public class notification extends Fragment {

    RecyclerView notification;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_notification, container, false);
        notification=myView.findViewById(R.id.recycleNotification);




        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("Type","1");
        hashMap.put("userName","Aminul");
        hashMap.put("crossedTime","20 minutes");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("Type","2");
        hashMap.put("userName","Sagorika");
        hashMap.put("crossedTime","40 minutes");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Type","3");
        hashMap.put("userName","Aminul");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("Type","4");
        hashMap.put("userName","Sagorika");
        arrayList.add(hashMap);



        notification.notificationAdapter adapter= new notification.notificationAdapter();
        notification.setAdapter(adapter);
        notification.setLayoutManager(new LinearLayoutManager(getActivity()));

        return myView;
    }

    private class notificationAdapter extends RecyclerView.Adapter
    {
        private class maleViewHolder extends RecyclerView.ViewHolder
        {
            TextView maleNotification;
            LinearLayout clickDetailsFail;

            public maleViewHolder(@NonNull View itemView) {
                super(itemView);

                maleNotification=itemView.findViewById(R.id.maleNotification);
                clickDetailsFail=itemView.findViewById(R.id.clickDetailsFail);

            }
        }

        private class femaleViewHolder extends RecyclerView.ViewHolder
        {
            TextView femaleNotification;

            public femaleViewHolder(@NonNull View itemView) {
                super(itemView);

                femaleNotification=itemView.findViewById(R.id.femaleNotification);

            }
        }

        private class addMaleViewHolder extends RecyclerView.ViewHolder
        {
            TextView addMaleNotification;

            public addMaleViewHolder(@NonNull View itemView) {
                super(itemView);

                addMaleNotification = itemView.findViewById(R.id.addMaleNotification);

            }
        }

        private class addFemaleViewHolder extends RecyclerView.ViewHolder
        {
            TextView addFemaleNotification;
            public addFemaleViewHolder(@NonNull View itemView) {
                super(itemView);

                addFemaleNotification=itemView.findViewById(R.id.addFemaleNotification);



            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater= getLayoutInflater();
            if(viewType==1)
            {
                View myView = inflater.inflate(R.layout.notification_fail,parent,false);
                return  new notification.notificationAdapter.maleViewHolder(myView);
            }
            else if (viewType==2)
            {
                View myView = inflater.inflate(R.layout.notification_f_fail,parent,false);
                return  new notification.notificationAdapter.femaleViewHolder(myView);
            }
            else if (viewType==3)
            {
                View myView = inflater.inflate(R.layout.notification_m_add,parent,false);
                return  new notification.notificationAdapter.addMaleViewHolder(myView);
            }
            else
            {
                View myView = inflater.inflate(R.layout.notification_f_add,parent,false);
                return  new notification.notificationAdapter.addFemaleViewHolder(myView);
            }

        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if(getItemViewType(position)==1)
            {
                notification.notificationAdapter.maleViewHolder myHolder= (notification.notificationAdapter.maleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("userName");
                String crossedTime=hashMap.get("crossedTime");


                myHolder.maleNotification.setText(name+" crossed time for "+crossedTime);
                myHolder.maleNotification.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.homeFragment, new detailsPage());
                        fragmentTransaction.addToBackStack(null); // Allowing back navigation
                        fragmentTransaction.commit();
                    }
                });

            }
            else if(getItemViewType(position)==2)
            {
                notification.notificationAdapter.femaleViewHolder myHolder= (notification.notificationAdapter.femaleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("userName");
                String crossedTime=hashMap.get("crossedTime");


                myHolder.femaleNotification.setText(name+" crossed time for "+crossedTime);

            }

            else if(getItemViewType(position)==3)
            {
                notification.notificationAdapter.addMaleViewHolder myHolder= (notification.notificationAdapter.addMaleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("userName");


                myHolder.addMaleNotification.setText(name +" send a partner request");
            }
            else
            {
                notification.notificationAdapter.addFemaleViewHolder myHolder= (notification.notificationAdapter.addFemaleViewHolder) holder;

                hashMap = arrayList.get(position);
                String name = hashMap.get("userName");


                myHolder.addFemaleNotification.setText(name +" send a partner request");
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

            if (type.contains("1") )
            {
                return 1;
            }
            else if (type.contains("2") )
            {
                return 2;
            }
            else if (type.contains("3") )
            {
                return 3;
            }
            else
            {
                return 4;
            }


        }
    }
}