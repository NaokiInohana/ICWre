/*LoginBeanでは、LoginServletからの値を受け取る
 *BeanはDAOに値を渡し、DAOに対して検索を依頼する
 * 検索結果（有・無）を受けて
 */


package bean;

public class LoginBean {





	private String id;
	private String name;
	private String pass;



	public LoginBean(String id,String name,String pass){

		this.id = id;
		this.name = name;
		this.pass = pass;

	}

	public String getId(){return id;}
	public String getName(){return name;}
	public String getPass(){return pass;}

}
