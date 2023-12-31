package codeDev.io.ogrenciBasvuru.webAPI.controllers;

import codeDev.io.ogrenciBasvuru.business.abstracts.ApplicationService;
import codeDev.io.ogrenciBasvuru.business.requests.CreateApplicationRequest;
import codeDev.io.ogrenciBasvuru.business.requests.UpdateApplicationsRequest;
import codeDev.io.ogrenciBasvuru.business.responses.GetAllApplicationsResponses;
import codeDev.io.ogrenciBasvuru.business.responses.GetByIdApplicationResponse;
import codeDev.io.ogrenciBasvuru.entities.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping()
    public List<GetAllApplicationsResponses> getall() {
        return applicationService.getall();

    }

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody @Valid CreateApplicationRequest createApplicationRequest) {

        this.applicationService.add(createApplicationRequest);
        return ResponseEntity.ok("Application added successfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody @Valid UpdateApplicationsRequest updateApplicationsRequest, User user) {

        this.applicationService.update(id, updateApplicationsRequest, user);
        return ResponseEntity.ok("Application updated successfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        this.applicationService.delete(id);
        return ResponseEntity.ok("Application deleted successfully");

    }

    @GetMapping("/{id}")
    public GetByIdApplicationResponse getById(@PathVariable int id) {
        return applicationService.getById(id);
    }
}
