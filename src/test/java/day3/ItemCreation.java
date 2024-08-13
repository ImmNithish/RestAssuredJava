package day3;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class ItemCreation {

	@Test
	public void createItem() {
		try {

			String AccesToken = "1000.328c9c903123aa4e9c037a152d944ad4.c7a5735f10e6fbcc70b63ea5d6b0af43";
			String ITEM_CREATEBODY = "{\"name\":\"jam\",\"rate\":\"100\",\"account_id\":\"225445000000000388\",\"tax_id\":\"\",\"custom_fields\":[],\"purchase_rate\":\"50\",\"purchase_account_id\":\"225445000000035003\",\"item_type\":\"inventory\",\"is_taxable\":\"true\",\"product_type\":\"goods\",\"inventory_account_id\":\"225445000000126362\",\"item_tax_preferences\":[],\"is_returnable\":true,\"package_details\":{\"weight_unit\":\"kg\",\"dimension_unit\":\"cm\"},\"warehouses\":[{\"warehouse_id\":\"225445000000128061\",\"initial_stock\":\"100\",\"initial_stock_rate\":\"50\"}],\"unit\":\"pcs\",\"taxability_type\":\"none\"}";

			for (int i = 0; i < 5000; i++) {
				JSONObject obj = new JSONObject(ITEM_CREATEBODY);
				String itemName = "jam-" + generaterandomletters(7);
				System.out.println("count :" + i);
				obj.put("name", itemName);
				System.out.println(itemName);

				// Convert the JSONObject back to a string
				String modifiedJsonString = obj.toString();

				Response response = given()

						.headers("x-zcsrf-token",
								"zoscsparam=76f22816ce4856f6572a6d1f9bc28c6f3c8d6798b6a874008d0d9aa102b780bc27329e400186d4bd2c990060d672aa14d47ad835bd67648f341985fe0eb3f226")
						.cookie("_iamadt",
								"bc2796970f52a5879798a759edb9b2c0e1bb5c724e08459e7bef7188060688407b97b18e6b9f4006d4f676e2862ba63d748463d7af7006030c1a07960f408899")
						.cookie("_iambdt",
								"3e39d12457289a76f225042463bbf4de85270f8aa72873ab7024b98a412f1bcae56c55e5636d0b045b106da647e71cefd72e9850f3369e8aa4aed1efc92dfb3d")
						.cookie("poscsrf",
								"065e5552558e48accbb06fb8c50888d392f86b77da21194c5eab2261c67c145efc4140260ae5214c73ee26c915877c289e22398ca9bf790256b628d7ba85ed46")
						
						  .cookie("zalb_953b9f76e7","8c821b8d4ac60731eba644e292798ac4")
						  .cookie("zoscscook",
						  "76f22816ce4856f6572a6d1f9bc28c6f3c8d6798b6a874008d0d9aa102b780bc27329e400186d4bd2c990060d672aa14d47ad835bd67648f341985fe0eb3f226")
						  .cookie("_zcsr_tmp",
						  "76f22816ce4856f6572a6d1f9bc28c6f3c8d6798b6a874008d0d9aa102b780bc27329e400186d4bd2c990060d672aa14d47ad835bd67648f341985fe0eb3f226")
						  .cookie("wms-tkp-token","88806213-2b896898-6ef2a3694633fc6bc357d12bf4c643fb")
						  .cookie("MU","2-bec9a76003a26bab692028b233cc7233318fde6c950d2d25")
						  
						
						.body(modifiedJsonString)

						.when().post("https://zakya.localzoho.com/posapi/api/v1/items?organization_id=88888798");

				System.out.println("Status code: " + response.getStatusCode());
				System.out.println("Result : " + response.jsonPath().getString("message"));

				if (response.getStatusCode() != 201)
					break;
				// System.out.println(" Response body :" + response.asPrettyString());

				Thread.sleep(1000);

			}
		} catch (Exception e) {
			System.out.println("Exception  is:  " + e);

		}

	}

	protected static String generaterandomletters(int length) {
		String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
		String append = null;
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			append = String.valueOf(sb.append(CHARACTERS.charAt(randomIndex)));
			//
		}
		return append;
	}
}
