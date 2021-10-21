package c.poly;

class MongoDB implements Connection{

	@Override
	public void connect() {
		System.out.println("몽고 디비 연결");
	}
}

class OracleDB implements Connection{

	@Override
	public void connect() {
		System.out.println("오라클 디비 연결");
	}
}

class MySQLDB implements Connection{

	@Override
	public void connect() {
		System.out.println("MySQL 디비 연결");
	}
}

public class JavaApplication {
	
	public static void dbConnection(Connection conn) {
		conn.connect();
	}

	public static void main(String[] args) {
		dbConnection(new OracleDB());
		dbConnection(new MongoDB());
		dbConnection(new MySQLDB());
		//인터페이스의 다형성
	}

}
