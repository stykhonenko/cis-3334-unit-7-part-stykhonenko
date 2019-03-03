package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    HeartRateList heartRateList;
    ArrayAdapter <HeartRate> hrAdapter;
    TextView tvSelect;
    ListView lvHeartRates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHeartRates = (ListView) findViewById(R.id.listViewHeartRate);
        tvSelect = (TextView) findViewById(R.id.textViewSelect);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.txtViewPulse, heartRateList);
        lvHeartRates.setAdapter(hrAdapter);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
                tvSelect.setText("You selected: " + hr.toString());
            }
        });
    }}