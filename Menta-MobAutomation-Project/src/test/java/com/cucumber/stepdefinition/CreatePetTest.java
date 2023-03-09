package com.cucumber.stepdefinition;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class CreatePetTest {

	@Test
	public void getPetDetails() {
	
	    RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";        
        String response = given()          
        		.header("Content-Type","application/json")    // Q-2 --> validate content type is application/json	    
        		.when()
        		.get("/12345")
        		.then()
        		.log().all()
        		.assertThat().statusCode(200)   // Q-1 --> validate status code as 200
        		.extract().response().asString();
        
        JsonPath js = new JsonPath(response);
        String petName = js.getString("category.name");
        System.out.println("Actual pet name from response : "+petName);       
        Assert.assertEquals(petName, "dog");  // Q-3 --> validate petname as dog
        
        String name = js.getString("name");
        System.out.println("Actual name from response : "+name);
        Assert.assertEquals(name, "snoopie"); // Q-4 --> validate name as snoopie
        
        String sts = js.getString("status");
        System.out.println("Actual status from response : "+sts);
        Assert.assertEquals(sts, "pending");  // Q-5 --> validate status as pending
	}
}
