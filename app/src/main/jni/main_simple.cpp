//
// Created by Strelchenko Vadym on 4/23/16.
//

//header for JNI
#include <jni.h>

//header for the OpenGL ES3 library
#include <GLES3/gl3.h>

#include <android/log.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string>
#include <vector>

//android error log interface
#define  LOG_TAG    "libgl3jni"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

const char* getAppPath(std::string package) {
    static const char FIRST_DELIMITER = ':';
    static const char SECOND_DELIMITER = '=';

    for (int i = 0; i < package.size(); i++) {
        if (package[i] == FIRST_DELIMITER) {
            package.erase(0, i + 1);
            break;
        }
    }

    for (int i = 0; i < package.size(); i++) {
        if (package[i] == SECOND_DELIMITER) {
            package.erase(i, package.size());
        }
    }

    return package.c_str();
}

extern "C" {
  JNIEXPORT void JNICALL Java_com_android_gl3jni_gl3jnidemo_CopyRightLib_runCommand (JNIEnv *, jclass);
};

JNIEXPORT void JNICALL Java_com_android_gl3jni_gl3jnidemo_CopyRightLib_runCommand (JNIEnv * env, jclass clazz) {
    FILE* in;
    const int NUM_CHARACTERS_TO_READ = 10000;
    char result[NUM_CHARACTERS_TO_READ];
    std::vector<std::string> pmResults;

    if ( ! (in = popen("pm list packages -f", "r")) ) {
        return;
    }
    while (fgets(result, NUM_CHARACTERS_TO_READ, in) != NULL) {

        pmResults.push_back(getAppPath(result));
    }
    pclose(in);

    //find the needed app

    for (int i = 0; i < pmResults.size(); i++) {
        if ( ! (in = popen(("stat " + pmResults[i]).c_str(), "r")) ) {
            return;
        }
        while (fgets(result, NUM_CHARACTERS_TO_READ, in) != NULL) {
            LOGI("\"%s\"", result);
         }
         LOGI("\n=========================================\n");
    }
    pclose(in);
}

