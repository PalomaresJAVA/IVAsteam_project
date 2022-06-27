import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImpuestoIvaSteam {
	
	private JFrame marco;
	private JTextField precio, precioConIva;
	private JLabel lPrecio, lPrecio2;
	private JButton b, b2;
	private JPanel p1, p2, p3;
	private ImageIcon img;
	
	public ImpuestoIvaSteam() {
		marco = new JFrame("IVA Steam");
		precio = new JTextField("0.0", 10);
		precioConIva = new JTextField("0.0", 10);
		lPrecio = new JLabel("$  ", SwingConstants.RIGHT);
		lPrecio2 = new JLabel("$  ", SwingConstants.RIGHT);
		b = new JButton("Convertir");
		b2 = new JButton("Limpiar");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		img = new ImageIcon("F:\\Descargas\\JAVA iva Steam\\ivaSTEAM.png");
	}
	
	public void runMarco() {
		p1.setLayout(new FlowLayout());
		p2.setLayout(new GridLayout(1, 2));
		p3.setLayout(new FlowLayout());
		
		p1.setBackground(Color.LIGHT_GRAY);
		p2.setBackground(Color.LIGHT_GRAY);
		p3.setBackground(Color.LIGHT_GRAY);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b2.setBorderPainted(false);
		b2.setFocusPainted(false);
		precioConIva.setFocusable(false);
		precio.setHorizontalAlignment(JTextField.CENTER);
		precioConIva.setHorizontalAlignment(JTextField.CENTER);
		
		Font f = new Font("Calibri", Font.BOLD, 20);
		precioConIva.setFont(f);
		precio.setFont(f);
		lPrecio.setFont(f);
		lPrecio2.setFont(f);
			
		p1.add(lPrecio);
		p1.add(precio);
		p2.add(b);
		p2.add(b2);
		p3.add(lPrecio2);
		p3.add(precioConIva);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				double nPrecio, nPrecioFinal = 0.0;
				
				if(precio.getText() != null && precioConIva.getText() != null) {
					nPrecio = Double.parseDouble(precio.getText());
					nPrecioFinal = Double.parseDouble(precioConIva.getText());
					
					if(source == b) {
						nPrecioFinal = nPrecio * 1.64;
					}
					precioConIva.setText("" + nPrecioFinal);
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precio.setText("0.0");
				precioConIva.setText("0.0");
			}
		});
		
		marco.setLayout(new BorderLayout());
		marco.add(p1, BorderLayout.NORTH);
		marco.add(p2, BorderLayout.CENTER);
		marco.add(p3, BorderLayout.SOUTH);
		
		
		int ef = 9;
		
		p2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(ef, ef, ef, ef), 
				BorderFactory.createLoweredBevelBorder()));
		
		marco.setIconImage(img.getImage());
		marco.setSize(new Dimension(500, 175));
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setLocationRelativeTo(null);
		marco.setVisible(true);
		marco.setResizable(false);
	}

	public static void main(String[] args) {
		ImpuestoIvaSteam s = new ImpuestoIvaSteam();
		s.runMarco();
	}

}
