/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_jsfml_graphics_Font */

#ifndef _Included_org_jsfml_graphics_Font
#define _Included_org_jsfml_graphics_Font
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeCreate
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_jsfml_graphics_Font_nativeCreate
  (JNIEnv *, jobject);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeDelete
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jsfml_graphics_Font_nativeDelete
  (JNIEnv *, jobject);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeLoadFromMemory
 * Signature: ([B)J
 */
JNIEXPORT jlong JNICALL Java_org_jsfml_graphics_Font_nativeLoadFromMemory
  (JNIEnv *, jobject, jbyteArray);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeReleaseMemory
 * Signature: ([BJ)V
 */
JNIEXPORT void JNICALL Java_org_jsfml_graphics_Font_nativeReleaseMemory
  (JNIEnv *, jobject, jbyteArray, jlong);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeGetInfo
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_jsfml_graphics_Font_nativeGetInfo
  (JNIEnv *, jobject);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeGetTexture
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_org_jsfml_graphics_Font_nativeGetTexture
  (JNIEnv *, jobject, jint);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeGetLineSpacing
 * Signature: (I)F
 */
JNIEXPORT jfloat JNICALL Java_org_jsfml_graphics_Font_nativeGetLineSpacing
  (JNIEnv *, jobject, jint);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeGetUnderlinePosition
 * Signature: (I)F
 */
JNIEXPORT jfloat JNICALL Java_org_jsfml_graphics_Font_nativeGetUnderlinePosition
  (JNIEnv *, jobject, jint);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeGetUnderlineThickness
 * Signature: (I)F
 */
JNIEXPORT jfloat JNICALL Java_org_jsfml_graphics_Font_nativeGetUnderlineThickness
  (JNIEnv *, jobject, jint);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeGetGlyph
 * Signature: (IIZLjava/nio/Buffer;)V
 */
JNIEXPORT void JNICALL Java_org_jsfml_graphics_Font_nativeGetGlyph
  (JNIEnv *, jobject, jint, jint, jboolean, jobject);

/*
 * Class:     org_jsfml_graphics_Font
 * Method:    nativeGetKerning
 * Signature: (III)F
 */
JNIEXPORT jfloat JNICALL Java_org_jsfml_graphics_Font_nativeGetKerning
  (JNIEnv *, jobject, jint, jint, jint);

#ifdef __cplusplus
}
#endif
#endif
