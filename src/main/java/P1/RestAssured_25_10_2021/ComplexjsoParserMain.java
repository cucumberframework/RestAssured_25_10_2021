package P1.RestAssured_25_10_2021;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payloads.ComplexjsoParser;

public class ComplexjsoParserMain {

	@Test
	public static void parseComplexJson() {

		JsonPath js = new JsonPath(ComplexjsoParser.complex());

		// print number oc courses
		int coursesSize = js.getInt("courses.size()");
		System.out.println(coursesSize);

		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		// title of first courese
		System.out.println(js.getString("courses[0].title"));

		// print all course title and respective prices

		for (int i = 0; i < coursesSize; i++) {

			System.out.println(js.get("courses[" + i + "].title"));
			System.out.println(js.getInt("courses[" + i + "].price"));
			System.out.println("-------------------");

			if (js.get("courses[" + i + "].title").equals("RPA")) {
				int price = js.getInt("courses[" + i + "].price");
				System.out.println("Price of the RPA course is --> " + price);
			}
		}

		// Verify purchase amount matches with the all course prices

		int purchaseAmount1 = js.getInt("dashboard.purchaseAmount");
		int totalCoursePrice = 0;
		for (int j = 0; j < js.getInt("courses.size()"); j++) {
			String courseName = js.getString("courses[" + j + "].title");
			System.out.println("Course Name and price and number of copies sold is as follows-->");
			System.out.println("Course Name--> " + courseName);
			int indCoursePrice = js.getInt("courses[" + j + "].price");
			int indCourseCopies = js.getInt("courses[" + j + "].copies");
			totalCoursePrice = totalCoursePrice + indCoursePrice * indCourseCopies;

		}
		if (totalCoursePrice == purchaseAmount1) {
			System.out.println("Total Amount is matching with sum of individual Course adition");
		}

	}
}
