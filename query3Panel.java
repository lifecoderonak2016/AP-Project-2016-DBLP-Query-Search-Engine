package approject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class query3Panel {

	private JFrame query3Frame;
	private JTextField textField;
	private JPanel panel3;
	private JLabel headlabel;
	private JPanel panel;
	private JButton button;
	private JTable table;
	private JTextField textField_1, textField_2, textField_3, textField_4, textField_5;
	public query3Panel()
	{
		query3Frame = new JFrame("Query 3 Page");
		query3Frame.getContentPane().setBackground(UIManager.getColor("RadioButton.select"));
		query3Frame.setSize(850, 650);
		query3Frame.getContentPane().setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xpos = (dim.width / 2) - (query3Frame.getWidth() / 2);
		int ypos = (dim.height / 2) - (query3Frame.getHeight() / 2);
		query3Frame.setLocation(xpos, ypos);
		panel3 = new JPanel();
		panel3.setBounds(20, 56, 280, 550);
		panel3.setBackground(Color.ORANGE);
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		query3Frame.getContentPane().add(panel3);
		panel3.setLayout(null);
		String[] queries = {"Query 3", "Query 1", "Query 2", "Queries"};
		JComboBox<String> comboBox = new JComboBox<String>(queries);
		comboBox.setBounds(67, 67, 140, 27);
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox<?> combo = (JComboBox<?>)(e.getSource());
				String val = (String)combo.getSelectedItem();
				if(val.equals("Query 1") == true)
				{
					query3Frame.dispose();
					new query1Panel();
				}
				else if(val.equals("Query 2") == true)
				{
					query3Frame.dispose();
					new query2Panel();
				}
				else if(val.equals("Queries") == true)
				{
					query3Frame.dispose();
					new MainUIFrame();
				}
			}
		});
		panel3.add(comboBox);
		JLabel lblNewLabel = new JLabel("Enter the Year");
		lblNewLabel.setBounds(18, 165, 98, 16);
		panel3.add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(111, 159, 151, 28);
		panel3.add(textField);
		textField.setColumns(10);
		addHeadLabel(query3Frame);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(312, 56, 532, 550);
		query3Frame.getContentPane().add(panel);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(78, 447, 117, 29);
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("") == true)
					JOptionPane.showMessageDialog(query3Frame, "Enter the Year");
				else if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals(""))
					JOptionPane.showMessageDialog(query3Frame, "Complete the Author Name");
			}
		});	
		panel3.add(searchButton);
		JLabel author1Label = new JLabel("Enter the Author 1");
		author1Label.setBounds(18, 211, 117, 16);
		panel3.add(author1Label);
		JLabel label = new JLabel("Enter the Author 2");
		label.setBounds(18, 250, 117, 16);
		panel3.add(label);
		JLabel label_1 = new JLabel("Enter the Author 3");
		label_1.setBounds(18, 288, 117, 16);
		panel3.add(label_1);
		JLabel label_2 = new JLabel("Enter the Author 4");
		label_2.setBounds(18, 325, 117, 16);
		panel3.add(label_2);
		JLabel label_3 = new JLabel("Enter the Author 5");
		label_3.setBounds(18, 364, 117, 16);
		panel3.add(label_3);
		textField_1 = new JTextField();
		textField_1.setBounds(145, 205, 117, 28);
		panel3.add(textField_1);
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 244, 117, 28);
		panel3.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 282, 117, 28);
		panel3.add(textField_3);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(145, 319, 117, 28);
		panel3.add(textField_4);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(145, 358, 117, 28);
		panel3.add(textField_5);
		button = new JButton("Next");
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(398, 511, 117, 29);
		panel.add(button);
		String values[] = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
		Object data[][] = new Object[21][8];
		data[0][0] = "S No"; data[0][1] = "Authors"; data[0][2] = "Title"; data[0][3] = "Pages"; data[0][4] = "Year"; data[0][5] = "Volume"; data[0][6] = "Journal"; data[0][7] = "URL";
		table = new JTable(data, values);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.setBounds(0, 0, 532, 499);
		panel.add(table);
		query3Frame.setVisible(true);
		query3Frame.setResizable(false);
		query3Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addHeadLabel(JFrame container)
	{
		headlabel = new JLabel("DBLP Query Engine");
		headlabel.setBackground(Color.WHITE);
		headlabel.setBounds(302, 6, 499, 40);
		headlabel.setFont(new Font("Arial", Font.BOLD, 28));
		container.getContentPane().add(headlabel);
	}
	protected JPanel getPanel()
	{
		return this.panel;
	}
}