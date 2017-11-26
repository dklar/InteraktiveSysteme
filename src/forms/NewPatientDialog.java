package forms;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Text;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;

public class NewPatientDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_7;
	private Text text_6;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public NewPatientDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new RowLayout(SWT.VERTICAL));
		
		Composite primaryData = new Composite(container, SWT.NONE);
		primaryData.setLayoutData(new RowData(440, 119));
		
		Label lblNewLabel = new Label(primaryData, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 63, 15);
		lblNewLabel.setText("Last Name");
		
		text = new Text(primaryData, SWT.BORDER);
		text.setBounds(119, 7, 76, 21);
		
		Label lblGivenName = new Label(primaryData, SWT.NONE);
		lblGivenName.setBounds(10, 43, 63, 15);
		lblGivenName.setText("Given name");
		
		text_1 = new Text(primaryData, SWT.BORDER);
		text_1.setBounds(119, 34, 76, 21);
		
		Group grpGender = new Group(primaryData, SWT.NONE);
		grpGender.setText("Gender");
		grpGender.setBounds(231, 10, 199, 48);
		
		Button btnMale = new Button(grpGender, SWT.RADIO);
		btnMale.setBounds(10, 22, 90, 16);
		btnMale.setText("Male");
		
		Button btnFemalr = new Button(grpGender, SWT.RADIO);
		btnFemalr.setBounds(106, 22, 90, 16);
		btnFemalr.setText("Female");
		
		Label label = new Label(primaryData, SWT.NONE);
		label.setText("Health Insurance");
		label.setBounds(10, 70, 96, 15);
		
		text_6 = new Text(primaryData, SWT.BORDER);
		text_6.setBounds(119, 64, 76, 21);
		
		Composite adressData = new Composite(container, SWT.NONE);
		adressData.setLayoutData(new RowData(437, 100));
		
		Label lblStreet = new Label(adressData, SWT.NONE);
		lblStreet.setBounds(10, 10, 55, 15);
		lblStreet.setText("Street");
		
		Label lblCity = new Label(adressData, SWT.NONE);
		lblCity.setBounds(10, 34, 55, 15);
		lblCity.setText("City");
		
		text_2 = new Text(adressData, SWT.BORDER);
		text_2.setBounds(78, 7, 349, 21);
		
		Label lblState = new Label(adressData, SWT.NONE);
		lblState.setBounds(10, 61, 55, 15);
		lblState.setText("State");
		
		text_3 = new Text(adressData, SWT.BORDER);
		text_3.setBounds(78, 31, 349, 21);
		
		text_4 = new Text(adressData, SWT.BORDER);
		text_4.setBounds(78, 58, 160, 21);
		
		Label lblZip = new Label(adressData, SWT.NONE);
		lblZip.setBounds(253, 61, 33, 15);
		lblZip.setText("ZIP");
		
		text_5 = new Text(adressData, SWT.BORDER);
		text_5.setBounds(292, 58, 135, 21);
		
		Composite healthData = new Composite(container, SWT.NONE);
		healthData.setLayoutData(new RowData(434, 134));
		
		Label lblDateOf = new Label(healthData, SWT.NONE);
		lblDateOf.setBounds(10, 10, 103, 15);
		lblDateOf.setText("Date of admission");
		
		Label lblAfflictions = new Label(healthData, SWT.NONE);
		lblAfflictions.setBounds(307, 10, 55, 15);
		lblAfflictions.setText("Afflictions");
		
		DateTime dateTime = new DateTime(healthData, SWT.BORDER);
		dateTime.setBounds(119, 10, 76, 24);
		
		text_7 = new Text(healthData, SWT.BORDER | SWT.V_SCROLL);
		text_7.setBounds(201, 31, 223, 93);
		
		Label lblMass = new Label(healthData, SWT.NONE);
		lblMass.setBounds(10, 53, 55, 15);
		lblMass.setText("Mass");
		
		Label lblHeight = new Label(healthData, SWT.NONE);
		lblHeight.setBounds(10, 82, 55, 15);
		lblHeight.setText("Height");
		
		Spinner spinner = new Spinner(healthData, SWT.BORDER);
		spinner.setBounds(119, 53, 47, 22);
		
		Spinner spinner_1 = new Spinner(healthData, SWT.BORDER);
		spinner_1.setBounds(119, 82, 47, 22);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 469);
	}
}
