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
		setTitle("도서관리 프로그램_V1.0");
		JFrame frame = new JFrame();	//제목
		getContentPane().setLayout(null);
		//getContentPane().setSize(1024, 512);
		
		JLabel label = new JLabel("검색 및 등록 :");
		label.setBounds(24, 31, 80, 24);
		getContentPane().add(label);		//검색바 시작
		
		String itemlist[] = {"ISBN", "등록번호",  "제목",  "저자",  "출판사",  "출판일",  "카테고리",  "절판여부" , "등록일",  "가격",};
		
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
		} // combobox 값 가져오기
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setBounds(700, 32, 80, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String txtinput = textField.getText();
				booking.getinfo(txtinput);
			}
		});
		
		JButton btnNewButton_02 = new JButton("검색");
		btnNewButton_02.setBounds(800, 32, 80, 23);
		getContentPane().add(btnNewButton_02);
		
		JButton btnNewButton_1 = new JButton("전체조회");
		btnNewButton_1.setBounds(900, 32, 80, 23);
		getContentPane().add(btnNewButton_1);		//검색바 끝
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 80, 984, 307);
		getContentPane().add(panel);	//표 판넬
		String[] columnNames = {"ISBN", "제목", "저자", "출판사", "출판일", "카테고리", "절판여부", "등록일", "가격",  "메모"};
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
				//테이블 업데이트
			}
		});
		
		table.setCellSelectionEnabled(true);
		panel.add(table);		//표 끝
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1008, 21);
		getContentPane().add(menuBar);	//메뉴바
		
		JMenu menu = new JMenu("파  일");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("불러오기");
		menu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				booking.openbook();
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("저장하기");
		menu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				booking.savebook();
			}
		});
		
		JMenu mnNewMenu = new JMenu("통  계");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("전체통계");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "총 등록권수 : " + booking.book.size() + "권");
			}
		});
		
		JMenu menu_1 = new JMenu("도움말");
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("정보");
		menu_1.add(menuItem);		//메뉴바 끝
		
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Github 주소 : ");
			}
		});
		
		JButton btnNewButton_2 = new JButton("삭제하기");
		btnNewButton_2.setBounds(140, 400, 137, 49);
		getContentPane().add(btnNewButton_2);		//밑줄 버튼
		
		JButton button = new JButton("같은 도서 추가");
		button.setBounds(432, 400, 137, 49);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("현재 목록 내보내기");
		button_1.setBounds(712, 400, 137, 49);
		getContentPane().add(button_1);		//버튼 끝
		
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
				
				URL url = new URL(domain);// URL 설정
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
			
			JOptionPane.showMessageDialog(null, mTime + "시간 수집 완료.");
			
			String[] twick = mTime.split(".");
			bookcounter ++;
			
			Book nbook = new Book(isbn, title, author, publisher, date, category, sale, mTime, price, memo);
			book.add(nbook);
			
			System.out.println(mTime + "시에" + "등록 완료.");
			JOptionPane.showMessageDialog(null, isbn + ", " + mTime + "시에 등록 완료.");
			
		}
		
		
		public static void openbook(){
			JFrame window = new JFrame();
			//window.setVisible(true);
			JFileChooser fileChooser = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("dat 파일", "dat");
			fileChooser.addChoosableFileFilter(filter);
	        
			int result = fileChooser.showOpenDialog(window);
			System.out.println(result);
			
			if (result == JFileChooser.APPROVE_OPTION) {
	            //선택한 파일의 경로 반환
	            File selectedFile = fileChooser.getSelectedFile();
				readfile(selectedFile);
	        }
		}
		
		public static void savebook(){
			JFrame window = new JFrame();
			//window.setVisible(true);
			JFileChooser fileChooser = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("dat 파일", "dat");
			fileChooser.addChoosableFileFilter(filter);
	        
			int result = fileChooser.showSaveDialog(window);
			System.out.println(result);
			
			if (result == JFileChooser.APPROVE_OPTION) {
	            //선택한 파일의 경로 반환
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
				System.out.println("도서 리스트 오픈 완료.");
				JOptionPane.showMessageDialog(null, "파일을 열었습니다.");
				
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
				
				oos.writeObject(book);//파일 입력의 법칙에 따라 두번 한 것임.
				oos.reset();
				oos.writeObject(book);
				oos.reset();
				
				System.out.println("저장되었습니다.");
				JOptionPane.showMessageDialog(null, "파일을 저장했습니다.");
				
			}catch(Exception ex){
			}finally{
				try{
					oos.close();
					fout.close();
				}catch(IOException ioe){}
			} // finally
		}
}
