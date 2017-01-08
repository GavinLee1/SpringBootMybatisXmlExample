package com.study.infrastructure.extension;

import java.io.*;
import java.net.URLConnection;

import org.springframework.web.multipart.MultipartFile;

public class Base64DecodedMultipartFile implements MultipartFile {

	private final byte[] fileContent;

	public Base64DecodedMultipartFile(byte[] imgContent) {
		this.fileContent = imgContent;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return fileContent;
	}

	@Override
	public String getContentType() {
		if (this.isEmpty()) {
			return null;
		}
		String mimeType = "unknown";
		InputStream stream = null;
		try {
			stream = new BufferedInputStream(new ByteArrayInputStream(fileContent));
			mimeType = URLConnection.guessContentTypeFromStream(stream);
		} catch (IOException e) {
			return mimeType;
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mimeType;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(fileContent);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getSize() {
		return fileContent.length;
	}

	@Override
	public boolean isEmpty() {
		return fileContent == null || fileContent.length == 0;
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		new FileOutputStream(dest).write(fileContent);

	}

}
