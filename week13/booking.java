import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.table.*;

import org.json.simple.*;


class bookGUI extends JFrame {
	private JTextField textField;
	private JTable table;
	
	public bookGUI() {
		JFrame frame = new JFrame();
		frame.setTitle("�������� ���α׷�_V1.1");
		getContentPane().setLayout(new BorderLayout(0,0));
		//getContentPane().setSize(1024, 512);
		
		JPanel panel = new JPanel();
		JPanel panelb = new JPanel();
		JPanel panelc = new JPanel();
		JScrollPane listJs;
		
		frame.add(panelb , BorderLayout.SOUTH);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(panelc, BorderLayout.CENTER);
		
		//panelc
		DefaultTableModel defaulttablemodel = null;
		Vector<String> columnNames = null;
		Vector<Vector<String>> data = null;
		
		columnNames = new Vector<String>();
		columnNames.add("ISBN");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("���ǻ�");
		columnNames.add("������");
		columnNames.add("ī�װ�");
		columnNames.add("���ǿ���");
		columnNames.add("�����");
		columnNames.add("����");
		columnNames.add("�޸�");
		data = new Vector<Vector<String>>();
		//data.addRow("ISBN", "��Ϲ�ȣ",  "����",  "����",  "���ǻ�",  "������",  "ī�װ�",  "���ǿ���" , "�����",  "����");
		
		
		table = new JTable(new DefaultTableModel(columnNames, 0));
		listJs = new JScrollPane(table);
		panelc.add(listJs);
		table.setCellSelectionEnabled(true);

				
		//panelb  
		JLabel label = new JLabel("��� �� �˻�      :        ");
		
		String itemlist[] = {"ISBN", "����",  "����",  "���ǻ�",  "������",  "ī�װ�",  "���ǿ���" , "�����",  "����", "�޸�"};
		
		JComboBox comboBox = new JComboBox(itemlist);
		String finder = comboBox.getSelectedItem().toString();
		int finderx = 0;
		for (int i = 0; i < 10; i++){
			if (finder != null & itemlist[i] != null & finder == itemlist[i] ){
				finderx = i;
			}
		} // combobox �� ��������
		
		textField = new JTextField();
		textField.setColumns(25);
		  
		JLabel lblNewLabel = new JLabel("        ");
		JButton btnNewButton = new JButton("��   ��");
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String txtinput = textField.getText();
				booking.getinfo(txtinput);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("     ");
		JButton btnNewButton_1 = new JButton("��   ��");
		
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				DefaultTableModel defaulttablemodel = (DefaultTableModel) table.getModel();
				Object[] rowdata = new Object[] {};
				
				if (defaulttablemodel.getRowCount() > 0) {
				    for (int i = defaulttablemodel.getRowCount() - 1; i > -1; i--) {
				    	defaulttablemodel.removeRow(i);
				    }
				}
				String txtinput = textField.getText();
				int searchvalue = 0;
				for (int i = 0; i < 10; i ++){
					if (finder == itemlist[i]){
						searchvalue = i;
					}//�޺��ڽ� �� ��������
				}
				for (int i = 0; i < booking.book.size(); i ++){
					String sale = null;
					if (booking.book.get(i).getSale() == true){
						sale = "Y";
					} else {sale = "N";}
					String[] data = {booking.book.get(i).getIsbn(), booking.book.get(i).getTitle(), booking.book.get(i).getAuthor(), booking.book.get(i).getPublisher(), booking.book.get(i).getDate(), sale, booking.book.get(i).getDate_reg(), booking.book.get(i).getCategory(), booking.book.get(i).getPrice(), booking.book.get(i).getMemo()};
					
					if (txtinput == data[i]){
						String data1 = booking.book.get(i).getIsbn();
						String data2 = booking.book.get(i).getTitle();
						String data3 = booking.book.get(i).getAuthor();
						String data4 = booking.book.get(i).getPublisher();
						String data5 = booking.book.get(i).getDate();
						String data6 = sale;
						String data7 = booking.book.get(i).getDate_reg();
						String data8 = booking.book.get(i).getCategory();
						String data9 = booking.book.get(i).getPrice();
						String data10 = booking.book.get(i).getMemo();
						
						rowdata = new Object[] {data1, data2, data3, data4, data5, data6, data7, data8, data9, data10};
						
						defaulttablemodel.addRow(rowdata);
						//bookdata.removeAllElements();
						rowdata = null;
						//defaulttablemodel.fireTableDataChanged();
						panelc.updateUI();
					}
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					defaulttablemodel.fireTableDataChanged();
					panelc.updateUI();
				}
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				defaulttablemodel.fireTableDataChanged();
				panelc.updateUI();
			}
		});
		
		
		
		JLabel lblNewLabel_2 = new JLabel("     ");
		JButton btnNewButton_2 = new JButton("��ü ��ȸ");
		
		
		btnNewButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//final Vector<String> columnNames= new Vector<String>();
				//final Vector<Vector<String>> data = new Vector<Vector<String>>();
				//data = 
				/*columnNames.add("ISBN");
				columnNames.add("����");
				columnNames.add("����");
				columnNames.add("���ǻ�");
				columnNames.add("������");
				columnNames.add("ī�װ�");
				columnNames.add("���ǿ���");
				columnNames.add("�����");
				columnNames.add("����");
				columnNames.add("�޸�");*/
				DefaultTableModel defaulttablemodel = (DefaultTableModel) table.getModel();
				
				if (defaulttablemodel.getRowCount() > 0) {
				    for (int i = defaulttablemodel.getRowCount() - 1; i > -1; i--) {
				    	defaulttablemodel.removeRow(i);
				    }
				}
				
				Vector<Vector<String>> allbookdata = new Vector<Vector<String>>();
				Vector<String> bookdata = new Vector<String>();
				Object[] rowdata = new Object[] {};
				//final JTable table = new JTable(defaulttablemodel);
				for (int i = 0; i < booking.book.size(); i++){
					String sale = null;
					if (booking.book.get(i).getSale() == true){
						sale = "Y";
					} else {sale = "N";}
					
					/*bookdata.add(booking.book.get(i).getIsbn());
					bookdata.add(booking.book.get(i).getTitle());
					bookdata.add(booking.book.get(i).getAuthor());
					bookdata.add(booking.book.get(i).getPublisher());
					bookdata.add(booking.book.get(i).getDate());
					bookdata.add(sale);
					bookdata.add(booking.book.get(i).getDate_reg());
					bookdata.add(booking.book.get(i).getCategory());
					bookdata.add(booking.book.get(i).getPrice());
					bookdata.add(booking.book.get(i).getMemo());*/
					
					String data1 = booking.book.get(i).getIsbn();
					String data2 = booking.book.get(i).getTitle();
					String data3 = booking.book.get(i).getAuthor();
					String data4 = booking.book.get(i).getPublisher();
					String data5 = booking.book.get(i).getDate();
					String data6 = sale;
					String data7 = booking.book.get(i).getDate_reg();
					String data8 = booking.book.get(i).getCategory();
					String data9 = booking.book.get(i).getPrice();
					String data10 = booking.book.get(i).getMemo();
					
					rowdata = new Object[] {data1, data2, data3, data4, data5, data6, data7, data8, data9, data10};
					
					defaulttablemodel.addRow(rowdata);
					//bookdata.removeAllElements();
					rowdata = null;
					System.out.println(allbookdata);
					//defaulttablemodel.fireTableDataChanged();
					panelc.updateUI();
				}
				//defaulttablemodel.addRow(allbookdata);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				defaulttablemodel.fireTableDataChanged();
				panelc.updateUI();
			}
		});
			
		panel.add(label);
		panel.add(comboBox);
		panel.add(textField);
		panel.add(lblNewLabel_2);
		panel.add(btnNewButton_1);
		panel.add(lblNewLabel_1);
		panel.add(btnNewButton);
		panel.add(lblNewLabel);
		panel.add(btnNewButton_2);
		
		//panelb
		JButton btnNewButton_3 = new JButton("��   ��   ��   ��");
		JLabel lblNewLabel_3 = new JLabel("          ");
		JButton btnNewButton_4 = new JButton("��   ��   ��   ��");
		JLabel lblNewLabel_4 = new JLabel("          ");
		JButton btnNewButton_5= new JButton("���� ��� ��������");

		panelb.add(lblNewLabel_3);
		panelb.add(lblNewLabel_4);
		panelb.add(btnNewButton_4);
		panelb.add(btnNewButton_3);
		panelb.add(btnNewButton_5);
	
		//menubar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
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
				JOptionPane.showMessageDialog(null, "Github �ּ� : https://github.com/precipice-/library_admin ");
			}
		});

		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		//menubar end
	}
}


public class booking{
	   public static ArrayList<Book> book = new ArrayList<Book>();
	   public static int bookcounter = 0;

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      bookGUI bg = new bookGUI();
	   }
	   
		/**
		 * @wbp.parser.entryPoint
		 */
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
			JOptionPane.showMessageDialog(null, isbn + ", " + title + ", " + author + ", " + publisher + ", " + date + ", " + category + ", " + sale + ", " + mTime + ", " + price + ", " + memo);
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
