package com.example.shopify;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class HorizonatalCategoriesAdapter extends RecyclerView.Adapter<HorizonatalCategoriesAdapter.ViewHolder>{
    private int[] images = {R.drawable.caro1, R.drawable.caro2, R.drawable.caro3, R.drawable.caro4, R.drawable.caro5,R.drawable.caro1, R.drawable.caro2, R.drawable.caro3, R.drawable.caro4, R.drawable.caro5};


    @NonNull
    @Override
    public HorizonatalCategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View Holder = inflater.inflate(R.layout.categories_horizonatal_view,parent,false);
        ViewHolder adapter = new ViewHolder(Holder);
        return  adapter;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizonatalCategoriesAdapter.ViewHolder holder, int position) {

            ImageView imageView=holder.itemView.findViewById(R.id.category1Image);
            imageView.setImageResource(images[position]);


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.e("WELOCM",String.valueOf(position));
           }
       });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            CardView cardView = itemView.findViewById(R.id.holder);

        }
    }
}
