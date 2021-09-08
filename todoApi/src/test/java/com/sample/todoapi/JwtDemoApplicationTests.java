package com.sample.todoapi;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import my.sample.todoapi.dto.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JwtDemoApplicationTests {

	@LocalServerPort
	int randomServerPort;

	public JwtDemoApplicationTests() {
	}

	@Test
	public void contextLoads() {
	}

   @Test
	public void testGetAllTodoListSuccess() throws URISyntaxException, IOException {
	RestTemplate restTemplate = new RestTemplate();
	final String baseUrl = "http://localhost:" + randomServerPort + "/todos";
	URI uri = new URI(baseUrl);
	ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	//Verify if request successful for all Todo list
        Assert.assertEquals(200, result.getStatusCodeValue());
        System.out.println("result" + result.getBody());
        Assert.assertEquals(true, result.getBody().contains("Take over the galaxy"));
		Assert.assertEquals(true, result.getBody().contains("wahhh"));
//Convert response to csv
	ObjectMapper mapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	Response resp = mapper.readValue(result.getBody(), Response.class);
    Todo todo = resp.getEmbedded().todos.get(0);
    JsonNode jsonTree = new ObjectMapper().readTree(String.valueOf(resp));
	CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
	JsonNode firstObject = jsonTree.elements().next();
	firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
	CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
	CsvMapper csvMapper = new CsvMapper();
		csvMapper.writerFor(JsonNode.class)
				.with(csvSchema)
				.writeValue(new File("src/main/resources/todoList.csv"), jsonTree);
}
}
