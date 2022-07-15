package P1.RestAssured_25_10_2021;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloads.payload;

public class Basics {

	@Test
	public static void getPutPost() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String resonse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.Addplace()).when().post("/maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(resonse);
		String placeID = js.getString("place_id");
		System.out.println(placeID);
		// Put API response
		String putResponse = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(payload.putApi(placeID)).when()
				.put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
		System.out.println(putResponse);

		String getAPI_Response = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
				.header("Content-Type", "application/json").when().get("/maps/api/place/get/json").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();

		System.out.println("Get response--> " + getAPI_Response);

		JsonPath js1 = new JsonPath(getAPI_Response);
		String expectedAddress = js1.getString("address");
		Assert.assertEquals(expectedAddress, "70 winter walk, USA");
		// 70 winter walk, USA

	}

}
