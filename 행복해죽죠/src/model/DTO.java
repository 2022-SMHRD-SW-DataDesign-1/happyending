package model;

public class DTO {
	private String  user_id;
	private String user_pw;
	private String user_name;
	private int age;
	private int level;
	private int rank;
	private int coin;
	private int score;
	private int ex;
	private String grade;
	private String start_day;
	private String last_day;
	
	public DTO(String user_id, String user_pw, String user_name, int age, int level, int rank, int coin, int ex,
			int score,String grade, String start_day, String last_day) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.age = age;
		this.level = level;
		this.rank = rank;
		this.coin = coin;
		this.score =score;
		this.ex = ex;
		this.grade = grade;
		this.start_day = start_day;
		this.last_day = last_day;
	}
	//회원가입용
	public DTO(String user_id,String user_pw,String user_name,int age,String start_day,String last_day) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.age = age;
		this.start_day = start_day;
		this.last_day = last_day;
	}
	//회원가입시 중복체크용
	public DTO(String user_id) {
		this.user_id = user_id;
	}
	//로그인용
	public DTO(String user_id,String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	//게임용
	public DTO(int coin,int score) {
		this.coin =coin;
		this.score = score;
	}
	
	
	public String getUser_id() {
		return user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public int getAge() {
		return age;
	}

	public int getLevel() {
		return level;
	}

	public int getRank() {
		return rank;
	}

	public int getCoin() {
		return coin;
	}

	public int getEx() {
		return ex;
	}

	public int getScore() {
		return score;
	}
	public String getGrade() {
		return grade;
	}

	public String getStart_day() {
		return start_day;
	}

	public String getLast_day() {
		return last_day;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setEx(int ex) {
		this.ex = ex;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}
	public void setLast_day(String last_day) {
		this.last_day = last_day;
	}
	
	
}
