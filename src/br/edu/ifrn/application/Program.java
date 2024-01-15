package br.edu.ifrn.application;
import javax.swing.*;

import br.edu.ifrn.entities.Contact;
import br.edu.ifrn.entities.PhoneBook;
import br.edu.ifrn.entities.Serialization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;

public class Program{
	private static JButton btnBuscar, btnRemover, btnInserir;
	private static JTextPane txtpnEscolhaUmaDas;
	private static JPanel panel_inserir;
	private static JLabel lblNewLabel;
	private static JTextField name_inserir;
	private static JTextField phone_inserir;
	private static JPanel panel_buscar;
	private static JLabel lblNewLabel_1;
	private static JTextField name_buscar;
	private static JButton btnBuscar_1;
	private static JPanel panel_remover;
	private static JLabel lblNewLabel_2;
	private static JTextField name_remover;
	private static JButton btnRemover_1;
	private static JLabel info_remover;
	private static JLabel info_buscar;
	private static JLabel info_inserir;
	private static JButton btn_exibirLista;
	private static JPanel panel_exibirLista;
    
	private static JList<String> list;
    private static DefaultListModel<String> model = new DefaultListModel<>();
    private static JButton updateContacts;
    
	
    
	
	public static void main(String[] args) throws Exception {
		
		PhoneBook phonebook = new PhoneBook();
		
		JFrame frame = new JFrame("Phone Book");
		frame.getContentPane().setBackground(new Color(9, 9, 11));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-129, 0, 843, 74);
		panel.setBackground(new Color(129, 140, 248));
		panel.setForeground(new Color(129, 140, 248));
		panel.setToolTipText("Phone Book - Anderson Paiva");
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btn_exibirLista = new JButton("exibir lista");
		btn_exibirLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeSelectedButton("exibir");
				
				model.clear();
				
				ArrayList<Contact> contacts = new ArrayList<Contact>(phonebook.deepCopyContacts());
				
