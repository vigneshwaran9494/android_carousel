package obs.com.carrouseleffect;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import obs.com.carrouseleffect.adapters.MyCustomPagerAdapter;
import obs.com.carrouseleffect.customview.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity {

    private MyCustomPagerAdapter carouselPagerAdapter;
    private ViewPager pager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initViews();
    }

    private void initViews() {
        pager = findViewById(R.id.view_pager);
        carouselPagerAdapter = new MyCustomPagerAdapter(context, getImages());
        pager.setPageTransformer(true, new ZoomOutPageTransformer(true));
        pager.setAdapter(carouselPagerAdapter);
        pager.setOffscreenPageLimit(3);
        pager.setCurrentItem(1);
        pager.setClipChildren(false);
        updateBottomView();

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("", "");
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("", "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("", "");
                updateBottomView();
            }
        });
    }

    private void updateBottomView() {
        for (int i = 0; i < 20; i++) {
            View bottomView = pager.findViewWithTag("bottomLayout" + i);
            if (bottomView != null) {
                bottomView.setVisibility(i == pager.getCurrentItem() ? View.VISIBLE : View.GONE);
            }
        }
    }

    private int[] getImages() {
        int[] image = new int[20];
        for (int i = 0; i < 20; i++) {
            image[i] = R.drawable.srcimage;
        }
        return image;
    }
}
