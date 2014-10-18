package com.divx.android.labmaterialprominentcolor;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class CameraRollActivity extends Activity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_roll);

        mListView = (ListView) findViewById(R.id.cameraRoll);

        Cursor cursor = getContentResolver().query(
                MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Video.Thumbnails._ID, MediaStore.Video.Thumbnails.DATA },
                null, // return all rows
                null,
                null); // default sort order

        ListAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[] { MediaStore.Video.Thumbnails.DATA },
                new int[] { android.R.id.text1 },
                0);
        mListView.setAdapter(adapter);
    }
}
