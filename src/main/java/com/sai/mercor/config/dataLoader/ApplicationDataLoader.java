package com.sai.mercor.config.dataLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.mercor.repository.ApplicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDataLoader implements CommandLineRunner {

    private final ApplicationRepository applicationRepository;
    private final ObjectMapper objectMapper;

    public ApplicationDataLoader(ApplicationRepository applicationRepository, ObjectMapper objectMapper) {
        this.applicationRepository = applicationRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {

//        if (applicationRepository.count() == 0) {
//            System.out.println("Application collection empty → Loading initial JSON...");
//
//            ClassPathResource resource = new ClassPathResource("applications.json");
//
//            Object app = objectMapper.readValue(resource.getInputStream(), Object.class);
//
//            applicationRepository.save((Application) app);
//
//            System.out.println("Loaded initial application into MongoDB.");
//        } else {
//            System.out.println("Application collection already has data → Skipping load.");
//        }
    }
}
