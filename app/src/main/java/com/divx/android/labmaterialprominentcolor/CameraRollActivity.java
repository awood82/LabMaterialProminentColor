package com.divx.android.labmaterialprominentcolor;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
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
    }
}
