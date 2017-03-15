package approject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainUIFrame {

	private JFrame mainFrame;
	private JTable resultTable;
	private JPanel leftPanel, rightPanel;
	private JLabel firstLabel;
	private JComboBox<String> actionListenerFunc()
	{
		String[] queries = {"Queries", "Query 1", "Query 2", "Query 3"};
		JComboBox<String> comboBox = new JComboBox<String>(queries);
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox<?> combo = (JComboBox<?>)(e.getSource());
				String val = (String)combo.getSelectedItem();
				if(val.equals("Query 1") == true)
				{
					leftPanel.setVisible(false);
					new query1Panel().getPanel().setVisible(true);
				}
				else if(val.equals("Query 2") == true)
				{
					leftPanel.setVisible(false);
					new query2Panel().getPanel().setVisible(true);
				}
				else if(val.equals("Query 3") == true)
				{
					leftPanel.setVisible(false);
					new query3Panel().getPanel().setVisible(true);
				}
			}
		});
		comboBox.setBounds(67, -81, 140, 472);
		return comboBox;
	}
	public MainUIFrame() 
	{
		mainFrame = new JFrame("Main Query Page");
		mainFrame.setSize(850, 650);
		Container c = mainFrame.getContentPane();
		c.setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xpos = (dim.width / 2) - (mainFrame.getWidth() / 2);
		int ypos = (dim.height / 2) - (mainFrame.getHeight() / 2);
		mainFrame.setLocation(xpos, ypos);
		addHeadLabel(mainFrame);
		rightPanel = new JPanel();
		rightPanel.setBounds(312, 56, 532, 550);
		c.add(rightPanel);
		rightPanel.setLayout(null);
		JButton nextButton = new JButton("Next");
		nextButton.setBackground(UIManager.getColor("Button.light"));
		nextButton.setBounds(398, 511, 117, 29);
		rightPanel.add(nextButton);
		addTable(rightPanel);
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.ORANGE);
		leftPanel.setBounds(20, 56, 280, 550);
		c.add(leftPanel);
		leftPanel.setLayout(null);
		leftPanel.add(actionListenerFunc());
		JLabel queryLabel = new JLabel("Queries");
		queryLabel.setFont(new Font("Arial", Font.BOLD, 18));
		queryLabel.setBounds(101, 26, 107, 16);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		leftPanel.add(queryLabel);
		c.setBackground(UIManager.getColor("RadioButton.select"));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
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
       resultTable = new JTable(data, values);
       resultTable.getColumnModel().getColumn(0).setPreferredWidth(40);
       resultTable.getColumnModel().getColumn(3).setPreferredWidth(50);
       resultTable.setBounds(0, 0, 532, 499);
       container.add(resultTable);
	}
	protected JPanel getPanel()
	{
		return this.leftPanel;
	}
}