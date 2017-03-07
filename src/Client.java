import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
	//создаем поле/переменную для сокета
	private Socket socket;
	
	public Client(Socket s)
	{
		//Передаем в параметр сокета клиента переменную сокета сервера из класса main
		socket = s;
	}

	@Override
	//(выполенния интерфеса runnable)
	public void run() {
		try {
			//Получаем входной стрим сокетов
			Scanner in = new Scanner(socket.getInputStream());
			
			//Получаем выходной поток сокетов (инфу о них)
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			//После запуска программы
			while(true){
				//Проверяем если клиент что то ввел и нажа энтер
				if (in.hasNext()) {
					//Устанавливаем то что ввел клиент в переменную
					String input = in.nextLine();
					
					//Выводим на экран
					System.out.println("Ответ клиента: " + input);
					
					//Пересылаем клиенту
					out.println("Вам ответили: " + input);
					
					//Смываем поток (???)
					out.flush();
				} else {

				}
			}
		} catch (Exception e) {
			//Диагностируем ошибку если она появится.
			e.printStackTrace();
		}
	}

}
