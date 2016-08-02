package com.robot.mykeyboard;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class KeyboardUtil {

	private KeyboardView keyboardView;
	private EditText editText;
	private Keyboard k1;// 字母键盘

	public KeyboardUtil(KeyboardView keyboardView1, EditText editText) {
		super();
		keyboardView = keyboardView1;
		this.editText = editText;
		keyboardView.setOnKeyboardActionListener(listener);
		k1 = new Keyboard(editText.getContext(), R.xml.qwerty);
		keyboardView.setKeyboard(k1);
		keyboardView.setEnabled(true);
		keyboardView.setPreviewEnabled(true);
	}

	private OnKeyboardActionListener listener = new OnKeyboardActionListener() {

		@Override
		public void swipeUp() {
		}

		@Override
		public void swipeRight() {
		}

		@Override
		public void swipeLeft() {
		}

		@Override
		public void swipeDown() {
		}

		@Override
		public void onText(CharSequence text) {
		}

		@Override
		public void onRelease(int primaryCode) {
		}

		@Override
		public void onPress(int primaryCode) {
		}

		@Override
		public void onKey(int primaryCode, int[] keyCodes) {
			Editable editable = editText.getText();
			int start = editText.getSelectionStart();
			switch (primaryCode) {
			case Keyboard.KEYCODE_DELETE:
				if (editable != null && editable.length() > 0) {
					if (start > 0) {
						editable.delete(start - 1, start);
					}
				}
				break;
			case Keyboard.KEYCODE_CANCEL:
				keyboardView.setVisibility(View.GONE);
				break;
			default:
				editable.insert(start, Character.toString((char) primaryCode));
				break;
			}
		}
	};

	// Activity中获取焦点时调用，显示出键盘
	public void showKeyboard() {
		int visibility = keyboardView.getVisibility();
		if (visibility == View.GONE || visibility == View.INVISIBLE) {
			keyboardView.setVisibility(View.VISIBLE);
		}
	}

}
