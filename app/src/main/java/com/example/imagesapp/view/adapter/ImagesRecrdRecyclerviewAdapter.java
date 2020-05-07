package com.example.imagesapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.imagesapp.R;
import com.example.imagesapp.model.Items;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImagesRecrdRecyclerviewAdapter extends RecyclerView.Adapter<ImagesRecrdRecyclerviewAdapter.ViewHolder> {
    private Context context;
    private Items[] itemList;
    private RecyclerViewListener recyclerViewListener;

    public ImagesRecrdRecyclerviewAdapter(Items[] itemList, Context context, RecyclerViewListener recyclerViewListener) {
        this.itemList = itemList;
        this.context = context;
        this.recyclerViewListener = recyclerViewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(listItem,recyclerViewListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.render(viewHolder, position);
    }

    @Override
    public int getItemCount() {
        return itemList.length;
    }

    public interface RecyclerViewListener {
        void onItemClick(Items items);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder holder;
        int position;
        ImageView imageView;
        TextView textView;
        RecyclerViewListener recyclerViewListener;

        ViewHolder(@NonNull View itemView, RecyclerViewListener recyclerViewListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
            textView = itemView.findViewById(R.id.imageTitle);
            this.recyclerViewListener = recyclerViewListener;
        }

        void render(ViewHolder viewHolder, int position) {
            this.holder = viewHolder;
            this.position = position;
            setImageMetadata();
            setImage();
            onItemClick();
        }

        private void setImageMetadata() {
            if(itemList[position]!=null)
               textView.setText(itemList[position].getTitle());
        }

        private void onItemClick() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewListener.onItemClick(itemList[position]);
                }
            });
        }

        private void setImage() {
            String imageURL = null;
            if(itemList[position]!=null && itemList[position].getPagemap()!=null && itemList[position].getPagemap().getCse_image()!=null
                            && itemList[position].getPagemap().getCse_image()[0].getSrc()!=null
            ) {
                imageURL = itemList[position].getPagemap().getCse_image()[0].getSrc();
            }

            if (imageURL != null && !imageURL.isEmpty() && !imageURL.equals(" ")) {
                Picasso.with(context)
                        .load(imageURL)
                        .into(imageView);
            }
            else
                holder.imageView.setImageResource(R.drawable.image_not_present);

        }
    }

}
