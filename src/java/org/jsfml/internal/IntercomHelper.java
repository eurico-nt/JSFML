package org.jsfml.internal;

import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import java.nio.*;

/**
 * Provides functionality to encode and decode data structures used
 * for intercom methods.
 */
public final class IntercomHelper {
    private static final ThreadLocal<ByteBuffer> BUFFER =
            new ThreadLocal<ByteBuffer>() {
                @Override
                protected ByteBuffer initialValue() {
                    return ByteBuffer.allocateDirect(256).order(ByteOrder.nativeOrder());
                }
            };

    /**
     * Gets the current thread-local buffer.
     *
     * @return the current thread-local buffer.
     */
    public static Buffer getBuffer() {
        return BUFFER.get();
    }

    /**
     * Gets the current thread-local buffer as an integer buffer.
     *
     * @return the current thread-local buffer.
     */
    public static IntBuffer getIntBuffer() {
        return BUFFER.get().asIntBuffer();
    }

    /**
     * Encodes a color into a 32-bit integer.
     *
     * @param color the color to encode.
     * @return the encoded color.
     */
    public static int encodeColor(Color color) {
        return (color.a << 24) | (color.b << 16) | (color.g << 8) | color.r;
    }

    /**
     * Decodes a color from a 32-bit integer.
     *
     * @param code the encoded color.
     * @return the decoded color.
     */
    public static Color decodeColor(int code) {
        final int a = (code >> 24) & 0xFF;
        final int b = (code >> 16) & 0xFF;
        final int g = (code >> 8) & 0xFF;
        final int r = code & 0xFF;
        return new Color(r, g, b, a);
    }

    /**
     * Decodes an integer vector from a 64-bit integer.
     *
     * @param vec the encoded vector.
     * @return the decoded vector.
     */
    public static Vector2i decodeVector2i(long vec) {
        if (vec == 0) {
            return Vector2i.ZERO;
        } else {
            return new Vector2i((int) vec, (int) (vec >> 32));
        }
    }

    /**
     * Decodes a float vector from a 64-bit integer.
     *
     * @param vec the encoded vector.
     * @return the decoded vector.
     */
    public static Vector2f decodeVector2f(long vec) {
        return new Vector2f(
                Float.intBitsToFloat((int) vec),
                Float.intBitsToFloat((int) (vec >> 32)));
    }

    /**
     * Encodes an integer rectangle into the current integer buffer.
     *
     * @param r the rectangle to encode.
     * @return A reference to the integer buffer.
     */
    public static Buffer encodeIntRect(IntRect r) {
        final IntBuffer buf = BUFFER.get().asIntBuffer();
        buf.put(0, r.left);
        buf.put(1, r.top);
        buf.put(2, r.width);
        buf.put(3, r.height);
        return buf;
    }

    /**
     * Decodes an float rectangle from the current float buffer content.
     *
     * @return the decoded rectangle.
     */
    public static FloatRect decodeFloatRect() {
        final FloatBuffer buf = BUFFER.get().asFloatBuffer();
        return new FloatRect(
                buf.get(0),
                buf.get(1),
                buf.get(2),
                buf.get(3));
    }

    /**
     * Encodes a float rectangle into the current float buffer.
     *
     * @param r the float to encode.
     * @return A reference to the float buffer.
     */
    public static Buffer encodeFloatRect(FloatRect r) {
        final FloatBuffer buf = BUFFER.get().asFloatBuffer();
        buf.put(0, r.left);
        buf.put(1, r.top);
        buf.put(2, r.width);
        buf.put(3, r.height);
        return buf;
    }

    /**
     * Decodes a transformation matrix from the current float buffer content.
     *
     * @return the decoded transformation matrix.
     */
    public static Transform decodeTransform() {
        final FloatBuffer buf = BUFFER.get().asFloatBuffer();
        return new Transform(
                buf.get(0),
                buf.get(1),
                buf.get(2),
                buf.get(3),
                buf.get(4),
                buf.get(5),
                buf.get(6),
                buf.get(7),
                buf.get(8)
        );
    }

    /**
     * Decodes a glyph from the current buffer content.
     *
     * @return the decoded glyph.
     */
    public static Glyph decodeGlyph() {
        final IntBuffer buf = BUFFER.get().asIntBuffer();
        return new Glyph(
                buf.get(0),
                new IntRect(buf.get(1), buf.get(2), buf.get(3), buf.get(4)),
                new IntRect(buf.get(5), buf.get(6), buf.get(7), buf.get(8)));
    }

    private IntercomHelper() {
    }
}