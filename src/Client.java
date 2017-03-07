import java.net.Socket;

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
		// TODO Auto-generated method stub
		
	}

}
