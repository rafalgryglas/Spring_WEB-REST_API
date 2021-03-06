//package com.crud.tasks.service;
//
//import com.crud.tasks.domain.Mail;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class SimpleMailServiceTest {
//    @InjectMocks
//    private SimpleMailService simpleMailService;
//    @Mock
//    private JavaMailSender javaMailSender;
//    @Mock
//    private MimeMessagePreparator createMessage;
//
//    @Test
//    public void shouldSendEmail() {
//        //Given
//        Mail mail = new Mail("test@test.com", "Test", "Test message");
//
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(mail.getMailTo());
//        mailMessage.setSubject(mail.getSubject());
//        mailMessage.setText(mail.getMessage());
//        //When
//        simpleMailService.send(createMessage(mail));
//
//        //Then
//        verify(javaMailSender, times(1)).send(mailMessage);
//    }
//}