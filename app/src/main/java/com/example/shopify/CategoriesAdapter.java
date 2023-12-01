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
                holder.recyclerView =  holder.itemView.findViewById(R.id.horizontal_only);
                holder.adapter = new HorizonatalCategoriesAdapter();
                holder.adapter.addDb(0);
                holder.recyclerView.setAdapter( holder.adapter);
                holder.recyclerView.setLayoutManager(new LinearLayoutManager( holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));


                break;
            }
            case 1: {
                textView.setText("Female");
                holder.recyclerView =  holder.itemView.findViewById(R.id.horizontal_only);
                holder.adapter = new HorizonatalCategoriesAdapter();
                holder.adapter.addDb(1);
                holder.recyclerView.setAdapter( holder.adapter);
                holder.recyclerView.setLayoutManager(new LinearLayoutManager( holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                break;
            }
            case 2:{
                textView.setText("KIds");
                holder.recyclerView =  holder.itemView.findViewById(R.id.horizontal_only);
                holder.adapter = new HorizonatalCategoriesAdapter();
                holder.adapter.addDb(2);
                holder.recyclerView.setAdapter( holder.adapter);
                holder.recyclerView.setLayoutManager(new LinearLayoutManager( holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                break;
            }
        }



    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        HorizonatalCategoriesAdapter adapter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           // recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }
    }
}
