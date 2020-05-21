package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.VFDatabaseConnect;
import view.ClientMainView;
import view.EditLMPView;
import view.ViewLMPClient;
import view.ViewLMPList;

public class ViewLMPClientControl {

	private ViewLMPClient myView;
	private VFDatabaseConnect database;
	private String planName;
	private String type;
	private int id;
	
	/**
     * Default constructor
     */
	public ViewLMPClientControl(ViewLMPClient aView, VFDatabaseConnect database, String planName, String type, int id) {
		this.myView = aView;
		this.database = database;
		this.planName = planName;
		this.type = type;
		this.id = id;
		myView.getFrame().setVisible(true);
		myView.addAddListener(new AddListener());
		myView.addBackListener(new BackListener());
	}
	
	class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myView.getFrame().setVisible(false);
			database.addPlantoClient(planName, id);
			ClientMainView aView = new ClientMainView();
			ClientMainControl control2 = new ClientMainControl(aView, database, type, id);
		}
	}
	
    class BackListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myView.getFrame().setVisible(false);
			ViewLMPList aView = new ViewLMPList();
			ViewLMPListControl control2 = new ViewLMPListControl(aView, database, type, id);
		}
	}
}