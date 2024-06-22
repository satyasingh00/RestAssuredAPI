package Restassured;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class Dummyjson { // using post ,this is for login and get token
	@Test (enabled = false)
	public void LoginandGetToken() {
		JSONObject js = new JSONObject();
		js.put("username","emilysusername")	;
		js.put("password","emilyspass")	;
		js.put("expiresInMins", "30");
		
		given().body(js.toJSONString()).when().post("https://dummyjson.com/auth/login").then().statusCode(200).log().all();
	
	}
	
	@Test (enabled = false) // using get ,this if for getallproducts
	public void Getallproducts() {
		given().get("https://dummyjson.com/products").then().statusCode(200).log().all();
	}
	
	@Test (enabled = false)
	public void GetasingleProduct() {
		given().get("https://dummyjson.com/products/1").then().statusCode(200).log().all();
		
	}
	
	@Test (enabled = false)
	public void SearchProduct() {
		given().get("https://dummyjson.com/products/search?q=phone").then().statusCode(200).log().all();
		
	}
	
	@Test (enabled = false)
	public void Limitandskipproducts() {
		given().get("https://dummyjson.com/products?limit=10&skip=10&select=title,price").then().statusCode(200).log().all();
		
	}
	@Test (enabled = false)
	public void Sortproducts() {
		given().get("https://dummyjson.com/products?sortBy=title&order=asc").then().statusCode(200).log().all();
		
	}
	@Test (enabled = false)
	public void Getallproductscategories() {
		given().get("https://dummyjson.com/products/categories").then().statusCode(200).log().all();
		
	}
	@Test (enabled = false)
	public void Getproductscategorylist() {
		given().get("https://dummyjson.com/products/category-list").then().statusCode(200).log().all();
		
	}
	@Test (enabled = false)
	public void Getproductsbyacategory() {
		given().get("https://dummyjson.com/products/category/smartphones").then().statusCode(200).log().all();
		
	}
	@Test (enabled = false)
	public void addanewaproduct() {
		JSONObject js = new JSONObject();
		js.put( "title","BMW Pencil");
		given().contentType("application/json").body(js.toJSONString()).when().post("https://dummyjson.com/products/add").then().statusCode(201).log().all();
		
	}
	@Test (enabled = false)
	public void Updateaproduct() {
		JSONObject js = new JSONObject();
		js.put( "title","iPhone Galaxy +1");
		given().contentType("application/json").body(js.toJSONString()).when().post("https://dummyjson.com/products/1").then().statusCode(404).log().all();
		
	}
	
	@Test (enabled = true)
	public void Deleteaproduct() {
		given().delete("https://dummyjson.com/products/1").then().statusCode(200).log().all();
		
	}

}
