package com.android.gl3jni.gl3jnidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    //GL3JNIView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mView = new GL3JNIView(getApplication());
        setContentView(R.layout.activity_main);
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

    protected void fetchData(View view) {
        CopyRightLib.runCommand();
        System.out.println("fetchData finished");
    }

    protected void startApp(View view) {
        CopyRightLib.runCommand();
        System.out.println("startApp finished");
    }

}
