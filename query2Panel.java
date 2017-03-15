package approject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class query2Panel {
	
	private JFrame query2Frame;
	private JTextField textField;
	private JPanel panel2;
	private JTable table;
	public query2Panel()
	{
		query2Frame = new JFrame("Query 2 Page");
		query2Frame.getContentPane().setBackground(UIManager.getColor("RadioButton.select"));
		query2Frame.setSize(850, 650);
		query2Frame.getContentPane().setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xpos = (dim.width / 2) - (query2Frame.getWidth() / 2);
		int ypos = (dim.height / 2) - (query2Frame.getHeight() / 2);
		query2Frame.setLocation(xpos, ypos);
		panel2 = new JPanel();
		panel2.setBounds(20, 56, 280, 550);
		panel2.setBackground(Color.ORANGE);
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		query2Frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		String[] queries = {"Query 2", "Query 1", "Query 3", "Queries"};
		JComboBox<String> comboBox = new JComboBox<String>(queries);
		comboBox.setBounds(67, 64, 140, 27);
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox<?> combo = (JComboBox<?>)(e.getSource());
				String val = (String)combo.getSelectedItem();
				if(val.equals("Query 1") == true)
				{
					query2Frame.dispose();
					new query1Panel();
				}
				else if(val.equals("Query 3") == true)
				{
					query2Frame.dispose();
					new query3Panel();
				}
				else if(val.equals("Queries") == true)
				{
					query2Frame.dispose();
					new MainUIFrame();
				}
			}
		});
		panel2.add(comboBox);
		JLabel pubLabel = new JLabel("No. Of Publications");
		pubLabel.setBounds(18, 187, 130, 16);
		panel2.add(pubLabel);
		textField = new JTextField();
		textField.setBounds(145, 181, 117, 28);
		panel2.add(textField);
		textField.setColumns(10);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(28, 280, 117, 29);
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("") == true)
					JOptionPane.showMessageDialog(query2Frame, "Enter the Publications");
			}
		});	
		panel2.add(searchButton);
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				panel2.setVisible(false);
				new query2Panel().getPanel().setVisible(true);
			}
		});	
		resetButton.setBounds(145, 280, 117, 29);
		panel2.add(resetButton);
		JLabel label = new JLabel("DBLP Query Engine");
		label.setFont(new Font("Arial", Font.BOLD, 28));
		label.setBackground(Color.WHITE);
		label.setBounds(300, 6, 499, 40);
		query2Frame.getContentPane().add(label);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(312, 56, 532, 550);
		query2Frame.getContentPane().add(panel);
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{

			}
		});
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
		query2Frame.setVisible(true);
		query2Frame.setResizable(false);
		query2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	protected JPanel getPanel()
	{
		return this.panel2;
	}
}