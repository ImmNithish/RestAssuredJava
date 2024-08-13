package day3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.LogSpecification;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class day33 {
	
	String cookie,headerName, header=null;
	
	
	
	@Test(priority = 1)
	public RequestSpecification requestSpec() {
		
		
		RequestLogSpecification requestLog = RestAssured.given().auth().basic("", "").log();

		cookie ="BuildCookie_80059462=1; BuildCookie_AssetType=modern; stk=99d8b1099f7fadc7e7a94b030b4a8ba4; _iamadt=c74b20af19dea16fb5fb8bdccbcbf78294954fe32e5c6df218514e3b3e1bb282ffb18dd52eb2b3d0ea872442e6460ad6a3a1b0c958f46d7431bf5e5a2a847eee; _iambdt=7558465d9b30c8f54d7b43414b999a276a69a515a283c0ac57e39bd852f429f623c2e7832594017d1600ddd1a793f040e5cd71f8013e63dc2cae95ee4c09fe7a; poscsrf=12b1c2153026b7603dd4f6daf91acb6b36e7d6d193952977442f47f7f099e1a7db025b52a2f0b7c902448d4945d63fc85745a83cc71394dd688a5c4a08ac42d2; wms-tkp-token=80059535-ed5b9d1a-dced3f4afef9ea08f5086192b3a07b5c; zoscscook=bb33599a2655411a816de5581c599053f2e960a2edf757f6b223fe4b1b8d73adde7901dfc97b8d58310d02e7628a6280dd19639f0768a590cacdcb794b146204; _zcsr_tmp=bb33599a2655411a816de5581c599053f2e960a2edf757f6b223fe4b1b8d73adde7901dfc97b8d58310d02e7628a6280dd19639f0768a590cacdcb794b146204; MU=2-60f56c1a571fbd5e07ec90cb6dee373d87551cfd218224f5; JSESSIONID=4F91DDB1C2E55ADA32CDBF385973D4A7" ;

		header = "zoscsparam=bb33599a2655411a816de5581c599053f2e960a2edf757f6b223fe4b1b8d73adde7901dfc97b8d58310d02e7628a6280dd19639f0768a590cacdcb794b146204";

		headerName = "X-ZCSRF-TOKEN";
	return 	requestLog.all().contentType(ContentType.JSON);

//		return requestLog.all().contentType(getContentType());
		
		
		
	}

	
	
	@Test( priority = 2)
	public void sample() {
		
		Response response = requestSpec().cookie(cookie).headers(headerName,header).get("https://zakya.localzoho.com/posapi/api/v1/{salesorderFromWeb}");
		
	}
}
