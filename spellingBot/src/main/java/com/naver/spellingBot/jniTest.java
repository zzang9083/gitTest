package com.naver.spellingBot;

public class jniTest
{
        public static native String Mul(String a,int b);

        static{
        System.loadLibrary("jniTest");
        }

}


