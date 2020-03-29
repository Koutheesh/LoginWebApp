public class Student {
	String regno;
	String name;
	String pass;
	String dept;

	public Student(String regno, String name, String pass, String dept) {
		super();
		this.regno = regno;
		this.name = name;
		this.pass = pass;
		this.dept = dept;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
