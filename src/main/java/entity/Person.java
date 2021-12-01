package entity;

public class Person extends FatherTest implements java.io.Serializable , Runnable {
	private int id;
	private String name;
	private String address;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	private Person(String name, String address, String message) {
		super();
		this.name = name;
		this.address = address;
		this.message = message;
		System.out.println("ͨ���вι���ʵ����Person�����ʵ��");
	}
	public Person() {
		super();
		System.out.println("ͨ���޲ι���ʵ����Person�����ʵ��");
	}
	
	@Override
	public String toString(){
		return "{name="+name+" address="+address+" message="+message+"}";
	}

	@Override
	public void run() {

	}
}
