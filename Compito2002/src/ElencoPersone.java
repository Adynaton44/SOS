import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ElencoPersone extends ArrayList<Persona> {

	
	
	public ArrayList<String> elencoStringhe(){
		ArrayList<String> l=new ArrayList<String>();
		for(int i=0;i<this.size();i++) {
			l.add(this.get(i).toString());
		}
		return l;
	}
}