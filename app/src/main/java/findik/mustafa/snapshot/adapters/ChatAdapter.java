package findik.mustafa.snapshot.adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import findik.mustafa.snapshot.R;
import findik.mustafa.snapshot.classes.Chat;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    public List<Chat> chats;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView chatIcon;
        public TextView username,chattime,chatAnswertext;

        MyViewHolder(View view) {
            super(view);

            username = view.findViewById(R.id.chat_UserName);
            chattime = view.findViewById(R.id.chat_time);
            chatIcon = view.findViewById(R.id.chat_icon);
            chatAnswertext = view.findViewById(R.id.chat_answer);
        }

    }

    public ChatAdapter(List<Chat> chats) {
        this.chats = chats;
    }

    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_chat_item, parent, false);
        return new ChatAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ChatAdapter.MyViewHolder holder, int position) {
        final Chat chat = chats.get(position);
        final String UserName = chat.getFromUsername();
        final String time = chat.getChatDate();

        holder.username.setText(UserName);
        holder.chattime.setText(time);
        if (chat.getRead()){
            holder.username.setTypeface(null, Typeface.BOLD);
        }

    }


    @Override
    public int getItemCount() {
        return chats.size();
    }


}