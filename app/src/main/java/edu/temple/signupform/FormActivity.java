package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView nameInput = findViewById(R.id.nameInput);
        final TextView emailInput = findViewById(R.id.emailInput);
        final TextView passwordInput = findViewById(R.id.passwordInput);
        final TextView confirmInput = findViewById(R.id.confirmInput);

        final List<TextView> fields = new ArrayList<>();
        fields.add(nameInput);
        fields.add(emailInput);
        fields.add(passwordInput);
        fields.add(confirmInput);

        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for(TextView f : fields)
                {
                    Log.d("btn", "Save button has been clicked");

                    //check that all fields are filled
                    if(f.getText().length() <= 0) {
                        Log.d("fields", "Not all fields are filled");
                        Toast.makeText(getApplicationContext(),
                                "Please complete all fields",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    String pass = passwordInput.getText().toString();
                    String conf = confirmInput.getText().toString();

                    //check if passwords match
                    if(!pass.equals(conf)){
                        Log.d("fields", "Passwords do not match");
                        Toast.makeText(getApplicationContext(),
                                "Passwords do not match",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //all the requirements are met
                    Log.d("btn", "All requirements met");

                    Toast.makeText(getApplicationContext(),
                            "Welcome, " + nameInput.getText() + "!",
                            Toast.LENGTH_LONG).show();

                }
            }
        });
    }


}