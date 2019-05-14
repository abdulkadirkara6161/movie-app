package moviebo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;

public class movie extends JFrame {
	
	fileOperations fo = new fileOperations();
	DefaultTableModel model;

	private JPanel contentPane;
	private JTextField txtDirector;
	private JTextField txtMovie;
	private JTextField txtActor;
	private JTextField txtCategory;
	private JTextField txtYear;
	private JTable table;
	JPanel pnlList;
	JPanel pnlEmpty;
	JPanel pnlAdd;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movie frame = new movie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public movie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 201, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlEmpty.setVisible(false);
				pnlList.setVisible(false);
				pnlAdd.setVisible(true);
			}
		});
		btnAdd.setBounds(32, 104, 139, 28);
		panel.add(btnAdd);
		
		JButton btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlEmpty.setVisible(false);
				pnlAdd.setVisible(false);
				pnlList.setVisible(true);
				
				
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				
				ArrayList<movieInfo> movies = new ArrayList<movieInfo>();
				
				movies = fo.readInfo();
			
				if (movies != null ) {
		            
		            for (movieInfo inf : movies) {
		                Object[] addMovie = {inf.getDirector(),inf.getMovie(),inf.getActor(),inf.getCategory(),inf.getYear()};
		                
		                model.addRow(addMovie);
		               
		            }
		            
		        }
				
				
				
			}
		});
		btnList.setBounds(32, 212, 139, 28);
		panel.add(btnList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(199, 0, 441, 397);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 441, 397);
		panel_1.add(layeredPane);
		layeredPane.setLayout(null);
		
		pnlEmpty = new JPanel();
		pnlEmpty.setBackground(SystemColor.controlHighlight);
		pnlEmpty.setBounds(0, 0, 441, 397);
		layeredPane.add(pnlEmpty);
		pnlEmpty.setLayout(null);
		
		pnlList = new JPanel();
		pnlList.setBounds(0, 0, 441, 397);
		layeredPane.add(pnlList);
		pnlList.setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(10, 259, 139, 28);
		pnlList.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				
				}
		});
		btnUpdate.setBounds(267, 259, 139, 28);
		pnlList.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 421, 129);
		pnlList.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie", "Director", "Actor", "Category", "Year"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		
		pnlAdd = new JPanel();
		pnlAdd.setBounds(0, 0, 441, 397);
		layeredPane.add(pnlAdd);
		pnlAdd.setLayout(null);
		
		txtDirector = new JTextField();
		txtDirector.setBounds(188, 87, 96, 19);
		pnlAdd.add(txtDirector);
		txtDirector.setColumns(10);
		
		txtMovie = new JTextField();
		txtMovie.setColumns(10);
		txtMovie.setBounds(188, 127, 96, 19);
		pnlAdd.add(txtMovie);
		
		txtActor = new JTextField();
		txtActor.setColumns(10);
		txtActor.setBounds(188, 170, 96, 19);
		pnlAdd.add(txtActor);
		
		txtCategory = new JTextField();
		txtCategory.setColumns(10);
		txtCategory.setBounds(188, 212, 96, 19);
		pnlAdd.add(txtCategory);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(188, 255, 96, 19);
		pnlAdd.add(txtYear);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDirector.setBounds(66, 95, 70, 24);
		pnlAdd.add(lblDirector);
		
		JLabel lblMovieName = new JLabel("Movie Name");
		lblMovieName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMovieName.setBounds(28, 135, 108, 24);
		pnlAdd.add(lblMovieName);
		
		JLabel lblActor = new JLabel("Actor");
		lblActor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblActor.setBounds(66, 173, 70, 24);
		pnlAdd.add(lblActor);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCategory.setBounds(66, 212, 70, 24);
		pnlAdd.add(lblCategory);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblYear.setBounds(66, 255, 70, 24);
		pnlAdd.add(lblYear);
		
		JButton btnAddMovie = new JButton("Add Movie");
		btnAddMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String director = txtDirector.getText();
				String movie = txtMovie.getText();
				String actor = txtActor.getText();
				String category = txtCategory.getText();
				String year = txtYear.getText();
				
				
				fo.writeInfo(director, movie, actor, category, year);
				
				
				
			}
		});
		btnAddMovie.setBounds(188, 307, 108, 34);
		pnlAdd.add(btnAddMovie);
	}
}
