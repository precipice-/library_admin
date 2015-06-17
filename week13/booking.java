import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.table.*;

import org.json.simple.*;


class bookGUI extends JFrame {
	private JTextField textField;
	private JTable table;
	
	public void addalltable(){
		
	}
	
	public bookGUI() {
		setTitle("�������� ���α׷�_V1.0");
		JFrame frame = new JFrame();	//����
		getContentPane().setLayout(null);
		//getContentPane().setSize(1024, 512);
		
		JLabel label = new JLabel("�˻� �� ��� :");
		label.setBounds(24, 31, 80, 24);
		getContentPane().add(label);		//�˻��� ����
		
		String itemlist[] = {"ISBN", "��Ϲ�ȣ",  "����",  "����",  "���ǻ�",  "������",  "ī�װ�",  "���ǿ���" , "�����",  "����",};
		
		JComboBox comboBox = new JComboBox(itemlist);
	    comboBox.setBounds(111, 34, 68, 21);
	    getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(190, 33, 489, 21);
		getContentPane().add(textField);
		textField.setColumns(25);
		
		String finder = comboBox.getSelectedItem().toString();
		int finderx = 0;
		for (int i = 0; i < 10; i++){
			if (finder != null & itemlist[i] != null & finder == itemlist[i] ){
				finderx = i;
			}
		} // combobox �� ��������
		
		JButton btnNewButton = new JButton("���");
		btnNewButton.setBounds(700, 32, 80, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String txtinput = textField.getText();
				booking.getinfo(txtinput);
			}
		});
		
		JButton btnNewButton_02 = new JButton("�˻�");
		btnNewButton_02.setBounds(800, 32, 80, 23);
		getContentPane().add(btnNewButton_02);
		
		JButton btnNewButton_1 = new JButton("��ü��ȸ");
		btnNewButton_1.setBounds(900, 32, 80, 23);
		getContentPane().add(btnNewButton_1);		//�˻��� ��
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 80, 984, 307);
		getContentPane().add(panel);	//ǥ �ǳ�
		String[] columnNames = {"ISBN", "����", "����", "���ǻ�", "������", "ī�װ�", "���ǿ���", "�����", "����",  "�޸�"};
		Object[][] data = {{}};
		table = new JTable(data, columnNames);
		
		Vector<String> userColumn = new Vector<String>();
		DefaultTableModel model;
		Object[][] tabledata = {{}};

		//booking.book.get(i).get(itemlist[finderx])  combobox
		
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for (int i = 0; i < booking.book.size(); i++){
					tabledata[i][0] = booking.book.get(i).getIsbn();
					tabledata[i][1] = booking.book.get(i).getTitle();
					tabledata[i][2] = booking.book.get(i).getAuthor();
					tabledata[i][3] = booking.book.get(i).getPublisher();
					tabledata[i][4] = booking.book.get(i).getDate();
					tabledata[i][5] = booking.book.get(i).getCategory();
					tabledata[i][6] = booking.book.get(i).getSale();
					tabledata[i][7] = booking.book.get(i).getDate_reg();
					tabledata[i][8] = booking.book.get(i).getPrice();
					tabledata[i][9] = booking.book.get(i).getMemo();
				}
				table = new JTable(tabledata, columnNames);
				table.tableChanged(new TableModelEvent(table.getModel()));
				//���̺� ������Ʈ
			}
		});
		
		table.setCellSelectionEnabled(true);
		panel.add(table);		//ǥ ��
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1008, 21);
		getContentPane().add(menuBar);	//�޴���
		
		JMenu menu = new JMenu("��  ��");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("�ҷ�����");
		menu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				booking.openbook();
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("�����ϱ�");
		menu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				booking.savebook();
			}
		});
		
		JMenu mnNewMenu = new JMenu("��  ��");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("��ü���");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "�� ��ϱǼ� : " + booking.book.size() + "��");
			}
		});
		
		JMenu menu_1 = new JMenu("����");
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("����");
		menu_1.add(menuItem);		//�޴��� ��
		
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Github �ּ� : ");
			}
		});
		
		JButton btnNewButton_2 = new JButton("�����ϱ�");
		btnNewButton_2.setBounds(140, 400, 137, 49);
		getContentPane().add(btnNewButton_2);		//���� ��ư
		
		JButton button = new JButton("���� ���� �߰�");
		button.setBounds(432, 400, 137, 49);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("���� ��� ��������");
		button_1.setBounds(712, 400, 137, 49);
		getContentPane().add(button_1);		//��ư ��
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	    setVisible(true);
	}
}

