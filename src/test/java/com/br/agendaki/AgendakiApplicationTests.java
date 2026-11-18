package com.br.agendaki;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("Evita exigir conexão com banco de dados durante o empacotamento Maven")
class AgendakiApplicationTests {

	@Test
	void contextLoads() {
	}

}
