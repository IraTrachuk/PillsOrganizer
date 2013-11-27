package com.example.pillsorganizer2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void editPills(View view) {
        Intent intent = new Intent(this, EditPillsActivity.class);
        startActivity(intent);
    }
}
