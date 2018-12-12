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

import java.util.ArrayList;
import java.util.List;

public class ingredient_result_adapter extends RecyclerView.Adapter<ingredient_result_adapter.ViewHolder> {

    private List<IngredientPreview> result;
    private Context context;

    public ingredient_result_adapter(List<IngredientPreview> setResult, Context setContext) {
        this.result = setResult;
        this.context = setContext;
        if (result == null) {
            IngredientPreview noResult = new IngredientPreview("NoResult",
                    "please try again" ,
                    "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1544588301&di=ae3d925e18995a5ac18de16b73fd2faf&src=http://www.17qq.com/img_qqtouxiang/7379105.jpeg" );
            result = new ArrayList<>();
            result.add(noResult);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_ingredient, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IngredientPreview ingredientPreview = result.get(position);

        holder.textViewHead.setText(ingredientPreview.getName());
        holder.textViewDesc.setText(ingredientPreview.getDescription());
        holder.textViewType.setText(ingredientPreview.getType());
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
        public TextView textViewType;
        public TextView textViewDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHeadi);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesci);
            textViewType = (TextView) itemView.findViewById(R.id.textViewType);
        }
    }

}
