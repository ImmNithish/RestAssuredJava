package day4;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class SalesOrderFromNative {
	
  int SOnumber,nextSalesOrderToBe;
 String salesOrderNumber =null;
 String SonumberinString= null;
 
 
 
	@Test (priority = 1)
	public void getLastSalesOrderNumber() {
		
//		https://zakya.localzoho.com/posapi/api/v1/salesorders?page=1&usestate=true&organization_id=80059462
		Response response = 

				given()
					.queryParam("page", 1)
					.queryParam("usestate","true")
					.queryParam("organization_id",80059462)
					.queryParam("sort_column","created_time")
					.pathParam("salesorderFromWeb","salesorders")
					.header("Cookie","BuildCookie_80059462=1; BuildCookie_AssetType=modern; stk=99d8b1099f7fadc7e7a94b030b4a8ba4; _iamadt=c74b20af19dea16fb5fb8bdccbcbf78294954fe32e5c6df218514e3b3e1bb282ffb18dd52eb2b3d0ea872442e6460ad6a3a1b0c958f46d7431bf5e5a2a847eee; _iambdt=7558465d9b30c8f54d7b43414b999a276a69a515a283c0ac57e39bd852f429f623c2e7832594017d1600ddd1a793f040e5cd71f8013e63dc2cae95ee4c09fe7a; poscsrf=12b1c2153026b7603dd4f6daf91acb6b36e7d6d193952977442f47f7f099e1a7db025b52a2f0b7c902448d4945d63fc85745a83cc71394dd688a5c4a08ac42d2; wms-tkp-token=80059535-ed5b9d1a-dced3f4afef9ea08f5086192b3a07b5c; zoscscook=bb33599a2655411a816de5581c599053f2e960a2edf757f6b223fe4b1b8d73adde7901dfc97b8d58310d02e7628a6280dd19639f0768a590cacdcb794b146204; _zcsr_tmp=bb33599a2655411a816de5581c599053f2e960a2edf757f6b223fe4b1b8d73adde7901dfc97b8d58310d02e7628a6280dd19639f0768a590cacdcb794b146204; MU=2-60f56c1a571fbd5e07ec90cb6dee373d87551cfd218224f5; JSESSIONID=4F91DDB1C2E55ADA32CDBF385973D4A7")
					.header("X-ZCSRF-TOKEN","zoscsparam=bb33599a2655411a816de5581c599053f2e960a2edf757f6b223fe4b1b8d73adde7901dfc97b8d58310d02e7628a6280dd19639f0768a590cacdcb794b146204")
				.when()
					.get("https://zakya.localzoho.com/posapi/api/v1/{salesorderFromWeb}");
			

		
		Assert.assertEquals(response.getStatusCode(), 200);
		salesOrderNumber = response.jsonPath().getString("salesorders[0].salesorder_number");


		System.out.println("Last sales order number in the web: " + salesOrderNumber);
		
		SonumberinString = salesOrderNumber.replaceAll("[^0-9]", "");

		SOnumber = Integer.parseInt(SonumberinString);
		System.out.println("latest Sales order number without Prefix: " +SonumberinString );
//		nextSalesOrderToBe = SOnumber+1;
		
//		


	}
	
//		@Test ( priority = 2)	
	  public void postSalesOrder(ITestContext context) throws FileNotFoundException {
		
//		https://zakya.localzoho.com/api/retail/v1/sales?isPrintRequired=0&isBranchRestricted=true 
		
		
		
		File file = new File (".//sobody.json");
		FileReader reader = new FileReader(file);
		JSONTokener tk = new JSONTokener(reader);
		JSONObject obj = new JSONObject(tk);
	

		nextSalesOrderToBe = SOnumber+1;
		System.out.println(" new invoice number is :" +nextSalesOrderToBe);
		
		String SalesOrdernumbrToJson = String.valueOf(nextSalesOrderToBe);
		System.out.println(" new sales order number is :" +SalesOrdernumbrToJson);
//	    
	    String newCleintID = Invoice.appendCleintID(36);
	    String salesOrderPrefix = null;
		 String invoicePrefix=null;
	 
	    
	    
	    for(int i=0 ;i<obj.getJSONArray("sales").length();i++) {
	    	 JSONObject jsonArray = obj.getJSONArray("sales").getJSONObject(i);

	    	 jsonArray.put("invoiceNo",nextSalesOrderToBe).toString();
	    	 jsonArray.put("salesOrderNo",SalesOrdernumbrToJson).toString();
	    	 jsonArray.put("clientUID",newCleintID).toString();
	    	 salesOrderPrefix = jsonArray.get("orderPrefix").toString();
	    	 invoicePrefix= jsonArray.get("invoicePrefix").toString();
	    	 System.out.println("invoice from json:" + jsonArray.get("invoiceNo").toString());
	    }
	    System.out.println("SalesOrder number is:" +salesOrderPrefix+SalesOrdernumbrToJson);
	    System.out.println("Invoice number is:" +invoicePrefix+nextSalesOrderToBe);
	    System.out.println("Client Id is :" +newCleintID);
	    
//	     this is for test level 
//	    String BearerToken =(String) context.getAttribute("New_RefreshToken");  
//	    
//	    this is for suite level in xml
	
	    String BearerToken =(String) context.getSuite().getAttribute("New_RefreshToken");  
//	    
		given()
			.contentType("application/json")
			.queryParam("isPrintRequired", 0)
			.queryParam("isBranchRestricted", "true")
			.headers("Authorization","Bearer "+BearerToken)
//			change the bearer token it will valid for 1 hr 
			.body(obj.toString())
		
		.when()
			.post(" https://zakya.localzoho.com/api/retail/v1/sales ")
//			
		.then()
		.statusCode(201)
		.log().all();
		
		
		
	 
}

	
	

	
}
	
	
	
	