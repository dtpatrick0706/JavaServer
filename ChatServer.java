public static void main (String[] args) {
  int portNumber = 6860;
  serverSocket = null;
  try {
    ServerSocket serverSocket = new ServerSocket(portNumber);
  }
  catch (IOException e) {
    System.err.println("Could not listen to port: "+ portNumber);
    System.exit(1);
  }
}

public static void acceptClients() {
  while(true) {
    try{
      Socket socket = serverSocket.accept();
    }
    catch(IOException e)  {
      System.out.println("Accept failed on: "+portNumber);
    }
  }
}
public class ClientThread extends ChatServer implements Runnable {
  private Socket socket;

  public ClientThread(Socket, socket) {
    this.socket=socket;
  }

public void run() {
    try {
      out = new PrintWriter(socket.getOutputStream(), true);
      in = new BufferReader(new InputStreamReader(socket.getInputStream()));

      while(!socket.isClosed()) {
        String input = in.readLine();
        if (input != null) {
          for (ClientThread client : clients) {
            client.getWriter().write(input);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public PrintWriter getWriter() {
    return out;
  }
}
