package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ClientChatUi extends JFrame {

	private JPanel contentPane;
	private static final String TEXT_SUBMIT = "text-submit";
	private static final String INSERT_BREAK = "insert-break";
	JLabel lblNewLabel_6 = new JLabel("");
	JList<String> serverUsers;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientChatUi frame = new ClientChatUi();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public void updateNumberUserOnline() {
		// luu vao serverData ( chua toan bo thong tin client ) 
		Main.socketController.serverData.connectAccount = Main.socketController.users.size();
		lblNewLabel_6.setText(Integer.toString(Main.socketController.serverData.connectAccount));
		
		// hien thi ra ben ngoai 
	}
	public void updateOnlineUserJList() {
//		System.out.println("online user",Main.socketController.users);
		List <String> listUser= Main.socketController.users;
		serverUsers.setListData(listUser.toArray(new String[0]));
		System.out.println("lay danh sach users tu server");
		for(int i=0;i<listUser.size();i++){
		    System.out.println(listUser.get(i));
		} 
		
	}
	public ClientChatUi(final Controller controller,String userName) {
		serverUsers = new JList<String>();
		updateOnlineUserJList();
//		serverUsers.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 2) {
//
//					String clickedUser = serverUsers.getSelectedValue();
//					System.out.println("Double click " + clickedUser);
//					Room foundRoom = Room.findPrivateRoom(Main.socketController.allRooms, clickedUser);
//					if (foundRoom == null) {
//						Main.socketController.createPrivateRoom(clickedUser);
//					} else {
//						int roomTabIndex = -1;
//						for (int i = 0; i < roomTabbedPane.getTabCount(); i++) {
//							JScrollPane currentScrollPane = (JScrollPane) roomTabbedPane.getComponentAt(i);
//							RoomMessagesPanel currentRoomMessagePanel = (RoomMessagesPanel) currentScrollPane
//									.getViewport().getView();
//							if (currentRoomMessagePanel.room.id == foundRoom.id) {
//								roomTabIndex = i;
//								break;
//							}
//						}
//
//						if (roomTabIndex == -1) { // room tồn tại nhưng tab bị chéo trước đó
//							newRoomTab(foundRoom);
//							roomTabbedPane.setSelectedIndex(roomTabbedPane.getTabCount() - 1);
//						} else {
//							roomTabbedPane.setSelectedIndex(roomTabIndex);
//						}
//					}
//				}
//			}
//		});
		ServerData serverMain= Main.socketController.getServerData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("ServerName : ");
		lblNewLabel.setBounds(43, 86, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(123, 86, 82, 14);
		if(serverMain!=null)
		{
			
			lblNewLabel_1.setText(serverMain.getServerName());
		}
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your Name : ");
		lblNewLabel_2.setBounds(43, 54, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(126, 54, 79, 14);
		lblNewLabel_3.setText(userName);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Send");
		
		btnNewButton.setBounds(406, 275, 87, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(242, 24, 251, 249);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(242, 275, 154, 32);
		textArea_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.revalidate();
		textArea_1.setMinimumSize(new Dimension(100, 20));
		InputMap map = textArea_1.getInputMap();
		map.put(KeyStroke.getKeyStroke("shift ENTER"), "insert-break");		
		contentPane.add(textArea_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("List online user"));
		scrollPane.setBounds(10, 264, 116, -193);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_4 = new JLabel("Chat Application");
		lblNewLabel_4.setBounds(43, 29, 161, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblIp = new JLabel("IP Server : ");
		lblIp.setBounds(43, 121, 94, 14);
		contentPane.add(lblIp);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(126, 155, 82, 14);
		if(serverMain!=null)
		{
			lblNewLabel_1_1.setText(serverMain.getIp());
		}
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblPortServer = new JLabel("Port Server : ");
		lblPortServer.setBounds(43, 155, 94, 14);
		contentPane.add(lblPortServer);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(123, 121, 82, 14);
		if(serverMain!=null)
		{
			lblNewLabel_1_1.setText(Integer.toString(serverMain.getPort()));
		}
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("List user in server");
		lblNewLabel_5.setBounds(555, 29, 147, 14);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane(serverUsers);
		scrollPane_1.setBorder(BorderFactory.createTitledBorder("Choose one in list to connect"));
		scrollPane_1.setBounds(555, 66, 2, 2);
		contentPane.add(scrollPane_1);
		
		
		lblNewLabel_6.setBounds(659, 29, 94, 14);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=textArea_1.getText();
				if(text!="")
				{
					System.out.println("textArea"+text);
				}
			}
			
		});
		updateOnlineUserJList();
		
	}
}
