#include <jni.h>
#include <stdio.h>
#include "HelloWorld.h"

/* shamelessly stolen from the book 'The Java Native Interface: Programmer's
   Guide and Specification' */
JNIEXPORT void JNICALL
Java_com_naver_spellingBot_HelloWorld_print (JNIEnv *env, jobject obj) {
    printf("Hello World!\n");
}
