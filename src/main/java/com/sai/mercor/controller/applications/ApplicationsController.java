package com.sai.mercor.controller.applications;

import com.sai.mercor.dto.ApplicationRequestDto;
import com.sai.mercor.dto.ApplicationRequestFiltersDto;
import com.sai.mercor.dto.ApplicationShortlistRequestDto;
import com.sai.mercor.entity.Application;
import com.sai.mercor.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/u/applications")
@RequiredArgsConstructor
public class ApplicationsController {

    private final ApplicationService applicationService;

    @PostMapping
    public List<Application> getApplications(@RequestBody ApplicationRequestDto applicationRequestDto) {
        return applicationService.getApplications(applicationRequestDto);
    }

    @PostMapping("/filters")
    public ApplicationRequestFiltersDto getAllFilters() {
        return applicationService.getFilters();
    }

    @PostMapping("/shortlist")
    public Map<String, Boolean> shortlist(@RequestBody ApplicationShortlistRequestDto applicationShortlistRequestDto) {
        applicationService.shortlistApplication(applicationShortlistRequestDto);
        return new HashMap<>() {{
            put("success", true);
        }};
    }

    @PostMapping("/budget")
    public Map<String, String> getUnspentBudget() {
        String budget = applicationService.getUnspentBudget();
        return new HashMap<>() {{
            put("budget", budget);
        }};
    }


}
