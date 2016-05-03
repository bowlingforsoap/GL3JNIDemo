package com.android.gl3jni.gl3jnidemo;

/**
 * Created by strelchenkovadym on 4/23/16.
 */
public class CopyRightLib {
    static {
        System.loadLibrary("gl3jni");
    }

   //app/build/intermediates/classes/debug/com/android/gl3jni/gl3jnidemo
    public static native void runCommand();
}
