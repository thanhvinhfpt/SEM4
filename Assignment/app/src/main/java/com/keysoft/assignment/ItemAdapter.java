package com.keysoft.assignment;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Item> listItem;

    public ItemAdapter(Activity activity, List<Item> listItem) {
        this.activity = activity;
        this.listItem = listItem;
    }

    public void reloadData(List<Item> list) {
        listItem = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_detail, parent, false);
        ItemHolder holder = new ItemHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        Item model = listItem.get(position);
        itemHolder.tvHour.setText(convertTime(model.getDateTime()));
        itemHolder.tvTemp.setText(model.getTemperature().getValue() + "");
        if (model.getWeatherIcon() < 10) {
            Glide.with(activity).load("https://developer.accuweather.com/sites/default/files/0" + model.getWeatherIcon() + "-s.png"
            ).into(itemHolder.ivICon);
        } else {
            Glide.with(activity).load("https://developer.accuweather.com/sites/default/files/" + model.getWeatherIcon() + "-s.png"
            ).into(itemHolder.ivICon);
        }


    }

    @Override
    public int getItemCount() {
        return listItem.size();

    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        ImageView ivICon;
        TextView tvTemp, tvHour;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            ivICon = itemView.findViewById(R.id.ivIcon);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            tvHour = itemView.findViewById(R.id.tvHour);
        }
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
