package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
   private Context context;
   private List<NewsHeadlines> headlinesList;
private SelecetListener listener;
    public CustomAdapter(Context context, List<NewsHeadlines> headlinesList, SelecetListener listener) {
        this.context = context;
        this.headlinesList = headlinesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headlinelistitems,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(headlinesList.get(position).getTitle());
        holder.text_source.setText(headlinesList.get(position).getSource().getName());
     if(headlinesList.get(position).getUrlToImage()!=null){
    Picasso.get().load(headlinesList.get(position).getUrlToImage()).into(holder.img_headline);

}
     holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             listener.OnNewsCliked(headlinesList.get(holder.getAdapterPosition()));
         }
     });
    }

    @Override
    public int getItemCount() {
        return headlinesList.size();
    }
}
