package com.billsampas.assignment;




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
		view.SetListASize(model.getListASize());
		view.SetListBSize(model.getListBSize());
		if(model.isListAHashed())
			view.SetHashedListToA();
		else
			view.SetHashedListToB();
	}
	
	
	
	/** Sets up how the View and the Model interact by adding the appropriate Listeners */
	public void initController() {
		view.SetOnUpdate(()->{
			model.setListASize(view.GetListASize());
			model.setListBSize(view.GetListBSize());
			if(view.GetHashedListIsA())
				model.setListAHashed();
			else
				model.setListBHashed();
			
		});
		view.SetOnRun(
				new IntersectionProcessRunnable(model,view)
				);
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
			try {
				RunInfo runInfo=m.RunIntersectionAlgorithm();
				v.setIntersectionSize(runInfo.numberOfElements);
				v.setDuration(runInfo.timeNeeded);
	        } catch (OutOfMemoryError E) {
	        	// If we run out of memory, we show a warning window instead of throwing the error directly
	        	v.showMemoryWarning();
	        }
		}  
	}

}
