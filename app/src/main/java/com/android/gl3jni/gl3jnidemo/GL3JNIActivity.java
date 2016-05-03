package com.android.gl3jni.gl3jnidemo;

import android.app.Activity;
import android.os.Bundle;

public class GL3JNIActivity extends Activity {
    //GL3JNIView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GL3JNILib.runCommand("null");
        //mView = new GL3JNIView(getApplication());
        //setContentView(mView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //mView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mView.onResume();
    }


}
