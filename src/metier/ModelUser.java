package metier;

import java.util.ArrayList;
import java.util.List;

public class ModelUser {
	private String motCle;
	private List<User>list = new ArrayList<>();
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	} 

}
