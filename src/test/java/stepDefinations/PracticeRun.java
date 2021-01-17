package stepDefinations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.internal.http.HttpResponseException;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.MovieContent;
import pojo.UpcomingMoviesPOJO;

public class PracticeRun {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://apiproxy.paytm.com/v2/movies/upcoming";

		UpcomingMoviesPOJO up = RestAssured.given().expect().defaultParser(Parser.JSON).when().get()
				.as(UpcomingMoviesPOJO.class);

		List<MovieContent> mc = up.getUpcomingMovieData();

		for (int i = 0; i < mc.size(); i++) {
			System.out.println(mc.get(i).getProvider_moviename());
		}

		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(cal.getTime()));

	}

}
