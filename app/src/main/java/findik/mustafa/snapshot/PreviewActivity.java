package findik.mustafa.snapshot;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.zomato.photofilters.imageprocessors.Filter;

import java.util.ArrayList;
import java.util.List;

import findik.mustafa.snapshot.adapters.FilterAdapter;
import findik.mustafa.snapshot.fragments.CameraFragment;
import findik.mustafa.snapshot.fragments.FragmentFilter;
import findik.mustafa.snapshot.utils.FilteredImageItem;
import findik.mustafa.snapshot.utils.SampleFilters;

public class PreviewActivity extends AppCompatActivity
{

    int COUNT = 0;


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

        final ViewPager viewPager =  findViewById(R.id.vpPager);

        final ImageView mPhotoEditorView = findViewById(R.id.imageView);
        mPhotoEditorView.setImageBitmap(CameraFragment.bitmap);
        FilterHolder();
        SetFilters();


        FilterAdapter pagerAdapter = new FilterAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


        COUNT = pagerAdapter.getCount();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                FragmentFilter fragment = (FragmentFilter) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.vpPager + ":" + position);

                ImageView btndnload=  fragment.getView().findViewById(R.id.image_download);
                ImageView btncncel=  fragment.getView().findViewById(R.id.image_cancel);
                ImageView btnsend=  fragment.getView().findViewById(R.id.image_send);

                if ( positionOffset==0.00f ){
                    btndnload.setAlpha(1-positionOffset);
                    btncncel.setAlpha(1-positionOffset);

                    btnsend.setAlpha(1-positionOffset);
                }else{
                    btndnload.setAlpha((float) Math.pow(positionOffset, 20));
                    btncncel.setAlpha((float) Math.pow(positionOffset, 20));

                    btnsend.setAlpha((float) Math.pow(positionOffset, 20));
                }


            }

            @Override
            public void onPageSelected(int position) {
                FragmentFilter fragment = (FragmentFilter) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.vpPager + ":" + position);
                fragment.HideText();
                ImageView btn=  fragment.getView().findViewById(R.id.image_download);

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


    public void DownloadIamge() {
        Toast.makeText(this, "İndirme", Toast.LENGTH_SHORT).show();
    }

    public void Closeamge() {
        onBackPressed();
        Toast.makeText(this, "İptal", Toast.LENGTH_SHORT).show();
    }

    public void SendImage() {
        Toast.makeText(this, "Göderme", Toast.LENGTH_SHORT).show();
    }


}

