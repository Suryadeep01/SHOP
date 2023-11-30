package com.example.shopify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder>{
    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View Holder = inflater.inflate(R.layout.categories_item_view,parent,false);
        ViewHolder adapter = new ViewHolder(Holder);
        return  adapter;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        TextView textView = holder.itemView.findViewById(R.id.categoriesHeading);
        switch (position){
            case 0:{
                textView.setText("Male");
                break;
            }
            case 1: {
                textView.setText("Female");
                break;
            }
            case 2:{
                textView.setText("KIds");
                break;
            }
        }



    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            RecyclerView recyclerView = itemView.findViewById(R.id.horizontal_only);
            HorizonatalCategoriesAdapter adapter = new HorizonatalCategoriesAdapter();
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));

           // recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }
    }
}
