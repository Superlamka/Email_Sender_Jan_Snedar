package utb.fai;
 
public class App {    
    public static void main(String[] args) {        
        String host = "smtp.utb.cz";
        int port = 25;
        String from = "you@utb.cz";
        String to = "you@utb.cz";
        String subject = "Email from Java";
        String text = "Funguje to?\nSnad...";
 
        // Input parameter processing: [host] [port] [from] [to] [subject] [text]
        if (args.length >= 1) host = args[0];
        if (args.length >= 2) {
            try {
                port = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port provided. Falling back to default port: 25");
            }
        }
        if (args.length >= 3) from = args[2];
        if (args.length >= 4) to = args[3];
        if (args.length >= 5) subject = args[4];
        if (args.length >= 6) text = args[5];
 
        try {            
            EmailSender sender = new EmailSender(host, port);            
            sender.send(from, to, subject, text);            
            sender.close();
            System.out.println("Email sent successfully!");
        } catch (Exception e) {            
            e.printStackTrace();        
        }    
    }
}
 