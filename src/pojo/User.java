package pojo;

public class User {
    private String name,tel,ID;
    private int num,Id;
    private int order,set;//ID身份证，id预约编号，order中标之后还有几轮可以再预约，set本轮是否已经预约
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num = num;
    }
    public int getOrder(){
        return order;
    }
    public void setOrder(){
        this.order = 3;
    }
    public int getSet(int set){
        return set;
    }
    public void setSet(){
        this.set = 1;
    }
	public int getId() {
		// TODO Auto-generated method stub
		return Id;
	}
	public void setId(int size) {
		// TODO Auto-generated method stub
		this.Id = size;
	}
}
