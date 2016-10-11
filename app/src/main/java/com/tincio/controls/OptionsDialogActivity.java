package com.tincio.controls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OptionsDialogActivity extends AppCompatActivity {

    Button btnCustomDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_options);
        btnCustomDialog = (Button)findViewById(R.id.btn_custom_dialog);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    void showDialog(){
        try{
            DialogCustomFragment fragment = new DialogCustomFragment();
            fragment.show(getSupportFragmentManager(),"");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
