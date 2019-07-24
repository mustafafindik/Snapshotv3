package findik.mustafa.snapshot.views;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import findik.mustafa.snapshot.R;

public class SnapTabsView extends FrameLayout implements ViewPager.OnPageChangeListener {

    private ImageView mCapturePhotoBtn;
    private ImageView mChatBtn;



    private ImageView mStoryBtn;

    private int mCenterColor;
    private int mOffsetColor;
    private ArgbEvaluator mColorEval;

    public SnapTabsView(@NonNull Context context) {
        this(context, null);
    }

    public SnapTabsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SnapTabsView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_snap_tabs, this, true);
        mCapturePhotoBtn =   findViewById(R.id.capture_photo_btn);
        mChatBtn =  findViewById(R.id.chat_btn);
        mStoryBtn =   findViewById(R.id.story_btn);

        mCenterColor = ContextCompat.getColor(getContext(), R.color.white);
        mOffsetColor = ContextCompat.getColor(getContext(), R.color.light_purple);
        mColorEval = new ArgbEvaluator();
    }

    public ImageView getmCapturePhotoBtn() {
        return mCapturePhotoBtn;
    }

    public ImageView getmChatBtn() {
        return mChatBtn;
    }

    public ImageView getmStoryBtn() {
        return mStoryBtn;
    }


    public void setViewPager(final ViewPager viewPager) {
        if(viewPager != null) {
            viewPager.addOnPageChangeListener(this);
            mChatBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(viewPager.getCurrentItem() != 0)
                        viewPager.setCurrentItem(0);
                }

            });

            mCapturePhotoBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(viewPager.getCurrentItem() != 1)
                        viewPager.setCurrentItem(1);
                }
            });

            mStoryBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(viewPager.getCurrentItem() != 2)
                        viewPager.setCurrentItem(2);
                }

            });
        }
    }

    private void setColor(float fractionFromCenter) {
        int color = (int) mColorEval.evaluate(fractionFromCenter,mOffsetColor ,mCenterColor );
        mChatBtn.setColorFilter(color);
        mStoryBtn.setColorFilter(color);
        mCapturePhotoBtn.setColorFilter(color);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(position == 0) {
            setColor(positionOffset);
        }
        else if(position == 1) {
            setColor(1-positionOffset);

        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}