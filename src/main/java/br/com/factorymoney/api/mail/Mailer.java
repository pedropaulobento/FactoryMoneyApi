package br.com.factorymoney.api.mail;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.factorymoney.api.model.Lancamento;
import br.com.factorymoney.api.model.Usuario;

@Component
public class Mailer {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine thymeleaf;

//	@Autowired
//	private LancamentoRepository repo;
//	@EventListener
//	private void teste(ApplicationReadyEvent event) {
//		String template = "mail/aviso-lancamentos-vencidos";
//		
//		List<Lancamento> lista = repo.findAll();
//		
//		Map<String, Object> variaveis = new HashMap<>();
//		variaveis.put("lancamentos", lista);
//		
//		this.enviarEmail("npd.andre@gmail.com", 
//				Arrays.asList("andre.npd@hotmail.com"), 
//				"Testando", template, variaveis);
//		System.out.println("Terminado o envio de e-mail...");
//	}

//	@EventListener
//	public void teste(ApplicationReadyEvent event) {
//		this.enviarEmail("andre.npd@hotmail.com", Arrays.asList("andre.npd@hotmail.com"), "Testando email",
//				"Olá!!! <br> Ah muluqueeee ");
//		System.out.println("Enviando email!!!!");
//	}

	public void avisarSobreLancamentosVencidos(List<Lancamento> vencidos, List<Usuario> destinatarios) {
		Map<String, Object> variaveis = new HashMap<>();
		variaveis.put("lancamentos", vencidos);

		List<String> emails = destinatarios.stream().map(u -> u.getEmail()).collect(Collectors.toList());
		this.enviarEmail("npd.andre@gmail.com", emails, "Lançamentos Vencidos", "mail/aviso-lancamentos-vencidos",
				variaveis);
	}

	public void enviarEmail(String remetente, List<String> destinatarios, String assunto, String template,
			Map<String, Object> variaveis) {
		Context context = new Context(new Locale("pt", "BR"));

		variaveis.entrySet().forEach(e -> context.setVariable(e.getKey(), e.getValue()));

		String mensagem = thymeleaf.process(template, context);

		this.enviarEmail(remetente, destinatarios, assunto, mensagem);
	}

	public void enviarEmail(String remetente, List<String> destinatario, String assunto, String mensagem) {

		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
			helper.setFrom(remetente);
			helper.setTo(destinatario.toArray(new String[destinatario.size()]));
			helper.setSubject(assunto);
			helper.setText(mensagem, true);

			javaMailSender.send(mimeMessage);

		} catch (MessagingException e) {
			throw new RuntimeException("Problemas com o envio de e-mal!", e);
		}
	}
}
