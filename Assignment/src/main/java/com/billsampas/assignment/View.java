package com.billsampas.assignment;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



import javax.swing.JRadioButton;

public class View {

	

	

	/**
	 * Create the application.
	 */
	public View() {
		try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		initialize();
	}

private JFrame frmIntersectionTest;
	
	private JSpinner listASizeSpinner;
	private JSpinner listBSizeSpinner;
	private JTextField durationTextField;
	private JTextField resultSizeTextField;
	private JButton runButton;
	private JLabel lblListBSize;
	private JLabel lblListASize;
	private JLabel lblHashedList;
	private JRadioButton rdbtnListA;
	private JRadioButton rdbtnListB;
	private ButtonGroup group;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIntersectionTest = new JFrame();
		frmIntersectionTest.setAlwaysOnTop(true);
		frmIntersectionTest.setTitle("Intersect");
		frmIntersectionTest.setResizable(false);
		frmIntersectionTest.setBounds(100, 100, 285, 307);
		frmIntersectionTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		frmIntersectionTest.getContentPane().setLayout(gridBagLayout);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_inputPanel = new GridBagLayout();
		gbl_inputPanel.columnWidths = new int[] {100, 100};
		gbl_inputPanel.rowHeights = new int[]{20, 20, 19, 19, 21, 0};
		gbl_inputPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		inputPanel.setLayout(gbl_inputPanel);
		
		lblListASize = new JLabel("List A size");
		lblListASize.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblListASize = new GridBagConstraints();
		gbc_lblListASize.fill = GridBagConstraints.BOTH;
		gbc_lblListASize.insets = new Insets(0, 5, 5, 5);
		gbc_lblListASize.gridx = 0;
		gbc_lblListASize.gridy = 0;
		inputPanel.add(lblListASize, gbc_lblListASize);
		
		SpinnerNumberModel modelA=new SpinnerNumberModel();
		modelA.setMinimum(0);
		modelA.setStepSize(50);
		
		listASizeSpinner = new JSpinner();
		listASizeSpinner.setModel(modelA);
		GridBagConstraints gbc_listASizeSpinner = new GridBagConstraints();
		gbc_listASizeSpinner.fill = GridBagConstraints.BOTH;
		gbc_listASizeSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_listASizeSpinner.gridx = 1;
		gbc_listASizeSpinner.gridy = 0;
		inputPanel.add(listASizeSpinner, gbc_listASizeSpinner);
		
		lblListBSize = new JLabel("List B size");
		lblListBSize.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblListBSize = new GridBagConstraints();
		gbc_lblListBSize.fill = GridBagConstraints.BOTH;
		gbc_lblListBSize.insets = new Insets(0, 5, 5, 5);
		gbc_lblListBSize.gridx = 0;
		gbc_lblListBSize.gridy = 1;
		inputPanel.add(lblListBSize, gbc_lblListBSize);
		
		listBSizeSpinner = new JSpinner();
		
		SpinnerNumberModel modelB=new SpinnerNumberModel();
		modelA.setMinimum(0);
		modelA.setStepSize(50);
		listBSizeSpinner.setModel(modelB);
		GridBagConstraints gbc_listBSizeSpinner = new GridBagConstraints();
		gbc_listBSizeSpinner.fill = GridBagConstraints.BOTH;
		gbc_listBSizeSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_listBSizeSpinner.gridx = 1;
		gbc_listBSizeSpinner.gridy = 1;
		inputPanel.add(listBSizeSpinner, gbc_listBSizeSpinner);
		
		lblHashedList = new JLabel("Hashed List");
		lblHashedList.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHashedList = new GridBagConstraints();
		gbc_lblHashedList.fill = GridBagConstraints.BOTH;
		gbc_lblHashedList.insets = new Insets(0, 5, 5, 5);
		gbc_lblHashedList.anchor = GridBagConstraints.EAST;
		gbc_lblHashedList.gridx = 0;
		gbc_lblHashedList.gridy = 2;
		inputPanel.add(lblHashedList, gbc_lblHashedList);
		
		rdbtnListA = new JRadioButton("List A");
		rdbtnListA.setSelected(true);
		rdbtnListA.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnListA = new GridBagConstraints();
		gbc_rdbtnListA.anchor = GridBagConstraints.WEST;
		gbc_rdbtnListA.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnListA.gridx = 1;
		gbc_rdbtnListA.gridy = 2;
		inputPanel.add(rdbtnListA, gbc_rdbtnListA);
		
		rdbtnListB = new JRadioButton("List B");
		GridBagConstraints gbc_rdbtnListB = new GridBagConstraints();
		gbc_rdbtnListB.anchor = GridBagConstraints.WEST;
		gbc_rdbtnListB.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnListB.gridx = 1;
		gbc_rdbtnListB.gridy = 3;
		inputPanel.add(rdbtnListB, gbc_rdbtnListB);
		
