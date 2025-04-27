package com.practice.sendmail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment() throws MessagingException {

        ClassPathResource resource = new ClassPathResource("Resume-2.pdf");
        try (InputStream inputStream = resource.getInputStream()) {
            ByteArrayResource fileResource = new ByteArrayResource(inputStream.readAllBytes());

//            List<String> toEmails = Arrays.asList("manju.kumari@spglobal.com", "Mrunal.Gore01.C@eclerx.com", "pratish.shah@in.ey.com",
//                "mansi.thakkar.tpr@pwc.com", "hemamr@deloitte.com", "vishchawla@deloitte.com", "laksmi@clandicainc.com",
//                "rsrivastawa@deloitte.com", "a.karthick@accenture.com", "Aman@arataglobal.ca", "reemam@credencehrservices.com",
//                "nabeeha.pirzada@sisystems.com", "info@elitetalentplacements.com", "riya@tekstaff.ca", "deena.p@twsol.com",
//                "rebecca.jia@lbank.com", "anubhuti.ganguly@quesscorp.com", "senthilkumar@wns.com", "Kirti.Magdum.C@eclerx.com",
//                "irene.i@vitasta.com", "shivani.kumari2@in.ey.com", "darren@its-city.com", "sumanrawat@cocacolabareilly.com",
//                "gayathri.madhavraju@gomoder.com", "ashwini.parkar@ca-cib.com", "monika@altuspro.in", "Vinitha.Srinivasa-babu@socgen.com",
//                "andrew.welsh@merakitalent.com", "pritam.debnath1@genpact.com", "ifrah@seenrecruit.com", "juhi@liveconnections.in",
//                "beena@zodnik.in", "sabhyata.sharma@nityo.com", "info@lyfleap.com", "ramesh@thanuassociates.com",
//                "rsilverman@missionstaffing.com", "lavina.chandwaney@black-turtle.in", "MLidhoriye@citco.com",
//                "lavina.chandwaney@black-turtle.in", "roshni.gupta@randstad.in", "pranay.dalvi@capco.com", "Ajay.Bhandari@in.ey.com",
//                "prachi.goswami@tdnewton.com", "smitha@beroe-inc.com", "Khushboo.jeevtani@genpact.com", "Bharati.bharati@capgemini.com",
//                "Vijay.tamada@cognizant.com");
            
            List<String> toEmails = Arrays.asList();

            String subject = "Looking for Java Backend Developer role";

            String body = "Hi,"
                + "\n<br><br>"
                + "I am writing to express my interest in the Java Developer role. I am excited about the opportunity to contribute my skills and expertise to your team.\n"
                + "\n<br><br>"
                + "In my current role as a Java Backend Developer at DigitalDots Technologies, I have successfully managed backend services for the Workflow Automation Platform for Orchestrations. My experience includes working with Java, Spring Boot, Spring Security, Spring Data Jpa, Spring Batch, RESTFul APIs, Microservices, MongoDB, PostgreSQL, Kafka, Redis, JUnit, Git, GitHub, Docker, Kubernetes.\n"
                + "\n<br><br>"
                + "I am confident that my technical skills, problem-solving abilities, and dedication to delivering quality solutions align with the expectations of this position.\n"
                + "\n<br><br>"
                + "I have attached my resume for your review. I would be grateful for the opportunity to discuss how my background, skills, and goals align with the needs of your team.\n"
                + "\n<br><br>"
                + "Thank you for considering my application. I look forward to the possibility of contributing to the team and would be happy to provide additional information or references upon request.\n"
                + "";

            for (String toEmail : toEmails) {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setTo(toEmail);
                helper.setSubject(subject);
                helper.setText(body, true);
                // Attach the PDF
                helper.addAttachment("resume.pdf", fileResource);
                mailSender.send(mimeMessage);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
