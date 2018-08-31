package userbean;

public class userbean {
private String username;
private String password;
private int id;
private boolean isValid;

public boolean isValid() {
	return isValid;
}
public void setValid(boolean isValid) {
	this.isValid = isValid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}



}
