package BasballGame2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;
import java.util.StringTokenizer;

public class Server {
	public static void main(String[] args) throws EOFException {
		ServerSocket serverSocket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int port = 8889;
		DateFormat df= new SimpleDateFormat("HH:MM:ss");
		String time = df.format(new Date());

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�");
			Thread.sleep(300);
			Socket socket = serverSocket.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");
			System.out.println(time);
			Thread.sleep(300);

			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("������ �����մϴ�.");

			// ���� ���� ����
			int[] SerNum = new int[3];
			Random random = new Random();
			System.out.print("������ ������ ��ȣ : ");
			System.out.println();

			for (int i = 0; i < 3; i++) {
				SerNum[i] = random.nextInt(9) + 1;
				for (int j = 0; j < i; j++) {// �ߺ�����
					if (SerNum[i] == SerNum[j]) {
						i--;
						continue;
					}
				}
			}
			System.out.print(SerNum[0] + " " + SerNum[1] + " " + SerNum[2] + " ");
			System.out.println();
			String score ="";
			int Strike = 0;
			int ball = 0;
			
			while (true) {
				// Ŭ���̾�Ʈ�� ���� ���� ����
				String CliNum = dis.readUTF();
				StringTokenizer st = new StringTokenizer(CliNum, " ");
				int CliNum1[] = new int[3];
				
				if (st.countTokens() != 3) {//�Է¿����϶�
					score = "�߸����Է��Դϴ�";
				} else {
					CliNum1[0] = Integer.parseInt(st.nextToken());
					CliNum1[1] = Integer.parseInt(st.nextToken());
					CliNum1[2] = Integer.parseInt(st.nextToken());
					
					// ���� ī��Ʈ ����
				
					for (int i = 0; i < SerNum.length; i++) {
						if (SerNum[i] == CliNum1[i]) {
							Strike++;
						} else {
							for (int j = 0; j < CliNum1.length; j++) {
								if (SerNum[i] == CliNum1[j]) {
									ball++;
								}
							}
						}
					}

					System.out.println("Ŭ���̾�Ʈ �Է� : " + CliNum); 
					System.out.println();

					score = "��Ʈ����ũ " + Strike + " �� " + ball;
					
					if (Strike == 3) {
						score = "3 ��Ʈ����ũ ��������";
					}
				}

					dos.writeUTF(score);

					if (Strike == 3)
						break;

					Strike = 0;
					ball = 0;
				
			}
			System.out.println("������ �����մϴ�");
			String time1=df.format(new Date());
			System.out.println(time1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				serverSocket.close();
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
