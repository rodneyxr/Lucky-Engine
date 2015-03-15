package com.rodneyxr.luckyengine.tools;

public class Vector2 {

	private static final Vector2 ZERO = new Vector2(0f, 0f);
	private static final Vector2 ONE = new Vector2(1f, 1f);

	public float x, y;

	public Vector2() {
		this(0f, 0f);
	}

	public Vector2(float x, float y) {
		set(x, y);
	}

	public Vector2 set(Vector2 v) {
		set(v.x, v.y);
		return this;
	}

	public Vector2 set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector2 add(Vector2 v) {
		x += v.x;
		y += v.y;
		return this;
	}

	public Vector2 add(float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2 scale(float scale) {
		x *= scale;
		y *= scale;
		return this;
	}

	public Vector2 scale(float scaleX, float scaleY) {
		x *= scaleX;
		y *= scaleY;
		return this;
	}

	public Vector2 normalize() {
		float magnitude = magnitude();
		if (magnitude != 0f) {
			x /= magnitude;
			y /= magnitude;
		}
		return this;
	}

	public Vector2 normalized() {
		return clone().normalize();
	}

	public float magnitude() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public float distance(Vector2 v) {
		float dx = v.x - x;
		float dy = v.y - y;
		return (float) Math.sqrt(dx * dx + dy * dy);
	}

	public static float distance(Vector2 v1, Vector2 v2) {
		float dx = v1.x - v2.x;
		float dy = v1.y - v2.y;
		return (float) Math.sqrt(dx * dx + dy * dy);
	}

	public static Vector2 zero() {
		return ZERO.clone();
	}

	public static Vector2 one() {
		return ONE.clone();
	}

	@Override
	public Vector2 clone() {
		return new Vector2(x, y);
	}

	@Override
	public String toString() {
		return String.format("Vector2: { x = %.02f, y = %.02f }", x, y);
	}

}
