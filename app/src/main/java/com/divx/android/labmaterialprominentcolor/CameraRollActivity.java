package com.divx.android.labmaterialprominentcolor;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;


public class CameraRollActivity extends Activity {
    private GridView mCameraRollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_roll);

        mCameraRollView = (GridView) findViewById(R.id.cameraRoll);

        Cursor cursor = getContentResolver().query(
                MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Video.Thumbnails._ID, MediaStore.Video.Thumbnails.DATA },
                null, // return all rows
                null,
                null); // default sort order

        ListAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.grid_item,
                cursor,
                new String[] { MediaStore.Video.Thumbnails.DATA },
                new int[] { R.id.thumbnailUri },
                0);
        mCameraRollView.setAdapter(adapter);

        mCameraRollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((ImageView)view.findViewById(R.id.thumbnailUri)).setColorFilter(0xAA009999);
            }
        });
    }
}
