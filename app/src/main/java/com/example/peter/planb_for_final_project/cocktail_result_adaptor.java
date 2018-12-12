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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class cocktail_result_adaptor extends RecyclerView.Adapter<cocktail_result_adaptor.ViewHolder> {

    private List<CocktailPreview> result;
    private Context context;
    private List<Cocktail> info;
    private String ingredientsAndMeasures = "";
    private CocktailPreview noResult;

    public cocktail_result_adaptor(List<Cocktail> setInfo, List<CocktailPreview> setResult, Context setContext) {
        this.result = setResult;
        this.info = setInfo;
        this.context = setContext;
        if (result == null) {
            noResult = new CocktailPreview("NoResult",
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
                .inflate(R.layout.activity_list_cocktail, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ArrayList<Boolean> open = new ArrayList<>();
        if (open.size() == 0) {
            open.add(true);
        }
        CocktailPreview cocktailPreview = result.get(position);
        holder.textViewHead.setText(cocktailPreview.getName());
        holder.textViewDesc.setText(cocktailPreview.getDescription());

        Picasso.with(context)
                .load(cocktailPreview.getImageURL())
                .into(holder.imageView);
        if (info == null) {
            return;
        }
        final Cocktail cocktailInfo = info.get(position);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (open.get(0)) {
                    holder.glass.setText(cocktailInfo.getGlass());
                    holder.alcoholic.setText(cocktailInfo.getAlcohol());
                    holder.instructions.setText(cocktailInfo.getInstructions());
                    for (int i = 0; i < 15; i++) {
                        ingredientsAndMeasures = ingredientsAndMeasures +
                                cocktailInfo.getIngredientsAndMeasures()[i] + "\n";
                    }
                    holder.ingredientsMeasures.setText(ingredientsAndMeasures);
                    open.set(0, false);
                } else {
                    holder.glass.setText(null);
                    holder.alcoholic.setText(null);
                    holder.instructions.setText(null);
                    holder.ingredientsMeasures.setText(null);
                    open.set(0, true);
                }
            }
        });
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
        public TextView glass;
        public TextView alcoholic;
        public TextView instructions;
        public TextView ingredientsMeasures;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageView = (ImageView) itemView.findViewById(R.id.cocktailImage);
            glass = (TextView) itemView.findViewById(R.id.info_glass);
            alcoholic = (TextView) itemView.findViewById(R.id.info_alcoholic);
            instructions = (TextView) itemView.findViewById(R.id.info_instructions);
            ingredientsMeasures = (TextView) itemView.findViewById(R.id.info_ingredients_measures);
        }
    }

}
