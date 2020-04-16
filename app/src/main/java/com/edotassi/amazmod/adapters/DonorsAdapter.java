package com.edotassi.amazmod.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edotassi.amazmod.R;
import com.edotassi.amazmod.ui.DonorsActivity;
import com.edotassi.amazmod.util.picasso.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DonorsAdapter extends RecyclerView.Adapter<DonorsAdapter.MyViewHolder> {

    DonorsActivity donorsActivity;
    List<DonorsActivity.Donor> donorsList;

    public DonorsAdapter(DonorsActivity donorsActivity, List<DonorsActivity.Donor> donorList) {
        this.donorsActivity = donorsActivity;
        this.donorsList = donorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(donorsActivity)
                .inflate(R.layout.row_donor, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DonorsActivity.Donor donor = donorsList.get(position);
        holder.textDonorName.setText(donor.name);
        holder.textDonorRole.setText(donor.role);
        holder.textDonorAmount.setText(donor.currency + " " + String.valueOf(donor.totalAmountDonated));
        Picasso.get()
                .load(donor.image)
                .placeholder(R.drawable.account_box)
                .resize(128, 128)
                .centerCrop()
                .transform(new CircleTransform(10,0))
                .into(holder.textDonorPicture);
    }

    @Override
    public int getItemCount() {
        return donorsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textDonorName;
        TextView textDonorRole;
        TextView textDonorAmount;
        ImageView textDonorPicture;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textDonorName = itemView.findViewById(R.id.row_donor_name);
            textDonorRole = itemView.findViewById(R.id.row_donor_role);
            textDonorPicture = itemView.findViewById(R.id.row_donor_avatar);
            textDonorAmount = itemView.findViewById(R.id.row_donor_amount);
        }
    }
}