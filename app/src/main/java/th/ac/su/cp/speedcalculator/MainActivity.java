package th.ac.su.cp.speedcalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text;
        TextView text2;
        Button calbutton = (Button) findViewById(R.id.cal_button);
        calbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView text = (TextView) findViewById(R.id.result_textview);
                final TextView text2 = (TextView) findViewById(R.id.sum_textView);
                final EditText distance = (EditText) findViewById(R.id.editTextNumberDecimal);
                final EditText time = (EditText) findViewById(R.id.editTextNumberDecimal2);
                String idDis = distance.getText().toString();
                String idTime = time.getText().toString();
                //int i = Integer.parseInt(idTime);
                //int ii = Integer.parseInt(idDis);
                double i = Double.parseDouble(idTime);
                double ii = Double.parseDouble(idDis);


                double sum=(ii*60*6)/(i*100);
                if(idDis.length()==0 || idTime.length()==0){
                 //   text.setText("Distance and Time are required.");
                   Toast t = Toast.makeText(MainActivity.this, "Distance and Time are required.",Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    if(i==0){
                    //    text.setText("Time must be greater than zero.");
                        Toast t = Toast.makeText(MainActivity.this, "Time must be greater than zero.",Toast.LENGTH_LONG);
                        t.show();
                    }
                    else{


                       // text2.setText(""+(ii*60*6)/(i*100));
                        String str = String.format(
                                Locale.getDefault(), "%.2f", sum
                        );
                        text2.setText(str);

                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        if((ii/i)>80){
                            dialog.setMessage(R.string.Speed);
                            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            dialog.show();
                        }
                        Button clearbutton = (Button) findViewById(R.id.clear_button);
                        clearbutton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                text.setText("");
                                text2.setText("");
                                distance.setText("");
                                time.setText("");
                            }
                        });


                    }

                }
            }
        });



    }
}
