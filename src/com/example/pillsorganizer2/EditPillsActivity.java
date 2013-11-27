package com.example.pillsorganizer2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.NumberPicker;
import com.example.pillsorganizer2.dao.Database;
import com.example.pillsorganizer2.dao.Pill;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trachuk
 * Date: 27.11.13
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class EditPillsActivity extends Activity {
    private Database db = Database.getInstance();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        NumberPicker np = (NumberPicker) findViewById(R.id.pilldose);
        np.setMaxValue(5);
        np.setMinValue(1);
        np.setValue(2);

        refreshList();
    }

    public void clearPills(View view){
         db.clearPills();
        refreshList();
    }

    public void addPill(View view){
        NumberPicker np = (NumberPicker) findViewById(R.id.pilldose);
        EditText ep = (EditText) findViewById(R.id.pillname);
        String name = ep.getText().toString();
        int dose = np.getValue();

        db.addPill(new Pill(name, dose));
        refreshList();
    }

    private void refreshList(){
        List<Pill> pills = db.getPills();
        //ListAdapter listAdapter = new ArrayAdapter<Pill>(this, R.layout.simple_list_item_1, pills);
    }
}