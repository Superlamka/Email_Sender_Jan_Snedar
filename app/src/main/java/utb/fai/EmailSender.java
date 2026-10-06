package utb.fai;
 
import java.net.*;
import java.io.*;
 
public class EmailSender {
    private final Socket socket;
    private final OutputStream outputStream;
    private final InputStream inputStream;
 
    /*
     * Constructor opens Socket to host/port. If the Socket throws an exception during opening,
     * the exception is not handled in the constructor.
     */
    public EmailSender(String host, int port) throws UnknownHostException, IOException {
        this.socket = new Socket(host, port);
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
        // Read initial server greeting if available
        readResponse();
    }
 
    /*
     * Sends email from an email address to an email address with some subject and text.
     * If the Socket throws an exception during sending, the exception is not handled by this method.
     */
    public void send(String from, String to, String subject, String text) throws IOException {
        sendCommand("EHLO localhost");
        sendCommand("MAIL FROM:<" + from + ">");
        sendCommand("RCPT TO:<" + to + ">");
        sendCommand("DATA");
 
        String emailContent = "Subject: " + subject + "\r\n" +
                              "From: " + from + "\r\n" +
                              "To: " + to + "\r\n" +
                              "\r\n" +
                              text + "\r\n" +
                              ".\r\n";
 
        outputStream.write(emailContent.getBytes("UTF-8"));
        outputStream.flush();
        readResponse();
    }
 
    /*
     * Sends QUIT and closes the socket
     */
    public void close() {
        try {
            sendCommand("QUIT");
        } catch (IOException e) {
            
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    // Helper method to send a raw SMTP command and flush the stream
    private void sendCommand(String command) throws IOException {
        String fullCommand = command + "\r\n";
        outputStream.write(fullCommand.getBytes("UTF-8"));
        outputStream.flush();
        readResponse();
    }
 
    // Helper method to read server responses
    private String readResponse() throws IOException {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
 
        if (inputStream.available() > 0) {
            byte[] responseBuffer = new byte[1024];
            int len = inputStream.read(responseBuffer);
            return new String(responseBuffer, 0, len, "UTF-8");
        }
        return "";
    }
}