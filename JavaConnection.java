package week3.homeassignment;

public class JavaConnection implements DatabaseConnection 
{
	public void connect()
	{
		System.out.println("This is method - Connect");		
	}

	public void disconnect() 
	{
		System.out.println("This is method - disconnect");	
	}

	public void executeUpdate() 
	{
		System.out.println("This is method - executeUpdate");	
	}
	
	public static void main(String[] args) 
	{
	JavaConnection a = new JavaConnection();
	a.connect();
	a.disconnect();
	a.executeUpdate();
	}
}
