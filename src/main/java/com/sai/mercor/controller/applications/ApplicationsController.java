package com.sai.mercor.controller.applications;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/u/applications")
@RequiredArgsConstructor
public class ApplicationsController {

    private final ObjectMapper objectMapper;

    @PostMapping
    public Object getApplications(){
        Object payload;
        try {
            ClassPathResource resource = new ClassPathResource("applications.json");
            payload = objectMapper.readValue(resource.getInputStream(), Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read or send JSON", e);
        }
        return payload;
    }

}
