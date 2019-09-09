package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

import Assignment.Model.ListSelection;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

/**
 * The view component of the MVC pattern. It includes
 * the representations of our information, like the GUI.
 */
public class View {

	private JFrame frmIntersectionTest;
	
	private JSpinner listASizeSpinner;
	private JSpinner listBSizeSpinner;
	private JTextField durationTextField;
	private JTextField resultSizeTextField;
	private JButton runButton;
	private JComboBox hashedComboBox;
	private JComboBox iteratedComboBox;
	private JLabel lblListBSize;
	private JLabel lblListASize;
	private JLabel label_2;
	private JLabel lblIterated;
	

	/**
	 * Create the view.
	 */
	public View() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIntersectionTest = new JFrame();
		frmIntersectionTest.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/appIcon_128x128.png")));
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
		
		listASizeSpinner = new JSpinner();
		listASizeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(50)));
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
		listBSizeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(50)));
		GridBagConstraints gbc_listBSizeSpinner = new GridBagConstraints();
		gbc_listBSizeSpinner.fill = GridBagConstraints.BOTH;
		gbc_listBSizeSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_listBSizeSpinner.gridx = 1;
		gbc_listBSizeSpinner.gridy = 1;
		inputPanel.add(listBSizeSpinner, gbc_listBSizeSpinner);
		
		label_2 = new JLabel("Hashed");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 5, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		inputPanel.add(label_2, gbc_label_2);
		
		hashedComboBox = new JComboBox();
		
		GridBagConstraints gbc_hashedComboBox = new GridBagConstraints();
		gbc_hashedComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_hashedComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_hashedComboBox.gridx = 1;
		gbc_hashedComboBox.gridy = 2;
		inputPanel.add(hashedComboBox, gbc_hashedComboBox);
		
		lblIterated = new JLabel("Iterated");
		lblIterated.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblIterated = new GridBagConstraints();
		gbc_lblIterated.fill = GridBagConstraints.BOTH;
		gbc_lblIterated.insets = new Insets(0, 5, 5, 5);
		gbc_lblIterated.anchor = GridBagConstraints.EAST;
		gbc_lblIterated.gridx = 0;
		gbc_lblIterated.gridy = 3;
		inputPanel.add(lblIterated, gbc_lblIterated);
		
		iteratedComboBox = new JComboBox();
		GridBagConstraints gbc_iteratedComboBox = new GridBagConstraints();
		gbc_iteratedComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_iteratedComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_iteratedComboBox.gridx = 1;
		gbc_iteratedComboBox.gridy = 3;
		inputPanel.add(iteratedComboBox, gbc_iteratedComboBox);
		
		runButton = new JButton("RUN");
		GridBagConstraints gbc_runButton = new GridBagConstraints();
		gbc_runButton.insets = new Insets(5, 5, 5, 0);
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
		
		frmIntersectionTest.setVisible(true);
		
	}
	
	public JSpinner getListASizeField() {
		return listASizeSpinner;
	}
	public JSpinner getListBSizeField() {
		return listBSizeSpinner;
	}
	
	public JComboBox getHashedListField() {
		return hashedComboBox;
	}
	
	public JComboBox getIteratedListField() {
		return iteratedComboBox;
	}
	
	public JTextField getIntersectionSizeField() {
		return resultSizeTextField;
	}
	
	public JTextField getDurationField() {
		return durationTextField;
	}
	
	public JFrame getFrame() {
		return frmIntersectionTest;
	}
	public JButton getRunButton() {
		return runButton;
	}
}
