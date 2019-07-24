package findik.mustafa.snapshot.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import findik.mustafa.snapshot.R;

public class FragmentFilter extends Fragment {

    private int position;
    private TextView filterText;

    public String[] Title = {
            "Orjinal", "Sahne Tozu", "Mavi Tur", "Yaşlı Adam", "Mars", "Yükseliş", "Bahar", "Orman", "Yıldız Işığı", "Gece Fısıltısı",
            "Limon Ağacı", "Derin", "Mavi Çırpınış", "Karanlık Yol", "50'ler", "60'ler", "70'ler"
    };

    public static Fragment getInstance(int position) {
        FragmentFilter fm = new FragmentFilter();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fm.setArguments(args);
        return fm;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        position = getArguments().getInt("position");

        final View view = inflater.inflate(R.layout.fragment_filter, container, false);
        filterText = view.findViewById(R.id.filter_text);

        filterText.setText(Title[position]);
        if(position == 0) {
            HideText();
        }

        return view;
    }

    public void HideText(){

        filterText.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnim = new AlphaAnimation(1.0f,0.0f);
        alphaAnim.setStartOffset(1000);                        // start in 5 seconds
        alphaAnim.setDuration(100);
        filterText.setAnimation(alphaAnim);
        filterText.postDelayed(new Runnable() {
            @Override
            public void run() {
                filterText.setVisibility(View.GONE);
            }
        },500);
    }
}
