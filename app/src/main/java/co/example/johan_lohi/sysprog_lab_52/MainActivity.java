package co.example.johan_lohi.sysprog_lab_52;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        String text = pref.getString("MyPref", null);
        editText.setText(text);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                SharedPreferences.Editor editor = pref.edit();
                editor.putString("MyPref", editText.getText().toString());
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
