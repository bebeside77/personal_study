package com.may.java.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.MappingJsonFactory;

public class JacksonStream {

	public static void main(String[] args) throws IOException {
		JsonFactory jsonFactory = new MappingJsonFactory();
		JsonParser jsonParser = jsonFactory.createParser(new File(""));

		AudioContent audioContent = new AudioContent(); // 맵핑할 객체

		while (jsonParser.nextToken() != JsonToken.END_OBJECT) { // '}'가 나올 때까지 토큰 순회
			String fieldName = jsonParser.getCurrentName(); // 필드명, 필드값 토큰인 경우 필드명, 나머지 토큰은 null 리턴

			if ("contentsId".equals(fieldName)) {
				jsonParser.nextToken();
				audioContent.setContentsId(jsonParser.getText());
			} else if ("title".equals(fieldName)) {
				jsonParser.nextToken();
				audioContent.setTitle(jsonParser.getText());
			} else if ("metadata".equals(fieldName)) {
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) { // ']'가 나올 때까지 토큰 순회
					Metadata metadata = parseMetadata(jsonParser);
					audioContent.getMetadata().add(metadata);
				}
			}
		}

		jsonParser.close();

		System.out.println(audioContent);
	}

	private static Metadata parseMetadata(JsonParser jsonParser) throws IOException {
		Metadata metadata = new Metadata();

		while (jsonParser.nextToken() != JsonToken.END_OBJECT) { // '}'가 나올 때까지 토큰 순회
			String metadataFieldName = jsonParser.getCurrentName();

			if ("propertyName".equals(metadataFieldName)) {
				jsonParser.nextToken();
				metadata.setPropertyName(jsonParser.getText());
			} else if ("propertyTitle".equals(metadataFieldName)) {
				jsonParser.nextToken();
				metadata.setPropertyTitle(jsonParser.getText());
			} else if ("propertyContent".equals(metadataFieldName)) {
				jsonParser.nextToken();
				metadata.setPropertyContent(jsonParser.getText());
			}
		}
		return metadata;
	}
}
