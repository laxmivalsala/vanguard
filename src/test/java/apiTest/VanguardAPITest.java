package apiTest;/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import models.RootProperty;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.when;

public class VanguardAPITest {
    public String baseUrl = "https://www.vanguardinvestments.com.au";
    public String resource_getNavPriceList = "/retail/mvc/getNavPriceList.jsonp";
    @Test
    public void validateResponseCode()
    {
        when().
                get(baseUrl+resource_getNavPriceList).
                then().
                statusCode(200); //Assert that status is 200
    }

    @Test
    public void validateResponseContentAndStructure()
    {
      JsonPath jsonPath= when().
                get(baseUrl+resource_getNavPriceList).
                then().
                statusCode(200)
              .extract()
              .body().jsonPath();

      //Map the whole JSON response to POJO
        List<RootProperty> rootProperties=null;
        try{
            rootProperties = jsonPath.getList("", RootProperty.class);
      }catch(Exception e)
      {
          //validate structure
         Assert.fail(e.getMessage());
      }
        List<Double> priceCompare = new ArrayList<>();

        for (RootProperty property: rootProperties )
        {
            String portId = property.portId;
            Double price = property.navPriceArray.get(0).price;
            priceCompare.add(price)  ;
            System.out.println(portId);
            System.out.println(price);
            System.out.println(property.navPriceArray.get(0).percentChange);
        }
        //find the highest of prices - assuming Price is NAV info in the response
        System.out.println("maximum "+Collections.max(priceCompare));



    }


}
