package com.cursor.restLibrary;

import com.cursor.restLibrary.controllers.AuthorController;
import okhttp3.*;
import okio.BufferedSink;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RestLibraryApplicationTests {
	final String BASE_URL = "http://localhost:9000/";
	public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");
	OkHttpClient client = new OkHttpClient();

	@Test
	public void contextLoads() {

	}
	@Test
	public void tryGetRequest() throws IOException {
		Request req = new Request.Builder().url(BASE_URL+"author/1").get().build();
		Response res = client.newCall(req).execute();
		System.out.println( res.body().string());
	}

	@Test
	public void tryPostRequest() throws IOException{
		String body = "{\"id\":17, \"title\":\"KNIZHKINEIGRUSHKI\"}";

		RequestBody requestBody =  RequestBody.create(JSON, body);
		Request req = new Request.Builder().url(BASE_URL+"book/add").post(requestBody).build();
		Response res = client.newCall(req).execute();
		System.out.println(res);
	}
}
