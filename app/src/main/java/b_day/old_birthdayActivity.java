package b_day;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.adidroid.calculator.R;

public class old_birthdayActivity extends AppCompatActivity {
    EditText logInputText;
    TextView logOutputText;

    RecyclerView B_RecyclerView;
    LinearLayoutManager B_LayoutManager;
    B_Adapter b_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
//        logInputText = findViewById(R.id.editText);
//        logOutputText = findViewById(R.id.textView);


        //// new code ---

//        B_RecyclerView = findViewById(R.id.recycle_birthdate);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        B_RecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        B_LayoutManager = new LinearLayoutManager(this);
//        B_RecyclerView.setLayoutManager(B_LayoutManager);

//        b_adapter = new B_Adapter(CaptainsLogDb.getInstance(this).readCaptainsLog());
//        B_RecyclerView.setAdapter(b_adapter);

/*

        // Create the observer which updates the UI.
        final Observer<List<CaptainsLogEntity>> logObserver = new Observer<List<CaptainsLogEntity>>() {

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            // Create a calendar object that will convert the date and time value in milliseconds to date.
            Calendar calendar = Calendar.getInstance();
            StringBuilder sb = new StringBuilder();

            @Override
            public void onChanged(@Nullable final List<CaptainsLogEntity> newLog) {
                // Update the UI, in this case, a TextView.

                sb.setLength(0);
                for (CaptainsLogEntity cle : newLog) {
                    calendar.setTimeInMillis(cle.time);
                    sb.append(formatter.format(calendar.getTime()));
                    sb.append(": ");
                    sb.append(cle.log);
                    sb.append('\n');
                }

                logOutputText.setText(sb);
            }
        };

        LiveData<List<CaptainsLogEntity>> captainsLogEntityLiveData = CaptainsLogDb.getInstance(this).readCaptainsLog();

        captainsLogEntityLiveData.observe(this, logObserver);


        b_adapter = new B_Adapter(captainsLogEntityLiveData);
        B_RecyclerView.setAdapter(b_adapter);

*/

    }
    public void onClickedInset(View v){
        Intent intent = new Intent(getBaseContext(), insert_birthday.class);
        startActivity(intent);
    }
}
