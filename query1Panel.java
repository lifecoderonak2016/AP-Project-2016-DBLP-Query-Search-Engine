package approject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class query1Panel {
	
	private JFrame query1Frame;
	private JTextField textField, textField_1, textField_2, textField_3;
	private JPanel panel1;
	private JTable table;
	private JLabel firstLabel;
	private JRadioButton rb1, rb2;
	private JComboBox<String> searchComboBox;
	
	public query1Panel()
	{
		query1Frame = new JFrame("Query 1 Page");
		query1Frame.getContentPane().setBackground(UIManager.getColor("RadioButton.select"));
		query1Frame.getContentPane().setForeground(Color.WHITE);
		query1Frame.setSize(850, 650);
		query1Frame.getContentPane().setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xpos = (dim.width / 2) - (query1Frame.getWidth() / 2);
		int ypos = (dim.height / 2) - (query1Frame.getHeight() / 2);
		query1Frame.setLocation(xpos, ypos);
		panel1 = new JPanel();
		panel1.setBounds(20, 56, 280, 550);
		panel1.setBackground(Color.ORANGE);
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		query1Frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		actionListenerFunc();
		addHeadLabel(query1Frame);
		addWidgetsLeftPanel();
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean check = false;
				if(!(searchComboBox.getSelectedItem().equals("Search By Author") || searchComboBox.getSelectedItem().equals("Search By Title")))
				{
					JOptionPane.showMessageDialog(query1Frame, "Select the Search Type");
					check = true;
				}
				if((textField.getText().equals("") == false))
				{
					if(check == false)
						JOptionPane.showMessageDialog(query1Frame, "Input the Name Field");
				}
			}
		});
		searchButton.setBounds(28, 460, 117, 29);
		panel1.add(searchButton);
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("Reset") == true)
				{
					panel1.setVisible(false);
					new query1Panel().getPanel().setVisible(true);
				}
			}
		});
		resetButton.setBounds(145, 460, 117, 29);
		panel1.add(resetButton);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(312, 56, 532, 550);
		query1Frame.getContentPane().add(panel);
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//TODO: Add actionListener to the next Button
			}
		});
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(398, 511, 117, 29);
		panel.add(button);
		addTable(panel);
		query1Frame.setVisible(true);
		query1Frame.setResizable(false);
		query1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addHeadLabel(JFrame container)
	{
		firstLabel = new JLabel("DBLP Query Engine");
		firstLabel.setBackground(Color.WHITE);
		firstLabel.setBounds(302, 6, 499, 40);
		firstLabel.setFont(new Font("Arial", Font.BOLD, 28));
		container.getContentPane().add(firstLabel);
	}
	private void addTable(Container container)
	{
		String values[] = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
		Object data[][] = new Object[21][8];
		data[0][0] = "S No"; data[0][1] = "Authors"; data[0][2] = "Title"; data[0][3] = "Pages"; data[0][4] = "Year"; data[0][5] = "Volume"; data[0][6] = "Journal"; data[0][7] = "URL";
		table = new JTable(data, values);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.setBounds(0, 0, 532, 499);
		container.add(table);
	}
	private void addWidgetsLeftPanel()
	{
		String[] searchData = {"Search", "Search By Author", "Search By Title"};
		searchComboBox = new JComboBox<String>(searchData);
		searchComboBox.setBounds(42, 129, 189, 27);
		searchComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("Search By Author") == true)
				{

				}
				else if(e.getActionCommand().equals("Search By Title") == true)
				{

				}
			}
		});
		panel1.add(searchComboBox);
		JLabel nameLabel = new JLabel("Name / Title Tags");
		nameLabel.setBounds(18, 199, 113, 16);
		panel1.add(nameLabel);
		JLabel yearLabel = new JLabel("Since Year");
		yearLabel.setBounds(18, 253, 91, 16);
		panel1.add(yearLabel);
		textField = new JTextField();
		textField.setBounds(143, 193, 113, 28);
		panel1.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(97, 247, 134, 28);
		panel1.add(textField_1);
		textField_1.setColumns(10);
		JLabel rangeLabel = new JLabel("Custom Range");
		rangeLabel.setBounds(18, 311, 113, 16);
		panel1.add(rangeLabel);
		textField_2 = new JTextField();
		textField_2.setBounds(117, 305, 66, 28);
		panel1.add(textField_2);
		textField_2.setColumns(10);
		JLabel label = new JLabel("-");
		label.setBounds(183, 311, 61, 16);
		panel1.add(label);
		textField_3 = new JTextField();
		textField_3.setBounds(191, 305, 76, 28);
		panel1.add(textField_3);
		textField_3.setColumns(10);
		rb1 = new JRadioButton("Sort by Year");
		rb1.setBounds(23, 363, 141, 23);
		rb2 = new JRadioButton("Sort by Relevance");
		rb2.setBounds(23, 410, 178, 23);
		panel1.add(rb1);
		panel1.add(rb2);
	}
	private void actionListenerFunc()
	{
		String[] queries = {"Query 1", "Queries", "Query 2", "Query 3"};
		JComboBox<String> comboBox = new JComboBox<String>(queries);
		comboBox.setBounds(67, 64, 140, 27);
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox<?> combo = (JComboBox<?>)(e.getSource());
				String val = (String)combo.getSelectedItem();
				if(val.equals("Query 2") == true)
				{
					query1Frame.dispose();
					new query2Panel();
				}
				else if(val.equals("Query 3") == true)
				{
					query1Frame.dispose();
					new query3Panel();
				}
				else if(val.equals("Queries") == true)
				{
					query1Frame.dispose();
					new MainUIFrame();
				}
			}
		});
		panel1.add(comboBox);
	}
	protected JPanel getPanel()
	{
		return this.panel1;
	}
}