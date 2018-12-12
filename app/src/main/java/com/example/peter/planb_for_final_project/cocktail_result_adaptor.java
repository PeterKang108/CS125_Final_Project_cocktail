package com.example.peter.planb_for_final_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class cocktail_result_adaptor extends RecyclerView.Adapter<cocktail_result_adaptor.ViewHolder> {

    private List<CocktailPreview> result;
    private Context context;

    public cocktail_result_adaptor(List<CocktailPreview> setResult, Context setContext) {
        this.result = setResult;
        this.context = setContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_cocktail, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CocktailPreview cocktailPreview = result.get(position);

        holder.textViewHead.setText(cocktailPreview.getName());
        holder.textViewDesc.setText(cocktailPreview.getDescription());

        Picasso.with(context)
                .load(cocktailPreview.getImageURL())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (result == null) {
            return 0;
        }
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageView = (ImageView) itemView.findViewById(R.id.cocktailImage);
        }
    }

}
