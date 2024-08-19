
package api.endpoints;
/* URL -> https://petstore.swagger.io/
 * 
 * 
 * Post user ->  https://petstore.swagger.io/v2/user
 *Get user-> https://petstore.swagger.io/v2/user/{username}
 *update user -> https://petstore.swagger.io/v2/user/{username}
 *Delete user -> https://petstore.swagger.io/v2/user/{username}
 * 
 * 
 * 
 */


public class Routes {

	//		-----------USER MODEULE URL'S ------------

	

	public static String base_url="https://petstore.swagger.io/v2" ;
	
	//User module
	
	public static String postURL=base_url+"/user";
    public static String getURL=base_url+"/user/{username}";
    public static String updateURL=base_url+"/user/{username}";
    public static String deleteURL=base_url+"/user/{username}";
    
	



	//		-----------STORE MODEULE URL'S ------------

//	 KEEP ALL THE MODULE URL HERE 
	
}
