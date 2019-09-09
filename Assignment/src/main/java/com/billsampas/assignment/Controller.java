package com.billsampas.assignment;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import com.billsampas.assignment.Model.ListSelection;
import com.billsampas.assignment.Model.RunInfo;
/**
 * The controller component of the MVC pattern. It accepts input
 * and converts it to commands for the model or view.
 */
public class Controller {
	private Model model;
	private View view;
	public Controller(Model m, View v) {
		model = m;
		view = v;
		initView();
	}
	
	/** 
	 * Initializes the View by populating the fields with the Model's
	 * values.
	 */
	public void initView() {
		view.getListASizeField().setValue(model.getListASize());
		view.getListBSizeField().setValue(model.getListBSize());
		HelperFunctions.populateComboWithEnumValues(view.getHashedListField(),ListSelection.class,model.getHashedList());
		HelperFunctions.populateComboWithEnumValues(view.getIteratedListField(),ListSelection.class,model.getIteratedList());
	}
	
	/** Sets up how the View and the Model interact by adding the appropriate Listeners */
	public void initController() {
		view.getListASizeField().addChangeListener(e -> model.setListASize((int)((JSpinner) e.getSource()).getValue()));
		view.getListBSizeField().addChangeListener(e -> model.setListBSize((int)((JSpinner) e.getSource()).getValue()));
		view.getRunButton().addActionListener(e -> {
			new Thread(new IntersectionProcessRunnable(model, view)).start();
		});
		view.getHashedListField().addActionListener(l ->{
			model.setHashedList( (ListSelection) view.getHashedListField().getSelectedItem());
			view.getIteratedListField().setSelectedItem(model.getIteratedList());
		});
		view.getIteratedListField().addActionListener(l ->{
			model.setIteratedList((ListSelection) view.getIteratedListField().getSelectedItem());
			view.getHashedListField().setSelectedItem(model.getHashedList());
		});
	}
	
	
	/**
	* The IntersectionProcessRunnable class implements the thread that
	* asynchronously performs the intersection algorithm while keeping
	* the View's GUI responsive.
	*/
	class IntersectionProcessRunnable implements Runnable{  
		Model m;
		View v;
		public IntersectionProcessRunnable(Model m,View v) {
			this.m=m;
			this.v=v;
		}
		public void run(){
			v.getRunButton().setEnabled(false);
			try {
				RunInfo runInfo=m.RunIntersectionAlgorithm();
	            v.getIntersectionSizeField().setText( String.valueOf(runInfo.getNumberOfElements()) );
	            v.getDurationField().setText( String.valueOf(HelperFunctions.timeDurationToString(runInfo.getTimeNeeded())) );
	        } catch (OutOfMemoryError E) {
	        	// If we run out of memory, we show a warning window instead of throwing the error directly
	        	JOptionPane.showMessageDialog(view.getFrame(),
	        		    "Out of memory. Try to decrease the size of the lists A and B.",
	        		    "Warning",
	        		    JOptionPane.WARNING_MESSAGE);
	        }
			v.getRunButton().setEnabled(true);
		}  
	}
	
	
	public Controller() {
		// TODO Auto-generated constructor stub
	}

}
