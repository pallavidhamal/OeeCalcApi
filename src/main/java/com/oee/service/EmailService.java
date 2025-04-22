/*
 * package com.oee.service; import java.util.Properties;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.stereotype.Service;
 * 
 * @Service public class EmailService {
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(EmailService.class);
 * 
 * @Value("${properties.emailport}") private String emailport;
 * 
 * @Value("${properties.emailhost}") private String emailhost;
 * 
 * @Value("${file.reset-password-link}") private String url;
 * 
 * 
 * @Value("${properties.email.authentication.username}") private String
 * eUsername;
 * 
 * @Value("${properties.email.authentication.password}") private String
 * ePassword;
 * 
 * @Value("${properties.emailfrom}") private String emailfrom;
 * 
 * 
 * public void sendResetPasswordMail( String encodeEmail, String email) {
 * 
 * logger.info("*****EmailService sendResetPasswordMail*****");
 * 
 * String to = email; String from = emailfrom;
 * 
 * Properties properties = System.getProperties();
 * properties.put("mail.smtp.host", emailhost); properties.put("mail.smtp.port",
 * emailport); properties.put("mail.smtp.ssl.enable", "true");
 * properties.put("mail.smtp.auth", "true");
 * 
 * Session session = Session.getInstance(properties, new
 * javax.mail.Authenticator() {
 * 
 * protected PasswordAuthentication getPasswordAuthentication() {
 * 
 * return new PasswordAuthentication(eUsername, ePassword);
 * 
 * }
 * 
 * }); session.setDebug(true);
 * 
 * try {
 * 
 * MimeMessage message = new MimeMessage(session); MimeBodyPart textBodyPart =
 * new MimeBodyPart();
 * 
 * // Set From: header field of the header. message.setFrom(new
 * InternetAddress(from));
 * 
 * // Set To: header field of the header.
 * message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
 * 
 * message.setSubject("Reset Password Link!");
 * 
 * String vmFileContent
 * ="Hello User, <br><br> We have received your reset password request .Please click link below to reset  your password. <br> "
 * + "<a href='"+url+"ResetPassword?id="+
 * encodeEmail+"'><strong>Reset Link</strong></a>";
 * 
 * message.setText(vmFileContent,"UTF-8", "html");
 * 
 * System.out.println("sending..."); // Send message Transport.send(message);
 * 
 * // javaMailSender.send(message);
 * System.out.println("Sent message successfully....");
 * 
 * } catch (MessagingException e) { throw new RuntimeException(e); } } }
 */