		runButton = new JButton("RUN");
		GridBagConstraints gbc_runButton = new GridBagConstraints();
		gbc_runButton.insets = new Insets(5, 5, 0, 0);
		gbc_runButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_runButton.gridwidth = 2;
		gbc_runButton.gridx = 0;
		gbc_runButton.gridy = 4;
		inputPanel.add(runButton, gbc_runButton);
		GridBagConstraints gbc_inputPanel = new GridBagConstraints();
		gbc_inputPanel.fill = GridBagConstraints.BOTH;
		gbc_inputPanel.insets = new Insets(0, 0, 5, 0);
		gbc_inputPanel.gridx = 0;
		gbc_inputPanel.gridy = 0;
		frmIntersectionTest.getContentPane().add(inputPanel, gbc_inputPanel);
		
		JPanel output = new JPanel();
		output.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Output", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_output = new GridBagLayout();
		gbl_output.columnWidths = new int[] {100, 100};
		gbl_output.rowHeights = new int[] {20, 20};
		gbl_output.columnWeights = new double[]{0.0, 0.0};
		gbl_output.rowWeights = new double[]{0.0, 0.0};
		output.setLayout(gbl_output);
		
		JLabel resultSizeLabel = new JLabel("Common Elements");
		resultSizeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_resultSizeLabel = new GridBagConstraints();
		gbc_resultSizeLabel.fill = GridBagConstraints.VERTICAL;
		gbc_resultSizeLabel.anchor = GridBagConstraints.WEST;
		gbc_resultSizeLabel.insets = new Insets(0, 5, 5, 5);
		gbc_resultSizeLabel.gridx = 0;
		gbc_resultSizeLabel.gridy = 0;
		output.add(resultSizeLabel, gbc_resultSizeLabel);
		
		resultSizeTextField = new JTextField();
		resultSizeTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		resultSizeLabel.setLabelFor(resultSizeTextField);
		resultSizeTextField.setEditable(false);
		GridBagConstraints gbc_resultSizeTextField = new GridBagConstraints();
		gbc_resultSizeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_resultSizeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_resultSizeTextField.gridx = 1;
		gbc_resultSizeTextField.gridy = 0;
		output.add(resultSizeTextField, gbc_resultSizeTextField);
		resultSizeTextField.setColumns(4);
		
		JLabel durationLabel = new JLabel("Duration");
		durationLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_durationLabel = new GridBagConstraints();
		gbc_durationLabel.fill = GridBagConstraints.VERTICAL;
		gbc_durationLabel.anchor = GridBagConstraints.WEST;
		gbc_durationLabel.insets = new Insets(0, 5, 5, 5);
		gbc_durationLabel.gridx = 0;
		gbc_durationLabel.gridy = 1;
		output.add(durationLabel, gbc_durationLabel);
		
		durationTextField = new JTextField();
		durationTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		durationLabel.setLabelFor(durationTextField);
		durationTextField.setEditable(false);
		GridBagConstraints gbc_durationTextField = new GridBagConstraints();
		gbc_durationTextField.insets = new Insets(0, 0, 5, 5);
		gbc_durationTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_durationTextField.gridx = 1;
		gbc_durationTextField.gridy = 1;
		output.add(durationTextField, gbc_durationTextField);
		durationTextField.setColumns(4);
		GridBagConstraints gbc_output = new GridBagConstraints();
		gbc_output.fill = GridBagConstraints.BOTH;
		gbc_output.gridx = 0;
		gbc_output.gridy = 1;
		frmIntersectionTest.getContentPane().add(output, gbc_output);
		
		
		
		
		group = new ButtonGroup();
	    group.add(rdbtnListA);
	    group.add(rdbtnListB);
		
	    
	    
		frmIntersectionTest.setVisible(true);
		
	}
	
	
	
	public void SetHashedListToA() {
		rdbtnListA.setSelected(true);
	}
	
	public void SetHashedListToB() {
		rdbtnListB.setSelected(true);
	}
	
	public boolean GetHashedListIsA() {
		
		return rdbtnListA.isSelected();
	}
	
	public boolean GetHashedListIsB() {
		return rdbtnListB.isSelected();
	}
	
	public void SetOnUpdate(Runnable r) {
		ChangeListener cl=new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				r.run();
			}};
		
		
		rdbtnListA.addChangeListener(cl);
	    rdbtnListB.addChangeListener(cl);
	    listASizeSpinner.addChangeListener(cl);
	    listBSizeSpinner.addChangeListener(cl);
	}
	public void SetOnRun(Runnable r) {
		
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(
						()->
						{
							runButton.setEnabled(false);
							r.run();
							runButton.setEnabled(true);
						}
						).start();
			}
		};
		runButton.addActionListener(al);
	}
	
	
	public int GetListASize() {
		return (int)listASizeSpinner.getValue();
	}
	
	public int GetListBSize() {
		return (int)listBSizeSpinner.getValue();
	}
	
	public void SetListASize(int size) {
		listASizeSpinner.setValue(size);
	}
	
	public void SetListBSize(int size) {
		listBSizeSpinner.setValue(size);
	}
	
	public void setIntersectionSize(int size) {
		resultSizeTextField.setText(size+" elements");
	}
	
	public void setDuration(long durationInNanoseconds) {
		durationTextField.setText(durationInNanoseconds+" nS");
	}
	
	
	
	
	public void showMemoryWarning() {
		JOptionPane.showMessageDialog(frmIntersectionTest,
    		    "Out of memory. Try to decrease the size of the lists A and B.",
    		    "Warning",
    		    JOptionPane.WARNING_MESSAGE);
	}
	

}
