package pojo;

public class User {
    private String name,tel,ID;
    private int num,id;
    private int order = 0,set = 0;//ID身份证，id预约编号，order中标之后还有几轮可以再预约，set本轮是否已经预约
    User(String name,String ID,String tel,int num,int id)
    {
        this.name = name;
        this.ID = ID;
        this.tel = tel;
        this.num = num;
        this.id = id;
        this.order = 1;
    }
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
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getOrder(){
        return order;
    }
    public void setOrder(){
        this.order = 3;
    }
    public int getSet(){
        return set;
    }
    public void setSet(){
        this.set = 0;
    }
}
