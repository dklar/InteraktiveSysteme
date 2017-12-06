package classes;

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
}
