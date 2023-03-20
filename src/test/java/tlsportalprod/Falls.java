package tlsportalprod;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Falls {

	String alertId = null;
	public static WebDriver driver=null;


	@Test
	public void  sfalls() throws InterruptedException {


		suspectedFall();


	}

	@Test
	public void  acceptalerts() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();



		driver.get("https://tls.app.tls.global/Account/Login");
		driver.manage().window().maximize();

		driver.findElement(By.id("Email")).sendKeys("Test1@evolve.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/div/input")).click();



		for(int i=1;i<=100;i++) {


			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
			Date date = new Date();
			String time =formatter.format(date);
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement acceptAlert;
			WebElement TextArea;
			WebElement resolved;
			acceptAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div[2]/div[1]/div[5]/div")));
			acceptAlert.click();
			TextArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/textarea")));
			TextArea.click();
			TextArea.sendKeys("Resolved Alert on: "+time);
			resolved = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div[2]/div[1]/div[2]/div[3]/div")));
			resolved.click();
			//driver.navigate().refresh();
		}
	}


	static public void realFall() {

		long timeStamp = System.currentTimeMillis();

		JSONObject jsonData = new JSONObject();

		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("presenceDetected", "true");
		jsonData.put("status", "calling");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("type", ""); 
		jsonData.put("timestampStr", ""); 
		jsonData.put("eventId", "");
		jsonData.put("deviceId", "id_MzA6QUU6QTQ6RTQ6MEQ6MDA");
		jsonData.put("battery", "72");
		jsonData.put("timestamp", timeStamp);


		RestAssured.baseURI = "https://liberate.servicebus.windows.net/vayyar-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate.servicebus.windows.net&sig=%2bgNoNfo%2fY3U6CwXF%2fUt%2fXJfbIuaxQxFeMZk9AG8oFS0%3d&se=1764669775&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString())
		.when().post().then().statusCode(201);

	}

	static public void suspectedFall() throws InterruptedException {

		int pair =1;

		do {

			fall_detected();
			Thread.sleep(40000);
			fall_exit();
			Thread.sleep(5000);
			pair++;

		} while (pair<6);

	}

	static public void fall_detected() {


		long timeStamp = System.currentTimeMillis();

		JSONObject jsonData = new JSONObject();

		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("presenceDetected", "true");
		jsonData.put("status", "fall_detected");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("type", ""); 
		jsonData.put("timestampStr", ""); 
		jsonData.put("eventId", "");
		jsonData.put("deviceId", "fall_4");
		jsonData.put("battery", "72");
		jsonData.put("timestamp", "0");


		RestAssured.baseURI = "https://liberate.servicebus.windows.net/vayyar-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate.servicebus.windows.net&sig=%2bgNoNfo%2fY3U6CwXF%2fUt%2fXJfbIuaxQxFeMZk9AG8oFS0%3d&se=1764669775&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString())
		.when().post().then().statusCode(201);
	}

	static public void fall_exit() {

		long timeStamp = System.currentTimeMillis();

		JSONObject jsonData = new JSONObject();

		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("presenceDetected", "true");
		jsonData.put("status", "fall_exit");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("type", ""); 
		jsonData.put("timestampStr", ""); 
		jsonData.put("eventId", "");
		jsonData.put("deviceId", "fall_4");
		jsonData.put("battery", "72");
		jsonData.put("timestamp", "0");


		RestAssured.baseURI = "https://liberate.servicebus.windows.net/vayyar-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate.servicebus.windows.net&sig=%2bgNoNfo%2fY3U6CwXF%2fUt%2fXJfbIuaxQxFeMZk9AG8oFS0%3d&se=1764669775&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString())
		.when().post().then().statusCode(201);

	}


}
