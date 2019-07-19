package com.iskconapp.krsnalila;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import java.lang.ref.Reference;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tb1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference reference = storage.getReferenceFromUrl("gs://krishna-lila.appspot.com/")
                                    .child("download.jpg");
        final ImageView iv = findViewById(R.id.iv1);
        reference.getBytes(1024*1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                iv.setImageBitmap(bitmap);
            }
        });

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem home = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withLevel(1).withIcon(R.drawable.home);
       // PrimaryDrawerItem about = new PrimaryDrawerItem().withIdentifier(1).withName("About");
        //PrimaryDrawerItem gallery = new PrimaryDrawerItem().withIdentifier(2).withName("Gallery");
        //PrimaryDrawerItem archives = new PrimaryDrawerItem().withIdentifier(3).withName("Archives");
//        SecondaryDrawerItem settings = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(4).withName("Settings");
//        SecondaryDrawerItem supportUs = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(5).withName("Support Us");
        SecondaryDrawerItem biography = new SecondaryDrawerItem().withIdentifier(2).withName("Biography").withLevel(2);
        SecondaryDrawerItem wisp = new SecondaryDrawerItem().withIdentifier(3).withName("Who is Srila Prabhupadalila").withLevel(2);
        SecondaryDrawerItem analogies = new SecondaryDrawerItem().withIdentifier(4).withName("Prabhupada Analogies").withLevel(2);
        SecondaryDrawerItem predictions = new SecondaryDrawerItem().withIdentifier(5).withName("Predictions").withLevel(2);
        SecondaryDrawerItem rarePictures = new SecondaryDrawerItem().withIdentifier(6).withName("Rare pictures").withLevel(2);
        SecondaryDrawerItem videos = new SecondaryDrawerItem().withIdentifier(7).withName("Videos").withLevel(2);
        SecondaryDrawerItem quotes = new SecondaryDrawerItem().withIdentifier(8).withName("Quotes").withLevel(2);
        SecondaryDrawerItem memories = new SecondaryDrawerItem().withIdentifier(9).withName("Memories").withLevel(2);
        SecondaryDrawerItem voc = new SecondaryDrawerItem().withIdentifier(10).withName("Voyage of Compassion").withLevel(2);
        SecondaryDrawerItem qf = new SecondaryDrawerItem().withIdentifier(11).withName("Quick Facts").withLevel(2);
        SecondaryDrawerItem temples = new SecondaryDrawerItem().withIdentifier(12).withName("108 Temples").withLevel(2);
        SecondaryDrawerItem pfp = new SecondaryDrawerItem().withIdentifier(13).withName("Poetry for Prabhupada").withLevel(2);
        SecondaryDrawerItem pbp = new SecondaryDrawerItem().withIdentifier(14).withName("Poetry by Prabhupada").withLevel(2);
        SecondaryDrawerItem donate = new SecondaryDrawerItem().withIdentifier(15).withName("Donate").withLevel(2);
        SecondaryDrawerItem feedback = new SecondaryDrawerItem().withIdentifier(16).withName("Feedback").withLevel(2);
        SecondaryDrawerItem acknowledgement = new SecondaryDrawerItem().withIdentifier(17).withName("Acknowledgement").withLevel(2);

        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.background)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName(getResources().getString(R.string.app_name))

                                .withIcon(getResources().getDrawable(R.drawable.icon))
                )
                .withSelectionListEnabledForSingleProfile(false).build();

                //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(header)
                .withToolbar(toolbar)

                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        home,
                        new ExpandableDrawerItem().withName("About").withIcon(R.drawable.about)
                        .withSubItems(wisp,biography,analogies,predictions,acknowledgement).withIdentifier(18),

                        new ExpandableDrawerItem().withName("Gallery").withIcon(R.drawable.gallery)
                                .withSubItems(rarePictures,videos,quotes,memories).withIdentifier(19),
                        new ExpandableDrawerItem().withName("Archives").withIcon(R.drawable.archive)
                                .withSubItems(voc,qf,temples,pfp,pbp).withIdentifier(20),
                        new DividerDrawerItem(),
                        new ExpandableDrawerItem().withName("Support Us").withIcon(R.drawable.support)
                                .withSubItems(donate,feedback).withIdentifier(21)

                ).build();
        result.getExpandableExtension().withOnlyOneExpandedItem(true);


    }


}
