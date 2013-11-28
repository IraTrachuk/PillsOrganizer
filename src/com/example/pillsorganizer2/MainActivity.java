package com.example.pillsorganizer2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.pillsorganizer2.dao.Database;
import com.example.pillsorganizer2.dao.Pill;
import com.example.pillsorganizer2.dao.Schedule;
import com.example.pillsorganizer2.dao.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    private Database db = Database.getInstance();

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

    public void changeUser(View view) {
        EditText np = (EditText) findViewById(R.id.userName);
        db.setCurrentUser(new User(np.getText().toString()));
    }

    public void DoRefresh (View view) {
        List<Schedule> sch = db.getSchedules();
        List<Pill> pills = db.getPills();

        StringBuilder[] schTexts = new StringBuilder[sch.size()];

        for(int i = 0; i < sch.size(); i++){
            schTexts[i] = new StringBuilder(sch.get(i).getName());
        }

        for(Pill p : pills){
            String ctext = "\n\t"+p.getPillName();
            switch (p.getDose()){
                case 1: schTexts[1].append(ctext); break;
                case 2: schTexts[0].append(ctext);schTexts[2].append(ctext); break;
                case 3: schTexts[0].append(ctext);schTexts[1].append(ctext);schTexts[2].append(ctext); break;
            }
        }

        List<StringBuilder> als = Arrays.asList(schTexts);
        ListAdapter listAdapter = new ArrayAdapter<StringBuilder>(this, R.layout.simple_list_item, als);

        ListView lv = (ListView) findViewById(R.id.ScheduleList);
        lv.setAdapter(listAdapter);

    }
}
