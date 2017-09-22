package a00972205.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConvertedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converted);

        Intent intent = getIntent();
        float base = intent.getFloatExtra("number", 0);
        String units = intent.getStringExtra("spinItem");
        EditText finalNum = (EditText) findViewById(R.id.finalNum);
        switch(units) {
            case "Hectares to Acres":
                finalNum.setText("" + (base * 2.47105));
                break;
            case "Acres to Hectares":
                finalNum.setText("" + (base * 0.404686));
                break;
            case "Hectares to Sqare Feet":
                finalNum.setText("" + (base * 107639));
                break;
            case "Square Feet to Hectares":
                finalNum.setText("" + (base * .0000092903));
                break;
            case "Square Meters to Square Feet":
                finalNum.setText(("" + base * 10.7639));
                break;
            case "Square Feet to Square Meters":
                finalNum.setText(("" + base * 0.092903));
                break;
        }


        Button btn = (Button)findViewById(R.id.back);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConvertedActivity.this, MainActivity.class));
            }
        });
    }
}
