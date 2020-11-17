package com.example.goodslisthoff.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.goodslisthoff.R;
import com.example.goodslisthoff.model.Items;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {
    private final List<Items> mCouches;

     public GoodsAdapter(List<Items> couches) {
        this.mCouches = couches;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GoodsAdapter.GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsAdapter.GoodsViewHolder holder, int position) {
        holder.bind(mCouches.get(position));
    }

    @Override
    public int getItemCount() {
        return mCouches.size();
    }

    public class GoodsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mCouchesImage;
        private final TextView mCouchesTitle;
        private final TextView mCouchesPrice;

        public GoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            mCouchesImage = itemView.findViewById(R.id.imageCouch);
            mCouchesTitle = itemView.findViewById(R.id.couch_title);
            mCouchesPrice = itemView.findViewById(R.id.price);
            TextView mCouchesSale = itemView.findViewById(R.id.sale);
        }

        @SuppressLint("SetTextI18n")
        private void bind(final Items items) {

            mCouchesTitle.setText(items.getName());
            mCouchesPrice.setText(items.getPrices() + mCouchesImage.getContext().getString(R.string.rub_sign));

            Glide.with(mCouchesImage.getContext())
                    .load(items.getImage())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_baseline_refresh_24)
                            .centerCrop()
                            .error(R.drawable.ic_launcher_foreground))
                    .into(mCouchesImage);

        }
    }
}
