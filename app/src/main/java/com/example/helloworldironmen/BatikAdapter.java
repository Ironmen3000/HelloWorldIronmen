package com.example.helloworldironmen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BatikAdapter extends RecyclerView.Adapter<BatikAdapter.ViewHolder>{

    private ArrayList<BatikModel> mBatikModel;
    private Context mContext;


    BatikAdapter(Context context, ArrayList<BatikModel>BatikModel) {
        this.mBatikModel = BatikModel;
        this.mContext = context;
    }



    @Override
    public BatikAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.batik_list, parent, false));
    }


    @Override
    public void onBindViewHolder(BatikAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        BatikModel currentBatik = mBatikModel.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentBatik);
    }


    @Override
    public int getItemCount() {
        return mBatikModel.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mBatikImage;


        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mBatikImage = itemView.findViewById(R.id.BatikImage);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(BatikModel currentBatik){
            // Populate the textviews with data.
            mTitleText.setText(currentBatik.getTitle());
            mInfoText.setText(currentBatik.getInfo());

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(
                    currentBatik.getImageResource()).into(mBatikImage);
        }


        @Override
        public void onClick(View view) {
            BatikModel currentBatik = mBatikModel.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentBatik.getTitle());
            detailIntent.putExtra("image_resource",
                    currentBatik.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }



}