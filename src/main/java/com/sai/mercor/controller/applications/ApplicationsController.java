package com.sai.mercor.controller.applications;

import com.sai.mercor.dto.ApplicationRequestDto;
import com.sai.mercor.dto.ApplicationRequestFiltersDto;
import com.sai.mercor.entity.Application;
import com.sai.mercor.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/u/applications")
@RequiredArgsConstructor
public class ApplicationsController {

    private final ApplicationService applicationService;

    @PostMapping
    public List<Application> getApplications(@RequestBody ApplicationRequestDto applicationRequestDto){
       return applicationService.getApplications(applicationRequestDto);
    }

    @PostMapping("/filters")
    public ApplicationRequestFiltersDto getAllFilters() {
       return applicationService.getFilters();
    }

}
