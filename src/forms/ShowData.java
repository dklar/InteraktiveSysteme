package forms;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridLayout;
import org.swtchart.Chart;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries.SeriesType;

import classes.EnumGender;
import classes.Patient;
import org.eclipse.swt.layout.GridData;

public class ShowData {

	protected Shell shell;
	
	protected  Patient patient;// = new Patient("Empty", "Empty", EnumGender.MALE, "Empty", "Empty", "Empty", "Empty", "Empty", 0.0f, 0.0f, new Date(), "Empty");
	private Chart chart1,chart2,chart3;
	
	Label nameLabel;
	Label admissionLabel;
	Label adressLabel;
	
	public void setPatient(Patient p) {
		patient = p;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(684, 572);
		shell.setMaximized(true);
		shell.setText("Show Data");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite CompositePatient = new Composite(shell, SWT.NONE);
		CompositePatient.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite compositeTable = new Composite(CompositePatient, SWT.NONE);
		compositeTable.setLayout(new GridLayout(4, false));
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		
		Label lblName = new Label(compositeTable, SWT.NONE);
		lblName.setText("Name:");
		new Label(compositeTable, SWT.NONE);
		
		nameLabel = new Label(compositeTable, SWT.NONE);
		nameLabel.setText(patient.getFirstName()+" "+patient.getLastName());
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		
		Label lblNewLabel = new Label(compositeTable, SWT.NONE);
		lblNewLabel.setText("Birthday");
		new Label(compositeTable, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(compositeTable, SWT.NONE);
		lblNewLabel_4.setText("New Label");
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(compositeTable, SWT.NONE);
		lblNewLabel_1.setText("Day of admission: ");
		new Label(compositeTable, SWT.NONE);
		
		admissionLabel = new Label(compositeTable, SWT.NONE);
		admissionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		admissionLabel.setText(patient.getAdmDate().toString());
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(compositeTable, SWT.NONE);
		lblNewLabel_2.setText("Adress:");
		new Label(compositeTable, SWT.NONE);
		
		adressLabel = new Label(compositeTable, SWT.NONE);
		adressLabel.setText(patient.getCity());
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		new Label(compositeTable, SWT.NONE);
		
		Label lblNewLabel_3 = new Label(compositeTable, SWT.NONE);
		lblNewLabel_3.setText("Afflictions:");
		new Label(compositeTable, SWT.NONE);
		
		Label afflictionsLabel = new Label(compositeTable, SWT.V_SCROLL);
		GridData gd_afflictionsLabel = new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1);
		gd_afflictionsLabel.heightHint = 118;
		afflictionsLabel.setLayoutData(gd_afflictionsLabel);
		afflictionsLabel.setText(patient.getAfflictions());
		
		Composite compositeHealthData = new Composite(shell, SWT.NONE);
		compositeHealthData.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		CTabFolder tabFolder = new CTabFolder(compositeHealthData, SWT.BORDER);
		tabFolder.setMaximized(true);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		
		
		CTabItem tbtmBloodPressure = new CTabItem(tabFolder, SWT.NONE);
		tbtmBloodPressure.setText("Blood Pressure");
		
		Composite compositeBloodPressure = new Composite(tabFolder, SWT.NONE);
		tbtmBloodPressure.setControl(compositeBloodPressure);
		compositeBloodPressure.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		chart1 = new Chart(compositeBloodPressure,SWT.NONE);
		chart1.getTitle().setText("Bloodpressure");
		chart1.getAxisSet().getYAxis(0).getTitle().setText("mmHg");
		chart1.getAxisSet().getXAxis(0).getTitle().setText("Time");
		
		
		
		CTabItem tbtmPulse = new CTabItem(tabFolder, SWT.NONE);
		tbtmPulse.setText("Pulse");
				
		Composite compositePulse = new Composite(tabFolder, SWT.NONE);
		tbtmPulse.setControl(compositePulse);
		compositePulse.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		chart2 = new Chart(compositePulse,SWT.NONE);
		chart2.getTitle().setText("Pulse");
		chart2.getAxisSet().getYAxis(0).getTitle().setText("BPM");
		chart2.getAxisSet().getXAxis(0).getTitle().setText("Time");
		
		CTabItem tbtmNewItem = new CTabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Weight");
		
		Composite compositeWeight = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem.setControl(compositeWeight);
		compositeWeight.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		chart3 = new Chart(compositeWeight,SWT.NONE);
		chart3.getTitle().setText("Weight");
		chart3.getAxisSet().getYAxis(0).getTitle().setText("kg");
		chart3.getAxisSet().getXAxis(0).getTitle().setText("Time");
		

		//return container;
	}
		
	public static void main(String args[]) {
		/*try {
			ShowData window = new ShowData();
			//window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	

	
	public void open(Patient p) {
		patient = p;
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
