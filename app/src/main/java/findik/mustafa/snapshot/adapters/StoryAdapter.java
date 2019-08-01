package findik.mustafa.snapshot.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import findik.mustafa.snapshot.R;
import findik.mustafa.snapshot.classes.Story;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    public List<Story> stories;


     public class MyViewHolder extends RecyclerView.ViewHolder {
          public CircleImageView userPhoto;
          public TextView username,storytime;

          MyViewHolder(View view) {
              super(view);
              userPhoto = view.findViewById(R.id.story_userImage);
              username = view.findViewById(R.id.story_UserName);
              storytime = view.findViewById(R.id.story_time);
    }

 }

    public StoryAdapter(List<Story> stories) {
        this.stories = stories;
    }

    @Override
    public StoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_single_item, parent, false);
        return new StoryAdapter.MyViewHolder(itemView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final StoryAdapter.MyViewHolder holder, int position) {
        final Story story = stories.get(position);
        final Context context = holder.userPhoto.getContext(); // Context.

        final String UserName = story.getUserName();
        final String image = story.getUserImage();
        final String time = story.getStoryDate();

        holder.username.setText(UserName);
        holder.storytime.setText(time);
        Picasso.get()
                .load(image)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .placeholder(R.color.light_grey)
                .into(holder.userPhoto, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        //do smth when picture is loaded successfully
                    }

                    @Override
                    public void onError(Exception ex) {
                        Picasso.get().load(R.color.light_grey).into(holder.userPhoto);
                    }
                });

        if(!story.getLook()){
            holder.username.setTypeface(null, Typeface.BOLD);
            holder.userPhoto.setBorderColor(R.color.light_blue);
            holder.userPhoto.setBorderWidth(8);
        }
    }


    @Override
    public int getItemCount() {
        return stories.size();
    }


}