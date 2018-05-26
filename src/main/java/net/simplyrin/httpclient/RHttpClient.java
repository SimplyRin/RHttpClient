package net.simplyrin.httpclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SimplyRin on 2018/05/26.
 *
 *  Copyright 2018 SimplyRin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class RHttpClient {

	private static boolean showLog = true;
	private static boolean showTime = true;

	public static String raw(String url) {
		return RHttpClient.raw(url, "Mozilla/5.0");
	}

	public static String raw(String link, String userAgent) {
		if(showLog) {
			System.out.println((showTime ? getTimePrefix() + " " : "") + "Connecting to " + link + ".");
		}
		try {
			URL url = new URL(link);
			HttpURLConnection  connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.addRequestProperty("User-Agent", userAgent);
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line, output = "";
			while((line = bufferedReader.readLine()) != null) {
				output += line + "\n";
			}
			return output;
		} catch (Exception e) {
		}

		return null;
	}

	public static void setShowLog(boolean showLog) {
		RHttpClient.showLog = showLog;
	}

	public static void setShowTime(boolean showTime) {
		RHttpClient.showTime = showTime;
	}

	private static String getTimePrefix() {
		SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss]");
		return sdf.format(new Date());
	}

}
