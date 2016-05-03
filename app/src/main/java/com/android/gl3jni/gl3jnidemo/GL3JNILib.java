package com.android.gl3jni.gl3jnidemo;

/**
 * Created by strelchenkovadym on 4/23/16.
 */
public class GL3JNILib {
    static {
        System.loadLibrary("gl3jni");
    }

   //app/build/intermediates/classes/debug/com/android/gl3jni/gl3jnidemo

    public static native void init (int widht, int height);
    public static native void step();
    public static native void runCommand(String commandName);
}
