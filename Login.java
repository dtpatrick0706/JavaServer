public class Client {

  public static void main (String [] args) {
    Socket socket = null;
    int portNumber = 6860;
    try {
      socket = new Socket ("localhost", portumber);
      Thread.sleep(1000);
      Thread server = new Thread(new ServerThread(socket));
      server.start();
    }
    catch (IOException e) {
      System.err.println("Fatal Connection error! ");
      e.printStackTrace();
    }
  }

  public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket, socket) {
      this.socket = socket;
    }

    public void run() {

    }
  }
}
