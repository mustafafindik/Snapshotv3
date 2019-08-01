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

        Chat chatUser1 = new Chat();
        chatUser1.setFromUsername("Nazım Hikmet");;
        chatUser1.setChatDate("10 dk önce");
        chatUser1.setRead(true);
        chatList.add(chatUser1);

        Chat chatUser2 = new Chat();
        chatUser2.setFromUsername("Orhan Veli");;
        chatUser2.setChatDate("10 dk önce");
        chatUser2.setRead(true);
        chatList.add(chatUser2);

        Chat chatUser3 = new Chat();
        chatUser3.setFromUsername("Atilla İlhan");;
        chatUser3.setChatDate("12dk önce");
        chatUser3.setRead(false);
        chatList.add(chatUser3);

        Chat chatUser4 = new Chat();
        chatUser4.setFromUsername("Halide Edip");;
        chatUser4.setChatDate("50 dk önce");
        chatUser4.setRead(false);
        chatList.add(chatUser4);

        Chat chatUser5 = new Chat();
        chatUser5.setFromUsername("Cemal Süreya");;
        chatUser5.setChatDate("2 saat önce");
        chatUser5.setRead(false);
        chatList.add(chatUser5);

        chatAdapter.notifyDataSetChanged();
        cChatReyclerview.scrollToPosition(chatList.size() - 1);

    }
}
