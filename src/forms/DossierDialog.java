package forms;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
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




public class DossierDialog extends Dialog {
	private Composite container;
	private HashMap<String, Patient> medicalData;
	
	
	public DossierDialog(Shell parentShell, HashMap<String, Patient> medicalData) {
		super(parentShell);
		this.medicalData = medicalData;
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		this.container = (Composite) super.createDialogArea(parent);
		this.container.setLayout(new GridLayout());
		this.container.getShell().setText("Patients dossier");
		
		//create patients table
		Table table = new Table (parent.getShell(), SWT.BORDER | SWT.MULTI);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setToolTipText("Patients");
        table.setLinesVisible (true);
		table.setHeaderVisible(true);
        String[] colNames = {"Last Name", "First Name", "Date of admission"};
        TableColumn[] cols = new TableColumn[colNames.length];
        int[] order = new int[colNames.length];
        for (int i = 0; i < colNames.length; i++) {
        	TableColumn tc = new TableColumn(table, SWT.BORDER);
            tc.setText(colNames[i]);
            tc.pack();
            tc.setMoveable(true);
            cols[i] = tc;
            order[i] = i;
        }
        Set<Entry<String, Patient>> entrySet = this.medicalData.entrySet();
        for (Entry<String, Patient> entry : entrySet) {
            TableItem item = new TableItem(table, SWT.BORDER);
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
	    			default:
	    				System.out.println("Table printing error!");
            	}		
            }
        } 
        return container;

	}
}
