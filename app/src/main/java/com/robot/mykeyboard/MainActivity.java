package com.robot.mykeyboard;

import android.app.Activity;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editText;
	private KeyboardView keyboardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.editText);
		keyboardView = (KeyboardView) findViewById(R.id.keyboardView);
		editText.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(!editText.hasFocus()){
					int inputback = editText.getInputType();
					editText.setInputType(InputType.TYPE_NULL);
					new KeyboardUtil(keyboardView,editText).showKeyboard();
					editText.setInputType(inputback);
				}
				return false;
			}
		});
	}
}
