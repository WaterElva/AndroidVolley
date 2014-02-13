/*
 * Created by Storm Zhang, Feb 11, 2014.
 */

package me.storm.volley.model;

public class ActivityInfo {
	public String title;
	public Class<?> name;

	public ActivityInfo(String title, Class<?> name) {
		this.title = title;
		this.name = name;
	}

	public String toString() {
		return title;
	}
}
