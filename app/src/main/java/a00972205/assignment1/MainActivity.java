package a00972205.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.convert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editView = (EditText) findViewById(R.id.number);

                float    num      = parseFloat(editView.getText().toString()); //The float
                Spinner  spin     = (Spinner) findViewById(R.id.spinner);      //The Spinner object
                String   item     = spin.getSelectedItem().toString();         //The spin item string

                //Create the intent
                Intent   intent   =  new Intent(MainActivity.this, ConvertedActivity.class);

                //if(num)
                intent.putExtra("number", num);     //This stores the inputted float in the intent
                intent.putExtra ("spinItem", item); //This stores the spin item string in the intent

                startActivity(intent); //Redirects to ConvertedActivity
            }
        });
    }

}
