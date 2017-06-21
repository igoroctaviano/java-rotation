package com.exercices.igoroctaviano.secondexercise;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        public ImageView picture;
        public TextView name;
        public TextView birthday;
        public TextView gender;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            this.picture = (ImageView) itemView.findViewById(R.id.img_portrait);
            this.picture.setClipToOutline(true);
            this.name = (TextView) itemView.findViewById(R.id.input_name);
            this.birthday = (TextView) itemView.findViewById(R.id.input_birthday);
            this.gender = (TextView) itemView.findViewById(R.id.input_gender);
        }
    }

    List<Profile> profiles;
    Context context;

    public ProfileAdapter(List<Profile> profiles, Context context) {
        this.profiles = profiles;
        this.context = context;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, null);

        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        Profile profile = profiles.get(position);

        holder.picture.setImageResource(R.drawable.igor);
        holder.name.setText(profile.getName());
        holder.birthday.setText(profile.getBirthday());
        holder.gender.setText(profile.getGender());
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }
}
