package org.colorMine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.colorMine.colorSpace.Rgb;
import org.json.JSONException;
import org.json.JSONObject;

public class ServletOutput {

	public static void write(HttpServletResponse response, double data, String key) throws IOException {
		write(response, CreateJsonData(data, key));
	}

	public static void write(HttpServletResponse response, String data, String key) throws IOException {
		write(response, CreateJsonData(data, key));
	}

	private static JSONObject CreateJsonData(Object data, String key) throws IOException {
		try {
			JSONObject json = new JSONObject();
			json.put(key, data);

			return json;
		} catch (JSONException jsonException) {
			throw new IOException(jsonException.getMessage());
		}
	}

	public static void write(HttpServletResponse response, Map<Rgb, Integer> data) throws IOException {
		Map<String, String> stringData = convertToSerializable(data);
		JSONObject json = new JSONObject(stringData);
		write(response, json);
	}

	private static Map<String, String> convertToSerializable(Map<Rgb, Integer> data) {
		Map<String, String> output = new HashMap<String, String>();

		Iterator<Map.Entry<Rgb, Integer>> i = data.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry<Rgb, Integer> pairs = (Map.Entry<Rgb, Integer>) i.next();
			output.put(pairs.getKey().toString(), Integer.toString(pairs.getValue()));
		}
		return output;
	}

	private static void write(HttpServletResponse response, JSONObject json) throws IOException {
		writeAsJsonString(response, json.toString());
	}

	private static void writeAsJsonString(HttpServletResponse response, String output) throws IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(output);
	}

	public static void write(HttpServletResponse response, Collection<String> strings, String key) throws IOException {
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

}