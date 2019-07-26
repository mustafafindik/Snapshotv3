package findik.mustafa.snapshot.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import findik.mustafa.snapshot.R;
import findik.mustafa.snapshot.adapters.ChatAdapter;
import findik.mustafa.snapshot.classes.Chat;

public class ChatFragment extends Fragment {

    private RecyclerView cChatReyclerview;
    private LinearLayoutManager mLiner;
    private ChatAdapter chatAdapter;
    final List<Chat> chatList = new ArrayList<>();

    public static  ChatFragment create(){
        return new ChatFragment();
    }

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat,container,false);

        cChatReyclerview = view.findViewById(R.id.chat_recyclerview);

        chatList.clear();
        chatAdapter = new ChatAdapter(chatList);
        mLiner = new LinearLayoutManager(getContext());
        cChatReyclerview.setHasFixedSize(true);
        cChatReyclerview.setLayoutManager(mLiner);
        cChatReyclerview.setAdapter(chatAdapter);
        loadStories();


        return view;
    }

    private void loadStories() {
        for (int i = 0; i < 5; i++) {
            Chat chat = new Chat();

            chat.setFromUsername("Kullanıcı " +i);;
            chat.setChatDate(i +" dk önce");


            chatList.add(chat);
        }

        chatAdapter.notifyDataSetChanged();
        cChatReyclerview.scrollToPosition(chatList.size() - 1);

    }
}
