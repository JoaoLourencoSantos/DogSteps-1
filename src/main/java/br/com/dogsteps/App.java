package br.com.dogsteps;

import br.com.dogsteps.dao.TourDAO;
import br.com.dogsteps.enums.ETourStatus;
import br.com.dogsteps.models.Tour;
import br.com.dogsteps.utils.FilterResponse;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;

public class App {
    private static final String PACKAGE = "br.com.dogsteps";
    private static final int PORTA = 8080;
    private static final String BASE_URI = "http://localhost:" + PORTA + "/dogsteps";
    private static HttpServer server;
    private static ResourceConfig resourceConfig;

    public static void main(String[] args) throws IOException {
        //testDao();

        server = startServer();
        System.out.println(String.format(
                "Aplicação de está iniciada na porta " + PORTA + "\nPressione enter para terminar...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }

    private static HttpServer startServer() {
        resourceConfig = new ResourceConfig().packages(PACKAGE);
        resourceConfig.register(FilterResponse.class);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

    public static void testDao() throws IOException {
        TourDAO dao = new TourDAO("database/tour.bin");
        Tour t = new Tour(LocalDate.now(), ETourStatus.COMPLETED, 2);
        //dao.add(t);
       // dao.update(t, 1);

        System.out.println(dao.getAll().get(3));
    }

}
