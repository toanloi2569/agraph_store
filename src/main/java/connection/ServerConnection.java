package connection;

import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGServer;
import setting.Config;

/**
 * Kết nối với server theo server, repository, user, password đã cho trước. Nếu
 * chưa tồn tại repository sẽ tự động tạo repository
 */
public class ServerConnection {
	private String serverURL, user, password;
	private AGServer server;
	private AGCatalog catalog;
	private AGRepository myRepository;
	private AGRepositoryConnection conn;
	private static ServerConnection serverConnection;

	// Constructor
	private ServerConnection(String severURL, String user, String password) {
		this.serverURL = severURL;
		this.user = user;
		this.password = password;
		this.server = new AGServer(this.serverURL, this.user, this.password);
		this.catalog = this.server.getRootCatalog();
	}

	// Constructor
	private ServerConnection() {
		this.serverURL = Config.SERVER_URL;
		this.user = Config.USERNAME;
		this.password = Config.PASSWORD;
		this.server = new AGServer(Config.SERVER_URL, Config.USERNAME, Config.PASSWORD);
		this.catalog = this.server.getRootCatalog();
	}

	/**
	 * Tạo một kết nối với repository tương ứng nhập vào. Nếu repository này chưa tồn tại,
	 * tự động tạo 1 repository có tên tương ứng và trả ra kết nối
	 * @param repositoryID Tên của repository muốn kết nối
	 * @return Đối tượng databaseConnecter dùng để kết nối với repository vừa nhập
	 */
	public static ServerConnection getDatabaseConnecter(String ServerURL, String user, String password) {
		if (serverConnection == null) {
			serverConnection = new ServerConnection(ServerURL, user, password);
		} 
		if (!ServerURL.equals(serverConnection.serverURL) || !user.equals(serverConnection.user) ||
				!password.equals(serverConnection.password)) {
			serverConnection.server.close();
			serverConnection = new ServerConnection(ServerURL, user, password);
		}
		return serverConnection;
	}

	/**
	 * Kết nối với sever. Nếu chưa tồn tại repository sẽ tự động tạo repository mới.
	 * Tạo kết nối với repository.
	 */
	public AGRepositoryConnection getConnection (String repositoryName) {
		if (!catalog.hasRepository(repositoryName)) {
			createRepository(repositoryName);
		}
		else {
			myRepository = catalog.openRepository(repositoryName);
			conn = myRepository.getConnection();
		}
		return conn;
	}
 
	/**
	 * Đặt mới lại repository. Dùng để tạo nhiều repository ứng với nhiều bộ truy vấn.
	 * Nếu repository đã tồn tại thì sẽ xóa repository cũ và ghi đè repository mới
	 * @param repositoryName : Tên repository
	 */
	public void createRepository(String repositoryName) {
		serverConnection.closeConnection();
		if (catalog.hasRepository(repositoryName))
			catalog.deleteRepository(repositoryName);
		myRepository = catalog.createRepository(repositoryName);
		myRepository.setDuplicateSuppressionPolicy("spo");
		myRepository.initialize();
		conn = myRepository.getConnection();
		conn.setNamespace("class", Config.CLASS_PREFIX);
		conn.setNamespace("ent", Config.ENTITY_PREFIX);
		conn.setNamespace("prs", Config.PROPERTIES_PREFIX);
		conn.setNamespace("rel", Config.RELATIONSHIP_PREFIX);
	}

	/**
         * Thoát khỏi phiên làm việc, đồng thời đóng repository
         */
	public void closeConnection() {
		if (conn == null) return;
		conn.close();
		myRepository.shutDown();
	}
}