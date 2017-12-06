package forms;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
//import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Text;
//import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Spinner;

import classes.EnumGender;
import classes.Patient;

public class NewPatientDialog extends Dialog {
	private Text textLastName;
	private Text textFirstName;
	private Text textHealthInsurance;
	private Text textStreet;
	private Text textCity;
	private Text textState;
	private Text textZip;
	private Text textAfflictions;
	private DateTime dateTime;
	private Button btnMale;
	private Button btnFemale;
	private Spinner spinnerWeight;
	private Spinner spinnerHeight;
	private Composite container;
	private HashMap<String, Patient> medicalData;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public NewPatientDialog(Shell parentShell, HashMap<String, Patient> medicalData) {
		super(parentShell);
		this.medicalData = medicalData;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		container = (Composite) super.createDialogArea(parent);
		container.setLayout(new RowLayout(SWT.VERTICAL));
		
		Composite primaryData = new Composite(container, SWT.NONE);
		primaryData.setLayoutData(new RowData(440, 119));
		
		Label lblNewLabel = new Label(primaryData, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 63, 15);
		lblNewLabel.setText("Last Name");
		textLastName = new Text(primaryData, SWT.BORDER);
		textLastName.setBounds(119, 7, 76, 21);
		
		Label lblFirstName = new Label(primaryData, SWT.NONE);
		lblFirstName.setBounds(10, 43, 63, 15);
		lblFirstName.setText("First name");
		textFirstName = new Text(primaryData, SWT.BORDER);
		textFirstName.setBounds(119, 34, 76, 21);
		
		Group grpGender = new Group(primaryData, SWT.NONE);
		grpGender.setText("Gender");
		grpGender.setBounds(231, 10, 199, 48);
		
		btnMale = new Button(grpGender, SWT.RADIO);
		btnMale.setBounds(10, 22, 90, 16);
		btnMale.setText("Male");
		
		btnFemale = new Button(grpGender, SWT.RADIO);
		btnFemale.setBounds(106, 22, 90, 16);
		btnFemale.setText("Female");
		
		Label label = new Label(primaryData, SWT.NONE);
		label.setText("Health Insurance");
		label.setBounds(10, 70, 96, 15);
		textHealthInsurance = new Text(primaryData, SWT.BORDER);
		textHealthInsurance.setBounds(119, 64, 76, 21);
		
		Composite adressData = new Composite(container, SWT.NONE);
		adressData.setLayoutData(new RowData(437, 100));
		
		Label lblStreet = new Label(adressData, SWT.NONE);
		lblStreet.setBounds(10, 10, 55, 15);
		lblStreet.setText("Street");
		textStreet = new Text(adressData, SWT.BORDER);
		textStreet.setBounds(78, 7, 349, 21);
		
		Label lblCity = new Label(adressData, SWT.NONE);
		lblCity.setBounds(10, 34, 55, 15);
		lblCity.setText("City");
		textCity = new Text(adressData, SWT.BORDER);
		textCity.setBounds(78, 31, 349, 21);
		
		Label lblState = new Label(adressData, SWT.NONE);
		lblState.setBounds(10, 61, 55, 15);
		lblState.setText("State");
		textState = new Text(adressData, SWT.BORDER);
		textState.setBounds(78, 58, 160, 21);
		
		Label lblZip = new Label(adressData, SWT.NONE);
		lblZip.setBounds(253, 61, 33, 15);
		lblZip.setText("ZIP");
		textZip = new Text(adressData, SWT.BORDER);
		textZip.setBounds(292, 58, 135, 21);
		
		Composite healthData = new Composite(container, SWT.NONE);
		healthData.setLayoutData(new RowData(434, 134));
		
		Label lblDateOf = new Label(healthData, SWT.NONE);
		lblDateOf.setBounds(10, 10, 103, 15);
		lblDateOf.setText("Date of admission");
		
		Label lblAfflictions = new Label(healthData, SWT.NONE);
		lblAfflictions.setBounds(307, 10, 55, 15);
		lblAfflictions.setText("Afflictions");
		textAfflictions = new Text(healthData, SWT.BORDER | SWT.V_SCROLL);
		textAfflictions.setBounds(201, 31, 223, 93);
		
		dateTime = new DateTime(healthData, SWT.BORDER);
		dateTime.setBounds(119, 10, 76, 24);
		
		Label lblMass = new Label(healthData, SWT.NONE);
		lblMass.setBounds(10, 53, 55, 15);
		lblMass.setText("Weight");
		spinnerWeight = new Spinner(healthData, SWT.BORDER);
		spinnerWeight.setBounds(119, 53, 47, 22);
		
		Label lblHeight = new Label(healthData, SWT.NONE);
		lblHeight.setBounds(10, 82, 55, 15);
		lblHeight.setText("Height");
		spinnerHeight = new Spinner(healthData, SWT.BORDER);
		spinnerHeight.setBounds(119, 82, 47, 22);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
	}
	
	@Override
	protected void okPressed() {
		if(!textLastName.getText().isEmpty() &&
				!textFirstName.getText().isEmpty() &&
				!textHealthInsurance.getText().isEmpty() &&
				!textStreet.getText().isEmpty() &&
				!textCity.getText().isEmpty() &&
				!textZip.getText().isEmpty() &&
				!textState.getText().isEmpty() &&
				(btnFemale.getSelection() || btnMale.getSelection()) &&
				!spinnerHeight.getText().isEmpty() &&
				!spinnerWeight.getText().isEmpty() &&
				dateTime.getDay() != 0) {
			EnumGender gender;
			if(btnFemale.getSelection()) {
				gender = EnumGender.FEMALE;
			} else {
				gender = EnumGender.MALE;
			}
			Calendar date = Calendar.getInstance();
			date.set(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay());
			medicalData.put(textLastName.getText()+textFirstName.getText(), 
				new Patient(textFirstName.getText(), textLastName.getText(), gender, 
						textHealthInsurance.getText(), textStreet.getText(), 
						textCity.getText(), textZip.getText(), textState.getText(), 
						Float.parseFloat(spinnerHeight.getText()), 
						Float.parseFloat(spinnerWeight.getText()), date.getTime(),
						textAfflictions.getText()));
			MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_WARNING | SWT.OK);		        
			messageBox.setText("Info");
			messageBox.setMessage("Created new patient " + textFirstName.getText() + " "
					+ textLastName.getText() + ".");
			int ret = messageBox.open();	
			container.getDisplay().dispose();
		} else {
			MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_WARNING | SWT.OK);		        
			messageBox.setText("Warning");
			messageBox.setMessage("You must fill in all information before you can create a new "
					+ "patient!");
			int ret = messageBox.open();
		}
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 469);
	}
	
}
