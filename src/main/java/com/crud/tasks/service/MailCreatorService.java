package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.info.CompanyInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailCreatorService {

    @Autowired
    private DbService service;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyInformation companyInfo;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "New card added!");
        context.setVariable("goodbye", "Best regards and see you later");
        context.setVariable("company", companyInfo.getCompanyInfo());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String oneDayTasksReportMail(String message) {
        List<String> taskNameList = service.getAllTasks().stream()
                .map(t -> t.getTitle())
                .collect(Collectors.toList());
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit Website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "Report!");
        context.setVariable("goodbye", "Best regards! ");
        context.setVariable("company", companyInfo.getCompanyInfo());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("task_list", taskNameList);
        return templateEngine.process("mail/one-day-tasks-report", context);
    }
}
