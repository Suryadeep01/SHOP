package com.example.shopify;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class HorizonatalCategoriesAdapter extends RecyclerView.Adapter<HorizonatalCategoriesAdapter.ViewHolder>{





    int remote = 0;

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

            switch (remote) {
                case 0 : {
                    Glide.with(holder.itemView.getContext()).load(ShopDb.getInstance().Male[position]).into(holder.imageView);
                    break;
                }
                case 1: {
                    Glide.with(holder.itemView.getContext()).load(ShopDb.getInstance().Female[position]).into(holder.imageView);
                    break;
                }
                case 2: {
                    Glide.with(holder.itemView.getContext()).load(ShopDb.getInstance().Kids[position]).into(holder.imageView);
                    break;
                }
            }



       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent  intent = new Intent(holder.itemView.getContext(),ProductDescriptionActivity.class);
//               intent.putExtra("Category",String.valueOf(remote));
//               intent.putExtra("product",String.valueOf(position));
               intent.putExtra("Category", remote);
               intent.putExtra("product", position);

               holder.itemView.getContext().startActivity(intent);

           }
       });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public void addDb(int male) {
      remote = male;


        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             imageView=itemView.findViewById(R.id.category1Image);
             cardView = itemView.findViewById(R.id.holder);

        }
    }
}
