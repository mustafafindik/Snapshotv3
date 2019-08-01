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


        Story story1 = new Story();
        story1.setUserName("Nazım Hikmet");;
        story1.setUserId("1");
        story1.setStoryId("1");
        story1.setStoryDate("8:24 AM");
        story1.setLook(false);
        storyList.add(story1);

        Story story2 = new Story();
        story2.setUserName("Cemal Süreya");;
        story2.setUserId("2");
        story2.setStoryId("2");
        story2.setStoryDate("22:33 PM");
        story2.setLook(true);
        storyList.add(story2);

        Story story3 = new Story();
        story3.setUserName("Atilla İlhan");;
        story3.setUserId("3");
        story3.setStoryId("3");
        story3.setStoryDate("4:24 AM");
        story3.setLook(true);
        storyList.add(story3);


        storyAdapter.notifyDataSetChanged();
        sStoryRecylerview.scrollToPosition(storyList.size() - 1);
    }
}
