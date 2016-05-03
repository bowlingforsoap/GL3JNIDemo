package com.android.gl3jni.gl3jnidemo;

import android.app.Application;
import android.content.Context;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * A simple application that uses OpenGL ES3 and GLSurface
 */
public class GL3JNIView extends GLSurfaceView {
    public GL3JNIView(Context context) {
        super(context);

        /* Pick an EGLConfig with RGB8 color, 16-bit depth, no stencil, supporting OpenGL ES 3.0 or later */
        setEGLConfigChooser(8, 8, 8, 0, 16, 0);
        setEGLContextClientVersion(3);
        setRenderer(new Renderer());
    }

    private class Renderer implements GLSurfaceView.Renderer {

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GL3JNILib.step();
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GL3JNILib.init(width, height);
        }

        @Override
        public void onDrawFrame(GL10 gl) {

        }
    }
}
