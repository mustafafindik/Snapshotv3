package findik.mustafa.snapshot;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zomato.photofilters.imageprocessors.Filter;

import java.util.ArrayList;
import java.util.List;

import findik.mustafa.snapshot.adapters.FilterAdapter;
import findik.mustafa.snapshot.fragments.CameraFragment;
import findik.mustafa.snapshot.fragments.FragmentFilter;
import findik.mustafa.snapshot.utils.FilteredImageItem;
import findik.mustafa.snapshot.utils.SampleFilters;

public class PreviewActivity extends AppCompatActivity {

    static {
        System.loadLibrary("NativeImageProcessor");
    }

    ArrayList<FilteredImageItem> Deneme = new ArrayList<FilteredImageItem>();
    ArrayList<Bitmap> FilteredImageList = new ArrayList<Bitmap>();
    public  static  ArrayList<String> Names = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        final ImageView mPhotoEditorView = findViewById(R.id.imageView);
        mPhotoEditorView.setImageBitmap(CameraFragment.bitmap);
        FilterHolder();
        SetFilters();


        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        FilterAdapter pagerAdapter = new FilterAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                FragmentFilter fragment = (FragmentFilter) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.vpPager + ":" + position);
                fragment.HideText();
                mPhotoEditorView.setImageBitmap(FilteredImageList.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void FilterHolder() {
        Bitmap thumbImage = CameraFragment.bitmap;
        List<Filter> filters = SampleFilters.getFilterPack(getApplicationContext());

        FilteredImageItem s = new FilteredImageItem();
        s.image = thumbImage;
        s.filter = null;
        s.Name = "Orjinal";
        Deneme.add(s);

        for (Filter filter : filters) {
            FilteredImageItem xd = new FilteredImageItem();
            xd.image = thumbImage;
            xd.filter = filter;
            xd.Name = filter.getName();
            Deneme.add(xd);
        }


    }

    private void SetFilters() {
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Deneme.size(); i++) {
                    FilteredImageItem item = Deneme.get(i);
                    Bitmap bitmap = item.image;
                    Filter filter = item.filter;
                    Bitmap Lost;
                    if (i == 0) {
                        FilteredImageList.add(bitmap);
                    } else {
                        FilteredImageList.add(filter.processFilter(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false)));
                    }
                    Names.add(item.Name);
                }
            }

        };
        new Thread(r).start();

    }






}

