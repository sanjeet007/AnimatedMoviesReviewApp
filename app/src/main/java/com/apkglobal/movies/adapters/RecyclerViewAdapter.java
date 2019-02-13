package com.apkglobal.movies.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkglobal.movies.activites.FirstActivity;
import com.apkglobal.movies.model.Anime;
import com.apkglobal.movies.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{

    private Context context;
    private List<Anime> list;
    RequestOptions options;

    public RecyclerViewAdapter(Context context, List<Anime> list)
    {
        this.context = context;
        this.list = list;

        options=new RequestOptions().centerCrop().
                placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.anime_row_item,parent,false);
        final MyViewHolder myViewHolder=new MyViewHolder(v);

        myViewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context, FirstActivity.class);
                intent.putExtra("anime_name",list.get(myViewHolder.getAdapterPosition()).getName());
                intent.putExtra("anime_description",list.get(myViewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("anime_studio",list.get(myViewHolder.getAdapterPosition()).getStudio());
                intent.putExtra("anime_category",list.get(myViewHolder.getAdapterPosition()).getCategories());
                intent.putExtra("anime_episode",list.get(myViewHolder.getAdapterPosition()).getNoEpisode());
                intent.putExtra("anime_img",list.get(myViewHolder.getAdapterPosition()).getImg_url());
                intent.putExtra("anime_rating",list.get(myViewHolder.getAdapterPosition()).getRating());

                context.startActivity(intent);

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_categories.setText(list.get(position).getCategories());
        holder.tv_rating.setText(list.get(position).getRating());
        holder.tv_studio.setText(list.get(position).getStudio());

        //Load image from internet and set image in the imageView using Glide
        Glide.with(context).load(list.get(position).getImg_url())
                .apply(options).into(holder.image_thumbnail);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView image_thumbnail;
        private TextView tv_name,tv_rating,tv_categories,tv_studio;
        LinearLayout view_container;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            image_thumbnail=itemView.findViewById(R.id.thumbnail);
            tv_name=itemView.findViewById(R.id.anime_name_id);
            tv_categories=itemView.findViewById(R.id.categories_id);
            tv_rating=itemView.findViewById(R.id.rating_id);
            tv_studio=itemView.findViewById(R.id.studio_id);
            view_container=itemView.findViewById(R.id.anim_layout_id);
        }
    }
}
