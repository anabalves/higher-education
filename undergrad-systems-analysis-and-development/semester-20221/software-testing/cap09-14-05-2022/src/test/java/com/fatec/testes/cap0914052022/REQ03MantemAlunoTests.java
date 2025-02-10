package com.fatec.testes.cap0914052022;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class REQ03MantemAlunoTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://scel.herokuapp.com/login");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void ct01_cadastrar_aluno_com_sucesso() {
		// ******************************************************************
		// dado que o usuario esta autenticado e autorizado //
		// ******************************************************************
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		// ****************************************************************** 
		// quando o usuario cadastra um aluno que não está cadastrado //
		// ******************************************************************
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4154");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("ana");
		driver.findElement(By.id("email")).sendKeys("ana@gmail.com");
		driver.findElement(By.id("cep")).sendKeys("04280130");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		// ****************************************************************** // entao o
		// sistema apresenta as informações do aluno para consulta //
		// ******************************************************************
		assertTrue(driver.getPageSource().contains("Rua Frei João"));
		// assertEquals("Rua Frei João",
		// driver.findElement(By.cssSelector("td:nth-child(6)")).getText());
		assertEquals(("Lista de alunos"), driver.findElement(By.id("titulopagina")).getText());
		assertEquals("https://scel.herokuapp.com/sig/alunos", driver.getCurrentUrl());
		assertTrue(driver.getPageSource().contains("4154"));
		// *********************************************************************************
		// teardown - exclusao do registro //
		// *********************************************************************************
		driver.findElement(By.linkText("Excluir")).click();
	}

	@Test
	public void ct02_atualiza_aluno_com_sucesso() {
		// ***********************************************************************************
		// dado que o aluno esta cadastrado //
		// ***********************************************************************************
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4155");
		driver.findElement(By.id("nome")).sendKeys("ana");
		driver.findElement(By.id("email")).sendKeys("ana@gmail.com");
		driver.findElement(By.id("cep")).sendKeys("04280130");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		assertTrue(driver.getPageSource().contains("Rua Frei João"));
		assertEquals("Rua Frei João", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(6)")).getText());
		// **********************************************************************************
		// quando o usuario altera o CEP do endereco
		// **********************************************************************************
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.cssSelector(".form-group:nth-child(2)")).click();
		driver.findElement(By.id("cep")).clear();
		driver.findElement(By.id("cep")).sendKeys("08545160");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		// entao o sistema apresenta as informações do aluno com o CEP alterado
		assertTrue(driver.getPageSource().contains("Rua João Soliman"));
		// ************************************************************************************
		// teardown - exclusao do registro
		// ***********************************************************************************
		// driver.findElement(By.linkText("Excluir")).click();
	}

	@Test
	public void ct03cadastraraluno_ja_cadastrado() {
		// ******************************************************************************
		// dado que o aluno esta cadastrado //
		// ******************************************************************************
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4155");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("ana");
		driver.findElement(By.id("email")).sendKeys("ana@gmail.com");
		driver.findElement(By.id("cep")).sendKeys("04280130");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		// *******************************************************************************
		// entao retorna dados invalidos
		// *******************************************************************************
		espera();
		assertEquals("Dados invalidos", driver.findElement(By.cssSelector(".text-danger")).getText());
	}

	@Test
	public void ct01consulta_cep_pelo_logradouro_com_sucesso() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://buscacepinter.correios.com.br/app/localidade_logradouro/index.php");
		driver.manage().window().setSize(new Dimension(1012, 728));
		driver.findElement(By.id("uf")).click();
		WebElement dropdownFederacao = driver.findElement(By.id("uf"));
		Select combo1 = new Select(dropdownFederacao);
		combo1.selectByIndex(26);
		combo1.selectByVisibleText("SP");
		driver.findElement(By.id("localidade")).click();
		driver.findElement(By.id("localidade")).sendKeys("São Paulo");
		driver.findElement(By.id("tipologradouro")).click();
		WebElement dropdownTipo = driver.findElement(By.id("tipologradouro"));
		Select combo2 = new Select(dropdownTipo);
		combo2.selectByIndex(32);
		combo2.selectByVisibleText("Rua");
		driver.findElement(By.id("logradouro")).click();
		driver.findElement(By.id("logradouro")).sendKeys("Frei João");
		driver.findElement(By.id("btn_pesquisar")).click();
		espera();
		assertThat(driver.findElement(By.cssSelector("#mensagem-resultado > h4")).getText(),
				is("Resultado da Busca por Localidade/Logradouro"));
	}

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}