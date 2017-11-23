package Server;

import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;


public class Server implements Container {
    static Controller control = new Controller();
    public void handle(Request request, Response response) {
        try {
            Query query = request.getQuery();
            PrintStream body = response.getPrintStream();
            long time = System.currentTimeMillis();

            response.setValue("Content-Type", "application/json");
            response.setValue("Access-Control-Allow-Origin", "*");
            response.setValue("Server", "HelloWorld/1.0 (Simple 4.0)");
            response.setDate("Date", time);
            response.setDate("Last-Modified", time);

            response.setValue("Content-Type", "text/plain");
            body.println("Ol�, voc� requisitou: "+request.getPath());

            String operacao = query.get("operacao");

            if (operacao == null){
                operacao = "";
            }

            /*switch (operacao){
                case "mostrarCarrosNoEstacionamento":
                    c.getListaDeEstacionamentos().get(0).mostrarCarrosNoEstacionamento(body);
                    break;
                case "realizarLogin":
                    c.validarUsuario(body,query.get("email"),query.get("senha"));
                    break;
                case "mostrarHistorico":
                    c.getListaDeEstacionamentos().get(0).getHistoricoDeAlugueis().mostrarHistorico(body);
            }*/


            body.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] list) throws Exception {
        // Se voc� receber uma mensagem
        // "Address already in use: bind error",
        // tente mudar a porta.

        control = control.iniciarController();
        int porta = 7100;

        // Configura uma conex�o soquete para o servidor HTTP.
        Container container = new Server();
        ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
        Connection conexao = new SocketConnection(servidor);
        SocketAddress endereco = new InetSocketAddress(porta);
        conexao.connect(endereco);


        System.out.println("Tecle ENTER para interromper o servidor...");
        System.in.read();

        conexao.close();
        servidor.stop();

        //Testa a conex�o abrindo o navegador padr�o.
        Desktop.getDesktop().browse(new URI("http://127.0.0.1:" + porta));

        System.out.println("Tecle ENTER para interromper o servidor...");
        System.in.read();

        conexao.close();
        servidor.stop();

    }
}