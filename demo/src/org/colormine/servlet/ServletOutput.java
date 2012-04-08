package org.colormine.servlet;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.colormine.image.profile.Profile;
import org.json.JSONException;
import org.json.JSONObject;

public class ServletOutput {

	static void write(HttpServletResponse response, double data, String key) throws IOException {
		write(response, createJsonData(data, key));
	}

	static void write(HttpServletResponse response, String data, String key) throws IOException {
		write(response, createJsonData(data, key));
	}

	static void write(HttpServletResponse response, Map<Color, Integer> data) throws IOException {
		Map<String, String> stringData = convertToSerializable(data);
		JSONObject json = new JSONObject(stringData);
		write(response, json);
	}

	static void write(HttpServletResponse response, Profile<Color> profile) throws IOException {
		write(response, profile);
	}

	static void write(HttpServletResponse response, Color color, String key) throws IOException {
		String colorString = colorToHex(color);
		JSONObject json = createJsonData(colorString, key);
		write(response, json);
	}

	static void write(HttpServletResponse response, Collection<String> strings, String key) throws IOException {
		try {

			JSONObject json = new JSONObject();

			for (String data : strings) {
				json.append(key, data);
			}

			write(response, json);

		} catch (JSONException jsonException) {
			throw new IOException(jsonException.getMessage());
		}
	}

	static String colorToHex(Color color) {
		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}

	private static void write(HttpServletResponse response, JSONObject json) throws IOException {
		writeAsJsonString(response, json.toString());
	}

	private static void writeAsJsonString(HttpServletResponse response, String output) throws IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(output);
	}

	private static JSONObject createJsonData(Object data, String key) throws IOException {
		try {
			JSONObject json = new JSONObject();
			json.put(key, data);

			return json;
		} catch (JSONException jsonException) {
			throw new IOException(jsonException.getMessage());
		}
	}

	private static Map<String, String> convertToSerializable(Map<Color, Integer> data) {
		Map<String, String> output = new HashMap<String, String>();

		Iterator<Map.Entry<Color, Integer>> i = data.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry<Color, Integer> pairs = (Map.Entry<Color, Integer>) i.next();
			output.put(colorToHex(pairs.getKey()), Integer.toString(pairs.getValue()));
		}
		return output;
	}

}