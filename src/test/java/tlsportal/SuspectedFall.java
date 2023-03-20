package tlsportal;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.ANTLRParser.sync_return;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SuspectedFall {



	@Test
	public void falls() throws InterruptedException {

		realFall();
		suspectedFall();




	}




	static public void realFall() {



		JSONObject jsonData = new JSONObject();

		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("type", "");
		jsonData.put("timestampStr", "");
		jsonData.put("eventId", "");
		jsonData.put("deviceId", "fall_remote1");
		jsonData.put("presenceDetected", "");
		jsonData.put("status", "calling");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("timestamp", "0"); 
		jsonData.put("confidenceLevel", "0.0");
		jsonData.put("SuspectedEventsCounter", "0");
		jsonData.put("lastEventConfidence", "0.0");

		RestAssured.baseURI = "https://liberate-staging.servicebus.windows.net/vayyar-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString())
		.when().post().then().statusCode(201);

	}




	static public void suspectedFall() throws InterruptedException {
		JSONObject jsonData = new JSONObject();



		int i=1;
		do {
			long timeStamp = System.currentTimeMillis();
			jsonData.put("endTimestamp", "0");
			jsonData.put("isLearning", "false");
			jsonData.put("isSimulated", "false");
			jsonData.put("type", "");
			jsonData.put("timestampStr", "");
			jsonData.put("eventId", "");
			jsonData.put("deviceId", "fall_remote1");
			jsonData.put("presenceDetected", "");
			jsonData.put("status", "fall_suspected");
			jsonData.put("statusUpdateTimestamp", "0");
			jsonData.put("timestamp", timeStamp); 
			jsonData.put("confidenceLevel", "0.0");
			jsonData.put("SuspectedEventsCounter", i);
			jsonData.put("lastEventConfidence", "0.81");

			RestAssured.baseURI = "https://liberate-staging.servicebus.windows.net/vayyar-events/messages";
			RestAssured.given().header("Content-Type","application/json");
			RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
			.contentType(ContentType.JSON).body(jsonData.toJSONString())
			.when().post().then().statusCode(201);
			i++;
			//Thread.sleep(2000);
		}while(i<6);
		suspected_calling();
	}


	static public void suspected_calling() {

		long timeStamp = System.currentTimeMillis();
		JSONObject jsonData = new JSONObject();

		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("type", "");
		jsonData.put("timestampStr", "");
		jsonData.put("eventId", "");
		jsonData.put("deviceId", "fall_remote1");
		jsonData.put("presenceDetected", "");
		jsonData.put("status", "calling");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("timestamp", timeStamp); 
		jsonData.put("confidenceLevel", "0.0");
		jsonData.put("SuspectedEventsCounter", "0");
		jsonData.put("lastEventConfidence", "0.0");

		RestAssured.baseURI = "https://liberate-staging.servicebus.windows.net/vayyar-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString())
		.when().post().then().statusCode(201);

	}

}
