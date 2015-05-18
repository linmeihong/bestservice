import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyMain {

	public static void main(String[] args) throws Exception {

		String path = System.getProperty("user.dir").replace("\\", "/");

		// Server server = new Server(8080);

		// WebAppContext webapp = new WebAppContext();

		// webapp.setContextPath("/");

		// webapp.setWar(path+"/www/cometd.war");

		// server.setHandler(webapp);

		//

		// server.start();

		// server.join();

		Server server = new Server(8080);

		WebAppContext context = new WebAppContext();

		context.setDescriptor(path + "/WebContent/WEB-INF/web.xml");

		context.setResourceBase(path + "/");

		context.setContextPath("/");

		context.setParentLoaderPriority(true);

		server.setHandler(context);

		server.start();

		server.join();

	}

}
