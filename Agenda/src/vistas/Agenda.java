package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;

public class Agenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<entidades.Telefono> list_telefonos = new JList<entidades.Telefono>();
	private JList<entidades.RedSocial> list_redes = new JList<entidades.RedSocial>();
	private JList<entidades.Contacto> list_contactos = new JList<entidades.Contacto>();
	private List<entidades.Contacto> contactos;
	private JTextArea description = new JTextArea();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Agenda frame = new Agenda();

					frame.setVisible(true);
					//Centrar el frame
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Agenda() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblContactos = new JLabel("Contactos");
		lblContactos.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblContactos.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactos.setBounds(5, 5, 657, 16);
		contentPane.add(lblContactos);
		list_contactos.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_contactos.setValueIsAdjusting(true);

		list_contactos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				entidades.Contacto contacto = (entidades.Contacto) (list_contactos
						.getSelectedValue());
				List<entidades.Telefono> telefonos = contacto.getTelefonos();
				List<entidades.RedSocial> redes = contacto.getRedes();

				DefaultListModel<entidades.Telefono> modelo_tel = new DefaultListModel<entidades.Telefono>();
				for (entidades.Telefono telefono : telefonos) {
					modelo_tel.addElement(telefono);
				}
				DefaultListModel<entidades.RedSocial> modelo_red = new DefaultListModel<entidades.RedSocial>();
				for (entidades.RedSocial red : redes) {
					modelo_red.addElement(red);
				}
				//
				list_telefonos.setModel(modelo_tel);
				list_redes.setModel(modelo_red);
				String text = "Nombre: " + contacto.getNombre() + ""
						+ "\nDireccion: " + contacto.getDireccion();
				description.setText(text);

			}
		});
		list_contactos.setBounds(5, 57, 162, 349);

		DefaultListModel<entidades.Contacto> modelo = new DefaultListModel<entidades.Contacto>();
		contactos = new negocio.Agenda().getContactos();
		for (entidades.Contacto contacto : contactos) {
			modelo.addElement(contacto);
		}
		list_contactos.setModel(modelo);
		contentPane.add(list_contactos);
		list_redes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				entidades.RedSocial red = ((entidades.RedSocial) list_redes
						.getSelectedValue());
				
				String text="Cuenta: "+red.getCuenta()+
						"\nTipo: "+red.getTipo().getName();
				description.setText(text);
			}
		});
		list_redes.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_redes.setValueIsAdjusting(true);

		list_redes.setBounds(177, 57, 162, 349);

		contentPane.add(list_redes);
		list_telefonos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				entidades.Telefono tel=((entidades.Telefono)list_telefonos.getSelectedValue());
				
				String text="Numero: "+tel.getNumero()+
						"\nTipo: "+tel.getTipo();
				description.setText(text);
			}
		});
		list_telefonos.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_telefonos.setValueIsAdjusting(true);

		list_telefonos.setBounds(349, 57, 141, 349);

		contentPane.add(list_telefonos);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(5, 32, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblRedesSociales = new JLabel("Redes Sociales");
		lblRedesSociales.setBounds(177, 32, 108, 14);
		contentPane.add(lblRedesSociales);

		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setBounds(349, 32, 71, 14);
		contentPane.add(lblTelefonos);
		description.setLineWrap(true);
		description.setEditable(false);

		description.setBounds(500, 54, 162, 352);
		contentPane.add(description);
	}
}
