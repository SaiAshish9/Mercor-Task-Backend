package com.sai.mercor.service;

import com.sai.mercor.dto.ApplicationRequestDto;
import com.sai.mercor.dto.ApplicationRequestFiltersDto;
import com.sai.mercor.entity.Application;
import com.sai.mercor.enums.WorkAvailability;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sai.mercor.utilities.ApplicationUtilities.nonEmptySorted;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final MongoTemplate mongoTemplate;

    public List<Application> getApplications(ApplicationRequestDto applicationRequestDto) {
        List<String> locations = applicationRequestDto.getLocations();
        List<String> roles = applicationRequestDto.getRoles();
        List<String> organizations = applicationRequestDto.getOrganizations();
        List<String> skills = applicationRequestDto.getSkills();
        boolean shortlisted = applicationRequestDto.isShortlisted();
        Query query = new Query();

        if (locations != null && !locations.isEmpty()) {
            query.addCriteria(Criteria.where("location").in(locations));
        }
        if (roles != null && !roles.isEmpty()) {
            query.addCriteria(Criteria.where("work_experiences.roleName").in(roles));
        }
        if (organizations != null && !organizations.isEmpty()) {
            query.addCriteria(Criteria.where("work_experiences.company").in(organizations));
        }
        if (skills != null && !skills.isEmpty()) {
            query.addCriteria(Criteria.where("skills").in(applicationRequestDto.getSkills()));
        }
        if (shortlisted) {
            query.addCriteria(Criteria.where("shortlisted").is(true));
        }

        query.addCriteria(Criteria.where("work_availability")
                .is(WorkAvailability.FULL_TIME.getValue()));

        return mongoTemplate.find(query, Application.class);
    }

    public ApplicationRequestFiltersDto getFilters() {
        List<String> skills = mongoTemplate
                .findDistinct(new Query(), "skills", Application.class, String.class);
        List<String> locations = mongoTemplate
                .findDistinct(new Query(), "location", Application.class, String.class);
        List<String> organizations = mongoTemplate
                .findDistinct(new Query(), "work_experiences.company", Application.class, String.class);
        List<String> roles = mongoTemplate
                .findDistinct(new Query(), "work_experiences.roleName", Application.class, String.class);
        ApplicationRequestFiltersDto applicationRequestFiltersDto = new ApplicationRequestFiltersDto();
        applicationRequestFiltersDto.setLocations(nonEmptySorted(locations));
        applicationRequestFiltersDto.setSkills(nonEmptySorted(skills));
        applicationRequestFiltersDto.setOrganizations(nonEmptySorted(organizations));
        applicationRequestFiltersDto.setRoles(nonEmptySorted(roles));
        return applicationRequestFiltersDto;
    }

}
