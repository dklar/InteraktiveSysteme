package classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
//import java.util.LinkedList;

public class Patient {
	private String firstName;
	private String lastName;
	private EnumGender gender;
	private String healthInsurance;
	private String street;
	private String city;
	private String zip;
	private String state;
	private Float initialHeight;
	private Float initialWeight;
	private Date admDate;
//	private LinkedList<String> afflictions;
	private String afflictions;
	private HashMap<Date, PatientsData> data;
	
	
	public Patient (String firstName, 
			String lastName,
			EnumGender gender,
			String healthInsurance,
			String street,
			String city,
			String zip,
			String state,
			Float initialHeight,
			Float initialWeight,
			Date admDate,
			String afflictions) 
	{	this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.healthInsurance = healthInsurance;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.initialHeight = initialHeight;
		this.initialWeight = initialWeight;
		this.admDate = admDate;
//		this.afflictions = new LinkedList<>();
//		this.addAfflictionsFromString(afflictions);
		this.afflictions = afflictions;
		this.data = new HashMap<>();
	}
	
//	public void addAfflictionsFromString(String afflictions) {
//		
//	}
	
	public void addRecord(Date date, Integer presL, Integer presH, Integer pulse, Integer weight) {
		this.data.put(date, new PatientsData(date, presL, presH, pulse, weight));
	}
	
	public static Patient parseStringNewPatients(String string) {
		int i = 0;
		int k = 0;
		String[] tokens = string.split("[//]");
		String firstName = "", lastName = "", healthInsurance = "", street = "", city = "",
				zip = "", state = "", afflictions = "";
		EnumGender gender = EnumGender.FEMALE;
		Float initialHeight = new Float(0), initialWeight = new Float(0);
		Date admDate = new Date();
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
		for(String token : tokens){
			System.out.println(token);
			if(token.isEmpty()) {
				;	//nop
			} else {
				if(token.startsWith(":") && (k == 0 || k > 11)) {
					token = token.substring(1);
					k = 0;
				}
				switch(k) {
					case 0: 
						lastName = token;
						break;
					case 1: 
						firstName = token;
						break;
					case 2: 
						if(token.equals("f")){
							gender = EnumGender.FEMALE;
						} else {
							gender = EnumGender.MALE;
						}
						break;
					case 3: 
						healthInsurance = token;
						break;
					case 4: 
						street = token;
						break;	
					case 5: 
						city = token;
						break;
					case 6: 
						zip = token;
						break;
					case 7: 
						state = token;
						break;
					case 8: 
						initialHeight = Float.parseFloat(token);
						break;
					case 9: 
						initialWeight = Float.parseFloat(token);
						break;
					case 10: 
						try {
							admDate = dateParser.parse(token);
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 11: 
						if(token.endsWith(":")) {
							afflictions = token.replace(":", "");
							return new Patient(firstName, lastName, gender, healthInsurance,
											street, city, zip, state, initialHeight, 
											initialWeight, admDate, afflictions);
						} else {
							System.out.println("Wrong line format");
						}
						break;
					default:
						System.out.println("Wrong line format");
				}
				k++;
			}
		}
		return null;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EnumGender getGender() {
		return gender;
	}

	public void setGender(EnumGender gender) {
		this.gender = gender;
	}

	public String getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(String healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Float getInitialHeight() {
		return initialHeight;
	}

	public void setInitialHeight(Float initialHeight) {
		this.initialHeight = initialHeight;
	}

	public Float getInitialWeight() {
		return initialWeight;
	}

	public void setInitialWeight(Float initialWeight) {
		this.initialWeight = initialWeight;
	}

	public Date getAdmDate() {
		return admDate;
	}

	public void setAdmDate(Date admDate) {
		this.admDate = admDate;
	}

	public String getAfflictions() {
		return afflictions;
	}

	public void setAfflictions(String afflictions) {
		this.afflictions = afflictions;
	}

	public HashMap<Date, PatientsData> getData() {
		return data;
	}

	public void setData(HashMap<Date, PatientsData> data) {
		this.data = data;
	}

}
