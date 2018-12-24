package createdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.eclipse.rdf4j.model.impl.TreeModel;

import com.franz.agraph.repository.AGRepositoryConnection;

import entity.AEntity;
import setting.Config;

/**
 * Class sinh dữ liệu từ dữ liệu đọc ở file data
 */
public class DataCreator {
	private AGRepositoryConnection conn;
	private DataStoreder storeder = new DataStoreder(new TreeModel());
	
	private ArrayList<String>[] listEntity;
	private ArrayList<String>[] listDescription;
	private ArrayList<String>[][] listRelationship;
	
	private String[] str = Config.str;
	private HashMap<Integer, int[]> numberStr = Config.numberStr;
	private int numberRelationship, numberEntity;

	public DataCreator(AGRepositoryConnection conn, int numberEntity, int numberRelationship) {
		this.conn = conn;
		this.numberRelationship = numberRelationship;
		this.numberEntity = numberEntity;
		this.getListData();
	}

	/**
	 * Sinh các thực thể có trong tập EntityData Vòng for đầu để duyệt tất cả các
	 * thực thể như Person, Event ... Vòng for thứ hai duyệt tất cả dữ liệu đã đọc
	 * được của mỗi thực thể đang xét để sinh dữ liệu tương ứng. Mỗi dữ liệu sau khi
	 * sinh được đưa vào model. Khi model đủ 250000 triple sẽ đưa lên server
	 */
	public void createData() {
		SingleEntityCreator creator = new SingleEntityCreator();
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
		for (int count = 0; count < numberStr.get(numberEntity)[i]; count++) {
			String id = str[i] + count;
			String name = listEntity[i].get(rand.nextInt(listEntity[i].size()));
			String description = listDescription[i].get(rand.nextInt(listDescription[i].size()));
			AEntity newEntity = creator.createEntity(id, name, description);
			storeder.storeEntity(newEntity.getListProperties());
			if (storeder.getModel().size() > 250000) store_model();
		}
		store_model();
	}

	/**
	 * Tạo ngẫu nhiên quan hệ bằng cách chọn ngẫu nhiên các thực thể và liên kết 
	 * giữa chúng để tiến hành ghép nối
	 */
	public void createRelationship() {
		Random rand = new Random();
		int numberTripleEntity = (int) conn.size();
		if (numberRelationship + numberTripleEntity > 5000000) numberRelationship = 5000000 - numberTripleEntity; 
		int incomplete = numberRelationship;
		while (incomplete > 0) {
			
			// Chọn 2 loại thực thể để tiến hành ghép nối
			// Nếu không tồn tại liên kết giữa 2 thực thể thì bỏ qua
			int rand_1 = rand.nextInt(6);
			int rand_2 = rand.nextInt(6);
			if (listRelationship[rand_1][rand_2] == null) continue;
			
			// Chọn ngẫu nhiên thực thể trong các thực thể đã chọn để ghép nối
			// Chọn ngẫu nhiên relationship giữa 2 thực thể để ghép nối
			int ent_1 = rand.nextInt(numberStr.get(numberEntity)[rand_1]);
			int ent_2 = rand.nextInt(numberStr.get(numberEntity)[rand_2]);
			int rel_index = rand.nextInt(listRelationship[rand_1][rand_2].size());
			String id1 = str[rand_1] + ent_1;
			String id2 = str[rand_2] + ent_2;
			String rel = listRelationship[rand_1][rand_2].get(rel_index);
			storeder.storeRelationship(id1, rel, id2);
			
			// Kiểm tra nếu model vướt quá 50000 hoặc bằng số triple cần thêm thì add vào repository
			// Cập nhật lại số triple cần thêm
			if (storeder.getModel().size() >= 250000 || storeder.getModel().size() >= incomplete) {
				store_model();
				incomplete = numberRelationship + numberTripleEntity - (int) conn.size();
			}
		}
	}
	
	private void getListData() {
		DataReader reader = new DataReader();
		listEntity = reader.getListEntity();
		listDescription = reader.getListDescriptionData();
		listRelationship = reader.getListRelationshipData();
	}
	
        
	private void store_model() {
		conn.add(storeder.getModel());
		storeder.getModel().clear();
		
	}
}