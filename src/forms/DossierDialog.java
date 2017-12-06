package forms;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import classes.Patient;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.ViewForm;




public class DossierDialog extends Dialog {
	private Composite container;
	private HashMap<String, Patient> medicalData;
	private Table table_1;
	private Composite composite_1;
	private Label lblPleaseSelectA;
	private String selectedPatient;
	
	
	public DossierDialog(Shell parentShell, HashMap<String, Patient> medicalData) {
		super(parentShell);
		this.medicalData = medicalData;
	}
	
	@Override
	protected void okPressed() {
		
		TableItem[] items = table_1.getItems();
		String name = items[table_1.getSelectionIndex()].getText(0) +items[table_1.getSelectionIndex()].getText(1);
		System.out.println(name);
		selectedPatient = name;
		container.getDisplay().close();
	}
	
	public String getSelectedPatient(){
		return selectedPatient;
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		this.container = (Composite) super.createDialogArea(parent);
		this.container.setLayout(new FillLayout(SWT.VERTICAL));
		
		composite_1 = new Composite(container, SWT.NONE);
		
		lblPleaseSelectA = new Label(composite_1, SWT.NONE);
		lblPleaseSelectA.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblPleaseSelectA.setBounds(10, 10, 424, 29);
		lblPleaseSelectA.setText("Please select a patient to open acta");
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table_1 = new Table(composite, SWT.BORDER | SWT.MULTI);
		table_1.setToolTipText("Patients");
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		this.container.getShell().setText("Patients dossier");
		
		String[] colNames = {"Last Name", "First Name", "Date of admission"};
        TableColumn[] cols = new TableColumn[colNames.length];
		
        int[] order = new int[colNames.length];
        for (int i = 0; i < colNames.length; i++) {
        	TableColumn tc = new TableColumn(table_1, SWT.BORDER);
            tc.setText(colNames[i]);
            tc.pack();
            tc.setMoveable(true);
            
            cols[i] = tc;
            order[i] = i;
        }
        Set<Entry<String, Patient>> entrySet = this.medicalData.entrySet();
        for (Entry<String, Patient> entry : entrySet) {
            TableItem item = new TableItem(table_1, SWT.BORDER);
            for (int i = 0; i < colNames.length; i++) {
            	switch(i) {
	            	case 0:
	            		item.setText(i, entry.getValue().getLastName());
	            		break;
	        		case 1: 
	        			item.setText(i, entry.getValue().getFirstName());
	        			break;
	        		case 2: 
	        			item.setText(i, entry.getValue().getAdmDate().toString());
	        			break;
	    			default:
	    				System.out.println("Table printing error!");
            	}		
            }
        } 
        return container;

	}
}