				for(Contact contact: contacts) {
					model.addElement(contact.getName() + " - " + contact.getPhoneNumber());
				}			
			}
		});
		
		System.out.println(phonebook.lenghtContacts());

		btn_exibirLista.setForeground(new Color(255, 255, 255));
		btn_exibirLista.setBackground(new Color(9, 9, 11));
		btn_exibirLista.setFont(new Font("Arial", Font.BOLD, 14));
		btn_exibirLista.setBounds(580, 20, 109, 34);
		panel.add(btn_exibirLista);
		
		JButton saveContacts = new JButton("salvar");
		saveContacts.setBounds(172, 27, 89, 23);
		saveContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serialization serialization = new Serialization();
				serialization.saveContactList(phonebook.deepCopyContacts());
			}
		});
		panel.add(saveContacts);
		
		updateContacts = new JButton("atualizar");
		updateContacts.setBounds(279, 27, 89, 23);
		updateContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phonebook.updateContactList();
			}
		});
	
		
		panel.add(updateContacts);
		btn_exibirLista.setVisible(false);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 11));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(129, 140, 248));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeSelectedButton("buscar");
				setVisibleInfo(false);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(113, 113, 122));
		panel_1.setBounds(0, 483, 584, 1);
		frame.getContentPane().add(panel_1);
		btnBuscar.setBounds(228, 508, 127, 29);
		
		frame.getContentPane().add(btnBuscar);
		
		btnRemover = new JButton("REMOVER");
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 11));
		btnRemover.setBackground(new Color(129, 140, 248));
		btnRemover.setBounds(409, 508, 127, 29);
		frame.getContentPane().add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeSelectedButton("remover");
				setVisibleInfo(false);
			}
		});
		
		btnInserir = new JButton("INSERIR");
		btnInserir.setForeground(Color.WHITE);
		btnInserir.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 11));
		btnInserir.setBackground(new Color(129, 140, 248));
		btnInserir.setBounds(43, 508, 127, 29);
		frame.getContentPane().add(btnInserir);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeSelectedButton("inserir");
				setVisibleInfo(false);
			}
		});
		
		panel_exibirLista = new JPanel();
		panel_exibirLista.setBackground(new Color(9, 9, 11));
		panel_exibirLista.setBounds(61, 117, 462, 327);
		frame.getContentPane().add(panel_exibirLista);
		panel_exibirLista.setLayout(null);
		panel_exibirLista.setVisible(false);
		
		JTextPane title_exibirLista = new JTextPane();
		title_exibirLista.setEditable(false);
		title_exibirLista.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		title_exibirLista.setBackground(new Color(9, 9, 11));
		title_exibirLista.setForeground(new Color(113, 113, 122));
		title_exibirLista.setText("Lista dos contatos adicionados");
		title_exibirLista.setBounds(115, 5, 231, 28);
		panel_exibirLista.add(title_exibirLista);
        
        list = new JList<>(model);
        list.setForeground(new Color(113, 113, 122));
        list.setBackground(new Color(9, 9, 11));
        list.setFixedCellWidth(150);
        list.setFixedCellHeight(20);
        
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setSize(230, 150);
        scrollPane.setLocation(116, 63);
        panel_exibirLista.add(scrollPane);
        
        
		panel_remover = new JPanel();
		panel_remover.setBackground(new Color(9, 9, 11));
		panel_remover.setBounds(149, 214, 285, 132);
		frame.getContentPane().add(panel_remover);
		panel_remover.setLayout(null);
		
		lblNewLabel_2 = new JLabel("nome");
		lblNewLabel_2.setBounds(126, 41, 32, 14);
		lblNewLabel_2.setForeground(new Color(113, 113, 122));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_remover.add(lblNewLabel_2);
		
		name_remover = new JTextField();
		name_remover.setBounds(82, 56, 120, 20);
		name_remover.setColumns(10);
		panel_remover.add(name_remover);
		
		btnRemover_1 = new JButton("remover");
		btnRemover_1.setForeground(Color.WHITE);
		btnRemover_1.setBackground(new Color(13, 197, 94));
		btnRemover_1.setBounds(82, 80, 120, 23);
		btnRemover_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_remover.getText();
				boolean deletedContact = phonebook.delete(name);
				
				info_remover.setVisible(true);
				if(deletedContact) {
					info_remover.setForeground(new Color(13, 197, 94));
					info_remover.setText("contato removido");
					if(phonebook.lenghtContacts() == 0) {
						btn_exibirLista.setVisible(false);
					}
				} else {
					info_remover.setForeground(new Color(241, 40, 35));
					info_remover.setText("contato nao encontrado. Reveja o nome.");
				}
			}
		});
		panel_remover.add(btnRemover_1);
		
		info_remover = new JLabel("");
		info_remover.setHorizontalAlignment(SwingConstants.CENTER);
		info_remover.setForeground(new Color(241, 40, 35));
		info_remover.setBounds(10, 114, 265, 14);
		panel_remover.add(info_remover);
		
		panel_buscar = new JPanel();
		panel_buscar.setBackground(new Color(9, 9, 11));
		panel_buscar.setForeground(new Color(9, 9, 11));
		panel_buscar.setBounds(149, 214, 285, 132);
		frame.getContentPane().add(panel_buscar);
		panel_buscar.setLayout(null);
		
		lblNewLabel_1 = new JLabel("nome");
		lblNewLabel_1.setForeground(new Color(113, 113, 122));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(126, 40, 32, 14);
		panel_buscar.add(lblNewLabel_1);
		
		name_buscar = new JTextField();
		name_buscar.setColumns(10);
		name_buscar.setBounds(82, 56, 120, 20);
		panel_buscar.add(name_buscar);
		
		btnBuscar_1 = new JButton("buscar");
		btnBuscar_1.setForeground(Color.WHITE);
		btnBuscar_1.setBackground(new Color(13, 197, 94));
		btnBuscar_1.setBounds(82, 80, 120, 23);
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_buscar.getText();
				Contact contactFound = phonebook.search(name);
							
				info_buscar.setVisible(true);
				if(contactFound != null) {
					info_buscar.setForeground(new Color(13, 197, 94));
					info_buscar.setText(name + " está na lista!");
				} else {
					info_buscar.setForeground(new Color(241, 40, 35));
					info_buscar.setText("contato nao encontrado. Reveja o nome.");
				}
			}
		});
		panel_buscar.add(btnBuscar_1);
		
		info_buscar = new JLabel("");
		info_buscar.setHorizontalAlignment(SwingConstants.CENTER);
		info_buscar.setForeground(new Color(241, 40, 35));
		info_buscar.setBounds(10, 114, 265, 14);
		panel_buscar.add(info_buscar);
		
		panel_inserir = new JPanel();
		panel_inserir.setBackground(new Color(9, 9, 11));
		panel_inserir.setBounds(150, 207, 283, 147);
		frame.getContentPane().add(panel_inserir);
		panel_inserir.setLayout(null);
		
		lblNewLabel = new JLabel("nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(113, 113, 122));
		lblNewLabel.setBounds(125, 11, 32, 14);
		panel_inserir.add(lblNewLabel);
		
		name_inserir = new JTextField();
		name_inserir.setBounds(81, 25, 120, 20);
		panel_inserir.add(name_inserir);
		name_inserir.setColumns(10);
		
		JLabel lblTelefone = new JLabel("telefone");
		lblTelefone.setForeground(new Color(113, 113, 122));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(118, 50, 47, 14);
		panel_inserir.add(lblTelefone);
		
		phone_inserir = new JTextField();
		phone_inserir.setColumns(10);
		phone_inserir.setBounds(81, 65, 120, 20);
		panel_inserir.add(phone_inserir);
		
		JButton btnNewButton = new JButton("cadastrar");
		btnNewButton.setBackground(new Color(13, 197, 94));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(81, 96, 120, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_inserir.getText();
				String phone = phone_inserir.getText();
				boolean addedContact = phonebook.insert(name, phone);
				
				info_inserir.setVisible(true);
				if(addedContact) {
					info_inserir.setForeground(new Color(13, 197, 94));
					info_inserir.setText("contato inserido");
					if(phonebook.lenghtContacts() > 0) {
						btn_exibirLista.setVisible(true);
					}
				} else {
					info_inserir.setForeground(new Color(241, 40, 35));
					info_inserir.setText(name + " já está na lista");
				}
			}
		});
		panel_inserir.add(btnNewButton);
		
		info_inserir = new JLabel("inserido");
		info_inserir.setHorizontalAlignment(SwingConstants.CENTER);
		info_inserir.setForeground(new Color(241, 40, 35));
		info_inserir.setBounds(10, 130, 263, 14);
		panel_inserir.add(info_inserir);
		panel_inserir.setVisible(false);
		
		txtpnEscolhaUmaDas = new JTextPane();
		txtpnEscolhaUmaDas.setEditable(false);
		txtpnEscolhaUmaDas.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		txtpnEscolhaUmaDas.setForeground(new Color(113, 113, 122));
		txtpnEscolhaUmaDas.setBackground(new Color(9, 9, 11));
		txtpnEscolhaUmaDas.setText("escolha uma das opcoes abaixo para ser exibida!");
		txtpnEscolhaUmaDas.setBounds(198, 255, 188, 50);
		
		panel_inserir.setVisible(false);
		panel_buscar.setVisible(false);
		panel_remover.setVisible(false);
		
		
		frame.getContentPane().add(txtpnEscolhaUmaDas);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void changeSelectedButton(String type) {
		if(type == "buscar") {
			btnBuscar.setBackground(new Color(13, 197, 94));
			btnInserir.setBackground(new Color(129, 140, 248));
			btnRemover.setBackground(new Color(129, 140, 248));
			
			panel_inserir.setVisible(false);
			panel_buscar.setVisible(true);
			panel_remover.setVisible(false);
			panel_exibirLista.setVisible(false);
		} else if(type == "inserir") {
			btnInserir.setBackground(new Color(13, 197, 94));
			btnBuscar.setBackground(new Color(129, 140, 248));
			btnRemover.setBackground(new Color(129, 140, 248));

			panel_inserir.setVisible(true);
			panel_buscar.setVisible(false);
			panel_remover.setVisible(false);
			panel_exibirLista.setVisible(false);
		} else if(type == "remover") {
			btnRemover.setBackground(new Color(13, 197, 94));
			btnBuscar.setBackground(new Color(129, 140, 248));
			btnInserir.setBackground(new Color(129, 140, 248));
			
			panel_inserir.setVisible(false);
			panel_buscar.setVisible(false);
			panel_remover.setVisible(true);
			panel_exibirLista.setVisible(false);
		} else {
			btnRemover.setBackground(new Color(129, 140, 248));
			btnBuscar.setBackground(new Color(129, 140, 248));
			btnInserir.setBackground(new Color(129, 140, 248));
			
	
			panel_inserir.setVisible(false);
			panel_buscar.setVisible(false);
			panel_remover.setVisible(false);
			txtpnEscolhaUmaDas.setVisible(false);
			panel_exibirLista.setVisible(true);
		}
		
		txtpnEscolhaUmaDas.setVisible(false);
	
	}
	
	private static void setVisibleInfo(boolean option) {
		info_remover.setVisible(option);
		info_inserir.setVisible(option);
		info_buscar.setVisible(option);
	}
}