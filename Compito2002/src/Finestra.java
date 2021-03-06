import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Finestra extends JFrame implements ActionListener, MouseListener, Serializable{

	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem nuovo,salva;
	private JPanel pannello;
	private JTable table;
	private DefaultTableModel dtm;
	private JLabel foto;
	private JTextField t1,t2;
	private PersonaDialog pd;
	private ElencoPersone elenco;
	private ImageIcon icon;
	private JScrollPane jsp;
	
	public Finestra() {
		initMenu();
	}
	
	public void initMenu() {
		this.setLayout(new BorderLayout());
		barra = new JMenuBar();
		menu = new JMenu("FILE");
		nuovo = new JMenuItem("Nuovo");
		nuovo.addActionListener(this);
		salva = new JMenuItem("Salva");
		salva.addActionListener(this);
		menu.add(nuovo);
		menu.add(salva);
		barra.add(menu);
		this.setJMenuBar(barra);
		
		elenco = new ElencoPersone();
		dtm= new DefaultTableModel(new String[] {"COGNOME", "NOME","CLASSE"}, 0);
		table = new JTable(dtm);
		table.addMouseListener(this);
		jsp = new JScrollPane(table);
		pannello = new JPanel();
		pannello.setLayout(new BorderLayout());	
		foto = new JLabel();
		pannello.add(foto, BorderLayout.SOUTH);
		pannello.add(jsp, BorderLayout.NORTH);
		this.add(pannello);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(nuovo)) {
			pd = new PersonaDialog(this, true);
			pd.setVisible(true); 
			if(pd.getRisultato()!=null) {
				elenco.add(pd.getRisultato());
				dtm.addRow(new String[] {pd.getRisultato().getCognome(),pd.getRisultato().getNome(),pd.getRisultato().getClasse()});	
			}
		}
		
		if(e.getSource().equals(salva)) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("File di testo", "csv");
			chooser.setFileFilter(filter);
			int val = chooser.showSaveDialog(this);
			if(val == chooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
			    try {
					f.createNewFile();
					this.convertCsv(f, elenco.elencoStringhe());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void mouseClicked(MouseEvent m) {
		if(m.getSource().equals(table)) {
			if(table.getSelectedRow() != -1) {
				int i = table.getSelectedRow();
				if(elenco.get(i) != null) {
					Persona p = elenco.get(i);
					icon=new ImageIcon(p.getPath());
					foto=new JLabel(icon);
				}
			}
		}	
	}
	//da spostare
	public void convertCsv(File f, ArrayList<String> a){
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			for(String line : a) {
				fw.write(line+"\n");
				
			}			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Finestra f = new Finestra();
		f.setVisible(true);
		f.setSize(600,800);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}