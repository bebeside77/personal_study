package com.may.java.json;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class JsonValidation {
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) throws IOException, ProcessingException {
		ClassPathResource jsonSchemaResource = new ClassPathResource("schema.json"); // schema 파일
		JsonNode schemaNode = objectMapper.readTree(jsonSchemaResource.getInputStream());

		ClassPathResource jsonResource = new ClassPathResource("sample.json"); // json 파일
		JsonNode jsonNode = objectMapper.readTree(jsonResource.getInputStream());

		JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		JsonSchema schema = factory.getJsonSchema(schemaNode);
		ProcessingReport report = schema.validate(jsonNode);

		if (report.isSuccess()) {
			System.out.println("json is valid.");
		} else {
			System.out.println("json is not valid.");
			System.out.println("report : " + report);
		}
	}
}
