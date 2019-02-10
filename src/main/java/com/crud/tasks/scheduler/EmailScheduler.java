package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day report";

    @Autowired
    private SimpleMailService simpleMailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 15 * * *")
//    @Scheduled(fixedDelay = 10000)
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String text = (size == 1 ? " task" : " tasks");
        simpleMailService.sendOneDayReport(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Curently in database you got: " + size + text)
        );
    }
}
