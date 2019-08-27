package com.example.call;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	private EditText txtPhone;
	private Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtPhone = (EditText) this.findViewById(R.id.editText);
        this.btnCall = (Button) this.findViewById(R.id.button);
        
        this.btnCall.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// get phone entered by the user
		String phone = this.txtPhone.getText().toString();
		// parse the phone enter to URI
		Uri phoneUri = Uri.parse("tel:" +phone);
		// prepare action call intent
		Intent callIntent = new Intent(Intent.ACTION_CALL, phoneUri);
		// start calling
		this.startActivity(callIntent);
	}
}
