package Server;

import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import evento.Curso;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;
import pessoa.Administrador;


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
            response.setStatus(Status.OK);
            response.setValue("Data-Type", "text");

            String operacao = query.get("operacao");

            if (operacao == null){
                operacao = "";
            }

            switch (operacao){
                case "cadastrarAluno":
                    control.cadastrarAluno(body, query.get("curso")
                            , query.get("turno"), query.get("periodo"), query.get("senha"),
                            query.get("genero"), query.get("nome"), query.get("email"));
                    break;
                case "login":
                    control.realizandoCadastro(body,query.get("email"),query.get("senha"));
                    break;
                case "deletarAluno":
                    control.deletarAluno(body, query.get("email"));
                    break;
                case "editarAluno":
                    //control.editarAluno();
                    break;
                case "cadastraEvento":
                   control.cadastraEvento(body, query.get("data")
                           , query.get("disciplina"), query.get("professor"), query.get("sala"),
                           query.get("evento"), query.get("curso"));
                    break;
                case "deletarEvento":
                    control.deletarEvento(body, query.get("id"));
                    break;
                case "editarEvento":
                   // control.editarEvento();
            }

         body.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] list) throws Exception {
        // Se voc� receber uma mensagem
        // "Address already in use: bind error",
        // tente mudar a porta.

        control.iniciarController();

        final int porta = 5000;

        // Configura uma conex�o soquete para o servidor HTTP.
        Container container = new Server();
        ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
        Connection conexao = new SocketConnection(servidor);
        SocketAddress endereco = new InetSocketAddress(porta);
        conexao.connect(endereco);

        //Testa a conex�o abrindo o navegador padr�o.
        Desktop.getDesktop().browse(new URI("http://127.0.0.1:" + porta));

        System.out.println("Tecle ENTER para interromper o servidor...");
        System.in.read();

        conexao.close();
        servidor.stop();

    }
}