public class booking{
	   public static ArrayList<Book> book = new ArrayList<Book>();
	   public static int bookcounter = 0;
	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      bookGUI bg = new bookGUI();
	   }
	   
		public static void getinfo(String isbn){
			try	{
				String domain = "http://apis.daum.net/search/book?apikey=54edcd349fb863882aed3c5b0a5a7349&q=" + isbn + "&output=json";
				
				URL url = new URL(domain);// URL ����
				InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
			
				JSONObject object = (JSONObject)JSONValue.parseWithException(isr);
				
				JSONObject chn = (JSONObject)object.get("channel");
				JSONObject obj = (JSONObject)( (JSONArray)chn.get("item") ).get(0);
				
				String title = (String) obj.get("title");
				String author = (String) obj.get("author") + " "+ (String) obj.get("translator");
				String publisher = (String) obj.get("pub_nm");
				String date = (String) obj.get("pub_date");
				String category = (String) obj.get("category");
				boolean sale = true;
				if ( obj.get("sale_yn") == "N" ){
					sale = false;
				}
				String price = (String) obj.get("sale_price");
				
				autoregister(isbn, title, author, publisher, date, category, sale, price);
				
			}	catch(Exception e)	{
				e.printStackTrace();
			}
		}
		
		public static void autoregister(String isbn, String title, String author, String publisher, String date, String category, boolean sale, String price){
			String memo = null;
			
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
			Date currentTime = new Date ( );
			String mTime = mSimpleDateFormat.format ( currentTime );
			
			JOptionPane.showMessageDialog(null, mTime + "�ð� ���� �Ϸ�.");
			
			String[] twick = mTime.split(".");
			bookcounter ++;
			
			Book nbook = new Book(isbn, title, author, publisher, date, category, sale, mTime, price, memo);
			book.add(nbook);
			
			System.out.println(mTime + "�ÿ�" + "��� �Ϸ�.");
			JOptionPane.showMessageDialog(null, isbn + ", " + mTime + "�ÿ� ��� �Ϸ�.");
			
		}
		
		
		public static void openbook(){
			JFrame window = new JFrame();
			//window.setVisible(true);
			JFileChooser fileChooser = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("dat ����", "dat");
			fileChooser.addChoosableFileFilter(filter);
	        
			int result = fileChooser.showOpenDialog(window);
			System.out.println(result);
			
			if (result == JFileChooser.APPROVE_OPTION) {
	            //������ ������ ��� ��ȯ
	            File selectedFile = fileChooser.getSelectedFile();
				readfile(selectedFile);
	        }
		}
		
		public static void savebook(){
			JFrame window = new JFrame();
			//window.setVisible(true);
			JFileChooser fileChooser = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("dat ����", "dat");
			fileChooser.addChoosableFileFilter(filter);
	        
			int result = fileChooser.showSaveDialog(window);
			System.out.println(result);
			
			if (result == JFileChooser.APPROVE_OPTION) {
	            //������ ������ ��� ��ȯ
	            File selectedFile = fileChooser.getSelectedFile();
				savefile(selectedFile);
	        }
		}
		
		public static void readfile(File selectedFile){
			FileInputStream fin = null;
			ObjectInputStream ois = null;

			try{
				
				fin = new FileInputStream(selectedFile);
				ois = new ObjectInputStream(fin);
				
				book.clear();
				bookcounter = 0;
				ArrayList list = (ArrayList)ois.readObject();
				
				for(int i = 0 ; i < list.size() ; i+=1){
					book.add((Book)list.get(i));
					bookcounter ++;
				}
				System.out.println("���� ����Ʈ ���� �Ϸ�.");
				JOptionPane.showMessageDialog(null, "������ �������ϴ�.");
				
			}catch(Exception ex){
			}finally{
				try{
					ois.close();
					fin.close();
				}catch(IOException ioe){}
			} // finally
		}
		
		public static void savefile(File selectedFile){
			FileOutputStream fout = null;
			ObjectOutputStream oos = null;
			
			try{
				fout = new FileOutputStream(selectedFile);
				oos = new ObjectOutputStream(fout);
				
				oos.writeObject(book);//���� �Է��� ��Ģ�� ���� �ι� �� ����.
				oos.reset();
				oos.writeObject(book);
				oos.reset();
				
				System.out.println("����Ǿ����ϴ�.");
				JOptionPane.showMessageDialog(null, "������ �����߽��ϴ�.");
				
			}catch(Exception ex){
			}finally{
				try{
					oos.close();
					fout.close();
				}catch(IOException ioe){}
			} // finally
		}
}
