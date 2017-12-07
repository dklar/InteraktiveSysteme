package forms;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Font;

import classes.*;


public class MainWindow {

	protected Shell shell;
	protected Display display;
	//Map containing all saved Patient objects with (Patient.lastName+Patient.firstName) as key
	private HashMap<String, Patient> medicalData;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		this.medicalData = new HashMap<>();
		//read file to automatically create some patients
		try {
			BufferedReader reader = 
				Files.newBufferedReader(FileSystems.getDefault().getPath("patients",
				"patients.txt"), StandardCharsets.UTF_8);
			String line = null;
			Patient patient;
		    while ((line = reader.readLine()) != null) {
		    	patient = Patient.parseStringNewPatients(line);
		    	this.medicalData.put(patient.getLastName()+patient.getFirstName(), patient);
		    }
		} catch (Exception e) {
				e.printStackTrace();
		}
		//read file to automatically create patients records
		Set<Entry<String,Patient>> entrySet = this.medicalData.entrySet();
		for(Entry<String,Patient> entry : entrySet) {
			try {
				BufferedReader reader = 
					Files.newBufferedReader(FileSystems.getDefault().getPath("patients",
					entry.getKey().toLowerCase()+".txt"), StandardCharsets.UTF_8);
				String line = null;
				PatientsData data;
			    while ((line = reader.readLine()) != null) {
			    	data = PatientsData.parseStringNewData(line);
			    	this.medicalData.get(entry.getKey()).getData().put(data.getDate(), data);
//			    	System.out.println("Record [" 
//			    			+ this.medicalData.get(entry.getKey()).getData().get(data.getDate()).getBloodPressureHigh() + ", "
//			    			+ this.medicalData.get(entry.getKey()).getData().get(data.getDate()).getBloodPressureLow() + ", "
//			    			+ this.medicalData.get(entry.getKey()).getData().get(data.getDate()).getPulse()  + ", "
//			    			+ this.medicalData.get(entry.getKey()).getData().get(data.getDate()).getWeight()
//			    			+"] added to patient " + entry.getKey());
			    }
			} catch (Exception e) {
					System.out.println("No data found for patient-key " + entry.getKey());
			}
		}
		this.display = Display.getDefault();
		this.createContents();
		this.shell.pack();
		this.shell.open();
		this.shell.layout();
		while (!this.shell.isDisposed()) {
			if (!this.display.readAndDispatch()) {
				this.display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {		
		this.shell = new Shell();//(this.display, SWT.NONE);
//		this.shell.setSize(450, 300);
		this.shell.setText("SWT Application");
		this.shell.setBackground(this.display.getSystemColor(1));
		RowLayout layout = new RowLayout();
		layout.type = SWT.VERTICAL;
		layout.center = true;
		layout.marginHeight = 20;
		layout.marginWidth = 30;
		layout.spacing = 15;
		layout.fill = true;
		this.shell.setLayout(layout);	
		
		
		Label heading = new Label(this.shell, SWT.NONE);
		heading.setText("+++ Health monitoring tool +++\n");
		heading.setForeground(this.display.getSystemColor(6));
		heading.setFont(new Font(this.display, "Arial", 20, SWT.BOLD | SWT.ITALIC));
		
		
		Button btnNewPatient = new Button(this.shell, SWT.CENTER);
		btnNewPatient.setText("New Patient");		
		btnNewPatient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NewPatientDialog dialog =
						new NewPatientDialog(shell, medicalData);				
				dialog.open();
			}
		});
		
		Button btnOpenDossier = new Button(this.shell, SWT.NONE);
		btnOpenDossier.setText("Open dossier");
		btnOpenDossier.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DossierDialog dossierDialog = new DossierDialog(shell, medicalData);
				if (dossierDialog.open() == Dialog.OK) {
					System.out.println("OKAY");
					ShowData dataWindow;
					//ShowData.setPatient(medicalData.get(dossierDialog.getSelectedPatient()));
					dataWindow = new ShowData();
					dataWindow.setPatient(medicalData.get(dossierDialog.getSelectedPatient()));
					dataWindow.open(medicalData.get(dossierDialog.getSelectedPatient()));
				}
			}
		});
				
		Button btnClose = new Button(this.shell, SWT.NONE);
		btnClose.setText("Close");
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.getDisplay().dispose();
				System.exit(0);
			}
		});
	}
}
