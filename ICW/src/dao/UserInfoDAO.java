/*
 * UserinfoDAOでは、データベースベースを利用する処理を担当してもらう。DBへは必ずDAOを介して行う。（DAOパターンという）
 * （テーブルに対する検索、追加、更新、消去）
 * メリット・・・データベースを利用するクラスからJDBCコードが減り見通しがよくなる、データベースに関する仕様変更に対応しやすくなる
 * データベースに知識がない人もクラスでデータベースが使えるようになる
*/

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInfoDAO {
	//////////// DBの資格情報/////////////////////
	private String url = "jdbc:db2://dashdb-entry-yp-dal09-08.services.dal.bluemix.net:50001/BLUDB";
	private String user = "dash13336";
	private String pass_DB = "Yk__Tfq7DsY3";

	public void DBconn() {

		/////////////////// ここでDBに繋ぐ処理を行っている想定/////////////////////////////////
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass_DB);
			///////////////////////////////////////////////////////////////////////////////

			//// ステートメントを作成・・(問い合わせを実行したり、問い合わせの結果の取得に関するベースになるもの)
			Statement stmt = conn.createStatement();

			//// 文字列sqlに対してsql文を書いている
			String sql = "SELECT * FROM USERINFO";

			/*
			 * executeQueryメソッド(問い合わせを実行するメソッド)を実行、つまりSELECTを実行し、結果表を取得
			 * 結果を「ResultSet」インターフェースのオブジェクト（ここではrs）として取得（引数にはSQL文が書かれた文字列（
			 * ここではsql） を指定）
			 */
			ResultSet rs = stmt.executeQuery(sql);

			  while(rs.next()){
				    String ACCOUNT_ID = rs.getString("ACCOUNT_ID");
				    String PASSWORD = rs.getString("PASSWORD");
				    System.out.println("ID:" + ACCOUNT_ID + ", パスワード:" + PASSWORD);

				  }
			 // return rs.getString(1);

			//////////////////////
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		}

	}
}
