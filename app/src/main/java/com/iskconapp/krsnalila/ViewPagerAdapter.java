package com.iskconapp.krsnalila;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

public class ViewPagerAdapter extends PagerAdapter {

    String[] url = {
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/1srilaprabhupada.jpg?alt=media&token=86d5ea21-7e1e-4c94-8d74-c63e0a425c66",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/30dea13e-a531-4333-b8bb-bad62efd34ef_Tamal_Krishna_Goswami_with_Srila_Prabhupada_-_017.jpg?alt=media&token=cc1b38b3-589e-4b6a-8239-de1c719abaa6",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/5-Tips-from-Srila-Prabhupada-on-chanting.jpg?alt=media&token=f98053a8-724f-45b0-8dda-041e6e86e126",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/a-c-bhaktivedanta-swami-prabhupada.jpg?alt=media&token=a2729306-1005-4146-b314-020471b6c79c",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/download.jpg?alt=media&token=06caf871-29ae-4f6f-a64c-bc03b3ee2524",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/hqdefault%20(1).jpg?alt=media&token=89795570-63a6-47f4-8bfc-eca09186bc18",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/hqdefault.jpg?alt=media&token=b683e04a-cb35-43c0-8c63-3d1de360fd70",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/images.jpg?alt=media&token=a6894d57-dc94-4c12-aa34-4e3db440948a",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/KrishnaDwarka.jpg?alt=media&token=07a7e096-804b-462c-b344-84aaccbec6d4",
            "https://firebasestorage.googleapis.com/v0/b/krishna-lila.appspot.com/o/prabhupada.jpg?alt=media&token=08d01a9d-9a76-4ac5-8364-4ff2043a4d9a"
    };

    private Context ctx;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return url.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.view_pager_image, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.view_pager_iv);
        Glide.with(ctx).load(url[position]).into(imageView);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
