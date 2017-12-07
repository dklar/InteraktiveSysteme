package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientsData {
	private Date date;
	private Integer bloodPressureLow;
	private Integer bloodPressureHigh;
	private Integer pulse;
	private Integer weight;

	public PatientsData(Date date, Integer presL, Integer presH, Integer pulse, Integer weight) {
		this.date = date;
		this.bloodPressureLow = presL;
		this.bloodPressureHigh = presH;
		this.pulse = pulse;
		this.weight = weight;
	}
	
	
	public static PatientsData parseStringNewData(String string) {
		int k = 0;
		String[] tokens = string.split("[//]");
		Date date = new Date();
		Integer bloodPressureLow = new Integer(0), bloodPressureHigh = new Integer(0), 
				pulse = new Integer(0), weight = new Integer(0);
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
		for(String token : tokens){
			if(token.isEmpty()) {
				;	//nop
			} else {
				if(token.startsWith(":") && (k == 0 || k > 11)) {
					token = token.substring(1);
					k = 0;
				}
				switch(k) {
					case 0:
						try {
							date = dateParser.parse(token);
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 1: 
						bloodPressureLow = Integer.valueOf(token);
						break;
					case 2: 
						bloodPressureHigh = Integer.valueOf(token);
						break;
					case 3: 
						pulse = Integer.valueOf(token);
						break;
					case 4: 
						if(token.endsWith(":")) {
							weight = Integer.valueOf(token.replace(":", "")); 
							return new PatientsData(date, bloodPressureLow, bloodPressureHigh, 
									pulse, weight);
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
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getBloodPressureLow() {
		return bloodPressureLow;
	}


	public void setBloodPressureLow(Integer bloodPressureLow) {
		this.bloodPressureLow = bloodPressureLow;
	}


	public Integer getBloodPressureHigh() {
		return bloodPressureHigh;
	}


	public void setBloodPressureHigh(Integer bloodPressureHigh) {
		this.bloodPressureHigh = bloodPressureHigh;
	}


	public Integer getPulse() {
		return pulse;
	}


	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}


	public Integer getWeight() {
		return weight;
	}


	public void setWeight(Integer weight) {
		this.weight = weight;
	}


	
}
