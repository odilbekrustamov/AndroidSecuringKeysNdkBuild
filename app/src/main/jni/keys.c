#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_exsample_androidsecuringkeysndkbuild_MainActivity_getPublicKey(JNIEnv *env, jobject instance) {
    return (*env)->  NewStringUTF(env, "long_public_key");
}
JNIEXPORT jstring JNICALL
Java_com_exsample_androidsecuringkeysndkbuild_MainActivity_getPrivateKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "long_private_key");
}