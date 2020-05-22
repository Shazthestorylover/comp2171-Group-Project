package model;

import java.util.ArrayList;

import GUI.DBConnect;

public class fitnessController {
	
	private Client newClient = null;
	private Member currentUser = null;
	private ArrayList<Client> clients;
	private static fitnessController firstInstance = null;
	private DBConnect DB = null;
	private boolean DBaccess = false;
	
	private fitnessController() {
		DB = DBConnect.getInstance("vainfitness", "root", "");
		
		if(DB != null) {
		DB.loadClientList();
		clients = DB.getClientList();
		DBaccess = true;
		showClientList();
		}
		
	}
	
	
	public static fitnessController getInstance() {
		if (firstInstance == null) {
			firstInstance = new fitnessController ();
			
		}
		
		return firstInstance;
	}
	
	
	
	public void createClientProfile(String UserType,String Firstname,String Lastname,String Contact, String Email, double Height, String Gender, int Day, int Month, int Year, String Address) {
		newClient = new Client(UserType,new PersonalInfo(Firstname,Lastname,Contact,Email),new Profile(Height,Gender,Year,Month,Day,Address));
		currentUser = newClient;
	}
	
	public void createClientProfile(String UserType,String Firstname,String Lastname,String Contact, String Email, double Height, String Gender, int Day, int Month, int Year, String Address, Double DailyGoal, int CarbsPercentage, int ProteinPercentage, int FatPercentage) {
		newClient = new Client(UserType,new PersonalInfo(Firstname,Lastname,Contact,Email),new Profile(Height,Gender,Year,Month,Day,Address,new NutritionGoal(DailyGoal, CarbsPercentage, ProteinPercentage, FatPercentage)));
		currentUser = newClient;
	}
	
	public void createClientProfile(String UserType,String Firstname,String Lastname,String Contact, String Email,double Height, String Gender, int Day, int Month, int Year, String Address,double InitialWeight, double CurrentWeight, double GoalWeight) {
		newClient = new Client(UserType,new PersonalInfo(Firstname,Lastname,Contact,Email),new Profile(Height,Gender,Year,Month,Day,Address, new WeightGoal(InitialWeight, CurrentWeight, GoalWeight)));
		currentUser = newClient;
	}
	
	public void createClientProfile(String UserType,String Firstname,String Lastname,String Contact, String Email, double Height, String Gender, int Day, int Month, int Year, String Address, Double DailyGoal, int CarbsPercentage, int ProteinPercentage, int FatPercentage,double InitialWeight, double CurrentWeight, double GoalWeight) {
		newClient = new Client(UserType,new PersonalInfo(Firstname,Lastname,Contact,Email),new Profile(Height,Gender,Year,Month,Day,Address,new NutritionGoal(DailyGoal, CarbsPercentage, ProteinPercentage, FatPercentage), new WeightGoal(InitialWeight, CurrentWeight, GoalWeight)));
		currentUser = newClient;
	}
	
	
	public void createClientProfile(String UserType,String Username, String Password,String Firstname,String Lastname,String Contact, String Email, double Height, String Gender, int Day, int Month, int Year, String Address, Double DailyGoal, int CarbsPercentage, int ProteinPercentage, int FatPercentage,double InitialWeight, double CurrentWeight, double GoalWeight) {
		newClient = new Client(UserType,new PersonalInfo(Firstname,Lastname,Contact,Email),new Profile(Height,Gender,Year,Month,Day,Address,new NutritionGoal(DailyGoal, CarbsPercentage, ProteinPercentage, FatPercentage), new WeightGoal(InitialWeight, CurrentWeight, GoalWeight)));
		currentUser = newClient;
	}
	
	
	
	public String getClientInfo() {
		
		return newClient.toString();
		
	}
	
	public boolean checkCurrentUser() {
		
		if( currentUser != null) {
			return true;
		}
		
		return false;
	
	}
	
	public String getClientUsername() {
		
		return currentUser.getUsername();
	}
	
	public void showClientList() {
		if(DBaccess) {
			
			clients.forEach((c -> System.out.println(c.getId() +"\n" + c.getUsername())));
			
		}else {
			System.out.println("Sorry Database down at the moment. Please try again later");
		}
	}
	
}
