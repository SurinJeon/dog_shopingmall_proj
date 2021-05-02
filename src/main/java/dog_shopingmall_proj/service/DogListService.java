package dog_shopingmall_proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import dog_shopingmall_proj.dao.impl.DogDAOImpl;
import dog_shopingmall_proj.ds.JndiDS;
import dog_shopingmall_proj.dto.Dog;

public class DogListService {
	DogDAOImpl dao = DogDAOImpl.getInstance();
	Connection con = JndiDS.getConnection();
	
	public DogListService() {
		dao.setCon(con);
	}
	
	public ArrayList<Dog> getDogList(){
		return dao.selectDogList();
	}
	
}
