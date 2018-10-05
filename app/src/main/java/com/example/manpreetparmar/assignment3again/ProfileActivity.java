package com.example.manpreetparmar.assignment3again;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    EditText editName;
    EditText editAge;
    EditText editID;
    Button save;


    protected SharedPreferenceHelper sharedPreferenceHelper;

    private boolean editAgeIsValid(){
        // Make sure the age is greater or equal to 18
        int i= Integer.parseInt(editAge.getText().toString());

       if(i < 18){
            Toast toast = Toast.makeText(getApplicationContext(), " Enter correct age between 18 and 99", Toast.LENGTH_LONG);
            toast.show();

            return false;
        }else{
            return true;
        }
    }

    public boolean saveProfileInfo() {

            String name = editName.getText().toString();
            String age = editAge.getText().toString();
            String id = editID.getText().toString();

            if(name.equals("")||age.equals("")||id.equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), " Please complete profile", Toast.LENGTH_LONG);
                toast.show();
                return false;

            }else{
                Profile profile = new Profile(name, age, id);
                sharedPreferenceHelper.saveProfile(profile);
                return true;
            }


            //Profile profile = new Profile(name, age, id);
            //sharedPreferenceHelper.saveProfile(profile);

    }

    public void SetEditProfileMode(boolean editMode) {
        if (editMode) {
            editName.setFocusableInTouchMode(true);
            editAge.setFocusableInTouchMode(true);
            editID.setFocusableInTouchMode(true);
            save.setVisibility(View.VISIBLE);

        } else{
            editName.setFocusable(false);
            editAge.setFocusable(false);
            editID.setFocusable(false);
    }

}
    //populate uneditable fields with profile info if there is one save
    public void DefaultMode() {

        Profile profile = sharedPreferenceHelper.getProfile();

        if (profile != null) {

            editName.setText(sharedPreferenceHelper.getProfileName());
            editAge.setText(sharedPreferenceHelper.getProfileAge());
            editID.setText(sharedPreferenceHelper.getProfileStudentID());

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //enable use to use up navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editName= (EditText) findViewById(R.id.editName);
        editAge=(EditText) findViewById(R.id.editAge);
        editID=(EditText) findViewById(R.id.editID);
        save= (Button)findViewById(R.id.save);
        sharedPreferenceHelper= new SharedPreferenceHelper(ProfileActivity.this);

        DefaultMode();
        SetEditProfileMode(false);


        //clicking the Save button
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if (saveProfileInfo()) {

                    if (editAgeIsValid()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG);
                        toast.show();
                        save.setVisibility(View.INVISIBLE);
                        SetEditProfileMode(false);
                    }
                }

            }
        });
    }

    //edit profile button in action bar
    //enable all profile fields
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.editProfile:
                SetEditProfileMode(true);
                break;
        }
        return true;
    }
}