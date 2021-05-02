package dog_shopingmall_proj.service;

import java.sql.Connection;

import dog_shopingmall_proj.dao.impl.DogDAOImpl;
import dog_shopingmall_proj.ds.JndiDS;
import dog_shopingmall_proj.dto.Dog;

public class DogRegistService {
	DogDAOImpl dao = DogDAOImpl.getInstance();
	Connection con = JndiDS.getConnection();
	
	public DogRegistService() {
		dao.setCon(con);
	}

	public boolean registDog(Dog dog) {
		boolean isRegistSuccess = false;
		int insertCount = dao.insertDog(dog);

		if (insertCount > 0) {
			isRegistSuccess = true;
			return isRegistSuccess;
		} else {
			return isRegistSuccess;
		}

	}
	
}
