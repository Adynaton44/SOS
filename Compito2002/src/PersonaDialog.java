
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PersonaDialog extends JDialog implements ActionListener {
	public JLabel l1,l2,l3,l4;
	public JTextField t1,t2,t3,t4;
	public JButton chiudi,salva;
	public ImageIcon image;
	public Persona p;
	
	public PersonaDialog(JFrame finestra, boolean modal) {
		super(finestra, modal);
		setSize(600,600);
		setLayout(new GridLayout(5,2));
		initComponents();
	}
	
public void  initComponents() {
		
		l1 = new JLabel("Nome:  ");
		t1 = new JTextField(10);
		l2 = new JLabel("Cognome ");
		t2 = new JTextField(10);
		l3=new JLabel("Classe");
		t3=new JTextField(10);
		l4=new JLabel("Path");
		t4=new JTextField(10);
		chiudi=new JButton("CHIUDI");
		chiudi.addActionListener(this);
		salva=new JButton ("SALVA");
		salva.addActionListener(this);
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(l3);
		this.add(t3);
		this.add(l4);
		this.add(t4);
		this.add(salva);
		this.add(chiudi);
}

public Persona getRisultato() {
	return p;
}

@Override
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource().equals(chiudi)) {
		dispose();
	}

	if(e.getSource().equals(salva)) {
			p=new Persona(t1.getText(),t2.getText(),t3.getText(),t4.getText());
		}		
	}
}