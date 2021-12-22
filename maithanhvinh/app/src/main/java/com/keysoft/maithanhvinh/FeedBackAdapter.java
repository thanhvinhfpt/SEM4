package com.keysoft.maithanhvinh;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeedBackAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<FeedBack> listFeedback;

    public FeedBackAdapter(Activity activity, List<FeedBack> listFeedback) {
        this.activity = activity;
        this.listFeedback = listFeedback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.feedback_detail, parent, false);
        ItemHolder holder = new ItemHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        FeedBack model = listFeedback.get(position);
        itemHolder.tvName.setText(model.getName());
        itemHolder.tvEmail.setText(model.getEmail());
        itemHolder.tvId.setText(model.getId() + "");
        itemHolder.tvContent.setText(model.getContent());
    }

    @Override
    public int getItemCount() {
        return listFeedback.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEmail, tvId, tvContent;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvId = itemView.findViewById(R.id.tvId);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }

}
