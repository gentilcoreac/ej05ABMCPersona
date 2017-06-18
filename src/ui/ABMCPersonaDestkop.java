package ui;

import entity.*;
import controlers.*;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ABMCPersonaDestkop extends JFrame {
	
	CtrlABMPersona ctrl = new CtrlABMPersona();

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;	
	private JCheckBox chkHabilitado;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnBuscar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaDestkop frame = new ABMCPersonaDestkop();
					frame.setVisible(true);
				}
					catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public ABMCPersonaDestkop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCargaDeDatos = new JLabel("Carga de datos");
		
		JLabel lblDni = new JLabel("DNI");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);

		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setSelected(true);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});		
				
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				agregarClick();
			}
		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter(){
		@Override
			public void mouseClicked(MouseEvent e){
				borrarClick();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter(){
		@Override
			public void mouseClicked(MouseEvent e){
				modificarClick();
			}
		});
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNombre)
					.addGap(18)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(lblApellido)
					.addGap(18)
					.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(chkHabilitado))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(102)
					.addComponent(btnBorrar)
					.addGap(12)
					.addComponent(btnModificar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAgregar)
					.addGap(27))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addComponent(lblDni)
					.addGap(18)
					.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(btnBuscar)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCargaDeDatos)
					.addContainerGap(290, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCargaDeDatos)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDni))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNombre))
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblApellido))
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(chkHabilitado)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnAgregar)
						.addComponent(btnModificar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void buscarClick() {
		this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));		
	}
	
	protected void agregarClick(){
		ctrl.add(this.mapearDeForm());
		this.limpiarTextos();
	}
	

	private void borrarClick() {
		ctrl.delete(this.mapearDeForm());
		this.limpiarTextos();
	}	
	
	private void modificarClick(){
		/*
		ctrl.update(this.mapearDeForm());
		*/
		ctrl.delete(this.mapearDeForm());
		ctrl.add(this.mapearDeForm());

		this.limpiarTextos();
	}
	
	private void mapearAForm(Persona p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.chkHabilitado.setSelected(p.isHabilitado());
	}
	
	private Persona mapearDeForm(){
		Persona p= new Persona();
		p.setDni(this.txtDni.getText());
		p.setNombre(this.txtNombre.getText());
		p.setApellido(this.txtApellido.getText());
		p.setHabilitado(this.chkHabilitado.isSelected());
		return p;
	}
	
	private void limpiarTextos(){
		this.txtDni.setText("");
		this.txtNombre.setText("");
		this.txtApellido.setText("");		
	}
}