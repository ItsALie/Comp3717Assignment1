package a00972205.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConvertedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converted);

        Intent   intent   = getIntent(); //The intent from MainActivity
        float    base     = intent.getFloatExtra("number", 0); //Stores the float from user input
        String   units    = intent.getStringExtra("spinItem"); //Stores the spin item string
        String[] convUnit = getResources().getStringArray(R.array.conversion_units);

        EditText finalNum      = (EditText) findViewById(R.id.finalNum);      //The finalNum EditText item
        EditText orgNum        = (EditText) findViewById(R.id.originalNum);   //The orgNum EditText item
        TextView originalUnit  = (TextView) findViewById(R.id.originalUnit);  //The original units of conversion
        TextView convertedUnit = (TextView) findViewById(R.id.convertedUnit); //The new units of conversion

        orgNum.setText("" + base);//Displays the original number inputted

        //Sets the text in the EditText according to selected spinner item
        switch(units) {
            case "" :
                finalNum.setText("" + (base * 2.47105));
                originalUnit.setText(R.string.Hectares);
                convertedUnit.setText(R.string.Acres);
                break;
            case "Acres to Hectares":
                finalNum.setText("" + (base * 0.404686));
                originalUnit.setText(R.string.Acres);
                convertedUnit.setText(R.string.Hectares);
                break;
            case "Hectares to Square Feet":
                finalNum.setText("" + (base * 107639));
                originalUnit.setText(R.string.Hectares);
                convertedUnit.setText(R.string.SquareFeet);
                break;
            case "Square Feet to Hectares":
                finalNum.setText("" + (base * .0000092903));
                originalUnit.setText(R.string.SquareFeet);
                convertedUnit.setText(R.string.Hectares);
                break;
            case "Square Meters to Square Feet":
                finalNum.setText(("" + base * 10.7639));
                originalUnit.setText(R.string.SquareMeter);
                convertedUnit.setText(R.string.SquareFeet);
                break;
            case "Square Feet to Square Meters":
                finalNum.setText(("" + base * 0.092903));
                originalUnit.setText(R.string.SquareFeet);
                convertedUnit.setText(R.string.SquareMeter);
                break;
        }

        Button btn = (Button)findViewById(R.id.back); //Back button

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConvertedActivity.this, MainActivity.class));
            }
        });
    }
}
