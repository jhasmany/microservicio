package aforo255.ms.test.configservertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsConfigservertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConfigservertestApplication.class, args);
	}

}
