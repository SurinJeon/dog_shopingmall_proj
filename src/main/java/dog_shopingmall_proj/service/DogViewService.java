package dog_shopingmall_proj.service;

import java.sql.Connection;
import java.sql.SQLException;

import dog_shopingmall_proj.dao.impl.DogDAOImpl;
import dog_shopingmall_proj.ds.JndiDS;
import dog_shopingmall_proj.dto.Dog;

public class DogViewService {
	Connection con = JndiDS.getConnection();
	DogDAOImpl dao = DogDAOImpl.getInstance();

	public Dog getDogView(int id) {
		Dog dog = null;
		try {
			con.setAutoCommit(false);
			dao.setCon(con);
			
			dao.updateReadCount(id);
			dog = dao.selectDog(id);
			
			JndiDS.commit(con);
		} catch (SQLException e) {
			JndiDS.rollback(con);
			e.printStackTrace();
		} 
		return dog;
	}
}
