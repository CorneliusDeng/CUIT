package pluseg;

public class AreaInfo {
	private int id=0;		//行政区域ID
	private String area="";	//行政区域名
	private int parentId=0;	//上级行政区域ID
	private int level=0;	//行政区域类型  0/1/2 省/市/县
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
