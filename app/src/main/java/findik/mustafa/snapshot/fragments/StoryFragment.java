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
import findik.mustafa.snapshot.adapters.StoryAdapter;
import findik.mustafa.snapshot.classes.Story;

public class StoryFragment  extends Fragment {

    private RecyclerView sStoryRecylerview;
    private LinearLayoutManager mLiner;
    private StoryAdapter storyAdapter;
    final List<Story> storyList = new ArrayList<>();

    public static  StoryFragment create(){
        return new StoryFragment();
    }

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_story,container,false);
        sStoryRecylerview = view.findViewById(R.id.story_recyclerview);

        storyList.clear();
        storyAdapter = new StoryAdapter(storyList);
        mLiner = new LinearLayoutManager(getContext());
        sStoryRecylerview.setHasFixedSize(true);
        sStoryRecylerview.setLayoutManager(mLiner);
        sStoryRecylerview.setAdapter(storyAdapter);
        loadStories();

        return view;
    }

    private void loadStories() {

        for (int i = 0; i < 5; i++) {
            Story story = new Story();

            story.setUserName("Kullanıcı " +i);
            story.setUserId(i+"");
            story.setStoryId((i*i)+"");
            story.setStoryDate("8:24 AM");


            storyList.add(story);
        }

        storyAdapter.notifyDataSetChanged();
        sStoryRecylerview.scrollToPosition(storyList.size() - 1);
    }
}
