package koby.rotationcipher;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class RotationCipher extends Activity {
    /** Called when the activity is first created. */
	
	private Cipher _cipher = null;
	
	private EditText getEditTextObject() {
		return (EditText)findViewById(R.id.txtText);
	}
	
	private void SetRotationAmount(String selectedText) {
		
		if (selectedText == null || selectedText == "")
			return;			
		
		Log.i("print", selectedText);
		
		if( selectedText.equalsIgnoreCase("Rotation 10")) {
			_cipher = new Cipher(10);
		}
		else if(selectedText.equalsIgnoreCase("Rotation 11")) {
			_cipher = new Cipher(11);
		}
		else if( selectedText.equalsIgnoreCase("Rotation 12")) {
			_cipher = new Cipher(12);
		}
		else if( selectedText.equalsIgnoreCase("Rotation 13")) {
			_cipher = new Cipher(13);
		}
	}
	
	private void closeApp() {
		this.finish();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button encryptButton = (Button)findViewById(R.id.buttonEncrypt);
    	encryptButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				EditText textBox = getEditTextObject();
				textBox.setText(_cipher.Encrypt(textBox.getText().toString()));				
			}
		});
    	
    	Button decryptButton = (Button)findViewById(R.id.buttonDecrypt);
    	decryptButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				EditText textBox = getEditTextObject();
				textBox.setText(_cipher.Decrypt(textBox.getText().toString()));				
			}
		});
    	
    	Spinner rotationSpinner = (Spinner)findViewById(R.id.spinnerRotationAmount);
    	ArrayAdapter adapter = ArrayAdapter.createFromResource(
    			this, R.array.rotation_list, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	rotationSpinner.setAdapter(adapter);
    	
    	rotationSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				SetRotationAmount(arg0.getSelectedItem().toString());
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    	
    	Button closeButton = (Button)findViewById(R.id.buttonClose);
    	closeButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				closeApp();				
			}
		});
    }
}