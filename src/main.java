import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) throws IOException {
		try {
			//задаем целочисленной переменной имя порта
			final int PORT = 6677;
			
			//записуем в обьект сокета номер порта и заносим в перменную
			ServerSocket server = new ServerSocket(PORT);
			
			//При запуске выводим это сообщение
			System.out.println("Ожидание клиента...");
			
			//После запуска, делаем проверку
			while(true) {
				//Принять клиентов которые пытаются войти и заносим это в переменную
				Socket s = server.accept();
				
				//Выводим сообщение что клиенты подключены туда же выводим локальный адрес и хоть имя
				System.out.println("Клиенты подключены " + s.getLocalAddress().getHostName());
				
				//Создаем обьект класса Клиент и заносим в аргумент клиентов которые пытаются войти
				//В самом классе уже обрабатываем аргумент
				Client chat = new Client(s);
				//Клиента заносим в поток
				Thread t = new Thread(chat);
				//Запускаем поток
				t.start();
			}

		} catch (Exception e) {
			System.out.println("Произошла ошибка"); //если будет ошибка, будем выводить это сообщение
            e.printStackTrace();
		}
	}
}

//http://www.dreamincode.net/forums/topic/262304-simple-client-and-server-chat-program/
