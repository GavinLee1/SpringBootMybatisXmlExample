package com.study.infrastructure.extension;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public abstract class HttpRequestUtility {
	public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
		if (request == null) {
			return null;
		}
		/* 当无请求参数时，request.getContentLength()返回-1 */
		int contentLength = request.getContentLength();
		if (contentLength < 0) {
			return null;
		}
		byte[] buffer = new byte[contentLength];
		for (int i = 0; i < contentLength;) {
			int readLength = request.getInputStream().read(buffer, i, contentLength - i);
			if (readLength == -1) {
				break;
			}
			i += readLength;
		}
		return buffer;
	}

	public static String getRequestPostStr(HttpServletRequest request) throws IOException {
		if (request == null) {
			return null;
		}
		byte[] buffer = getRequestPostBytes(request);
		String charEncoding = request.getCharacterEncoding();
		if (charEncoding == null) {
			charEncoding = "UTF-8";
		}
		String data = (buffer == null) ? null : new String(buffer, charEncoding);
		return data;
	}

	public static String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		if (ip == null) {
			ip = request.getRemoteHost();
		}
		return null;
	}

	public static String getFileExtensionByContentType(String contentType) {
		String extension = "";
		switch (contentType) {
		case "image/pjpeg":
			extension = "jpg";
			break;
		case "image/jpeg":
			extension = "jpg";
			break;
		case "image/gif":
			extension = "gif";
			break;
		case "image/png":
			extension = "png";
			break;
		case "video/mp4":
			extension = "mp4";
			break;
		default:
			break;
		}
		return extension;
	}

	public static String getUrl(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		String scheme = request.getScheme(); // http
		String serverName = request.getServerName(); // hostName.com
		int serverPort = request.getServerPort(); // 80
		String contextPath = request.getContextPath(); // /mywebapp
		String servletPath = request.getServletPath(); // /servlet/MyServlet
		String pathInfo = request.getPathInfo(); // a/b;c=123
		String queryString = request.getQueryString(); // d=789

		// Reconstruct the original url
		StringBuilder url = new StringBuilder();

		url.append(scheme).append("://").append(serverName);

		if (serverPort != 80 && serverPort != 443) {
			url.append(":").append(serverPort);
		}

		url.append(contextPath).append(servletPath);

		if (pathInfo != null) {
			url.append(pathInfo);
		}

		if (queryString != null) {
			url.append("?").append(queryString);
		}
		return url.toString();
	}
}
