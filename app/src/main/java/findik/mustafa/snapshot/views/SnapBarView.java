package findik.mustafa.snapshot.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import findik.mustafa.snapshot.MainActivity;
import findik.mustafa.snapshot.R;
import findik.mustafa.snapshot.fragments.CameraFragment;

public class SnapBarView extends FrameLayout implements ViewPager.OnPageChangeListener {
    private ImageView mProfileBtn, mAddFriendsBtn,mRotateCamera;

    private TextView mTitle, mLine;


    public SnapBarView(@NonNull Context context) {
        this(context, null);
    }

    public SnapBarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SnapBarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_snap_bar, this, true);
        mProfileBtn = findViewById(R.id.bar_profile_btn);
        mAddFriendsBtn = findViewById(R.id.bar_add_friend_btn);
        mRotateCamera = findViewById(R.id.bar_rotate_camera_btn);
        mAddFriendsBtn.setVisibility(GONE);
        mTitle = findViewById(R.id.bar_title);
        mLine = findViewById(R.id.bar_line);

    }

    public void setViewPager(final ViewPager viewPager) {
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(this);

            final MainActivity activity = null;

            mProfileBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Profile Gitcek", Toast.LENGTH_SHORT).show();
                }

            });
            mAddFriendsBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Üye Listesine Gitcek", Toast.LENGTH_SHORT).show();
                }

            });
            mRotateCamera.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    CameraFragment fragment = (CameraFragment) ((MainActivity)getContext()).getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.ma_view_pager + ":" + viewPager.getCurrentItem());
                    fragment.rotateCamera();

                }
            });

        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Size size = MainActivity.size;
        float x = size.getWidth();

        mLine.setVisibility(GONE);
        mRotateCamera.setVisibility(GONE);
        if (position == 0) {

            if (positionOffsetPixels < x / 2) {
                float contL = (float) Math.pow(positionOffset, 0.25);

                mAddFriendsBtn.setVisibility(VISIBLE);
                mAddFriendsBtn.setAlpha((float) (1 - (contL)));

                mTitle.setText("Arkadaşlar");
                mTitle.setAlpha((float) (1 - (contL)));
            } else if (positionOffsetPixels == x / 2) {
                mAddFriendsBtn.setVisibility(GONE);
                mTitle.setAlpha(0);
            } else {
                float contR = (float) Math.pow(positionOffset, 4);
                mAddFriendsBtn.setVisibility(GONE);

                mLine.setVisibility(VISIBLE);
                mLine.setAlpha((float) (contR));

                mRotateCamera.setVisibility(VISIBLE);
                mRotateCamera.setAlpha((float) contR);

                mTitle.setText("");
                mTitle.setAlpha((float) (contR));
            }
        } else if (position == 1) {

            if (positionOffsetPixels < x / 2) {
                float contL = (float) Math.pow(positionOffset * 1.4, 0.25);

                mTitle.setText("");
                mTitle.setAlpha((float) 1 - contL);

                mRotateCamera.setVisibility(VISIBLE);
                mRotateCamera.setAlpha((float) 1 - contL);

                mLine.setVisibility(VISIBLE);
                mLine.setAlpha((float) 1 - contL);
            } else if (positionOffsetPixels == x / 2) {
                mTitle.setAlpha(0);
            } else {
                float contR = (float) Math.pow(positionOffset, 6);

                mTitle.setText("Durumlar");
                mTitle.setAlpha((float) contR);
            }

        } else if (position == 2) {
            float contL = (float) Math.pow(positionOffset, 0.15);

            mTitle.setText("Durumlar");
            mTitle.setAlpha((float) 1 - contL);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}