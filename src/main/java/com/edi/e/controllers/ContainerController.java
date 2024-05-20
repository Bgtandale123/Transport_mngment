package com.edi.e.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edi.a.models.ContainerDetails;
import com.edi.c.service.ContainerService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/edi")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @PostMapping("/createContainerDetails")
    public ResponseEntity<?> createContainerDetails(@RequestBody ContainerDetails containerDetails) {
        try {
            ContainerDetails createdContainerDetails = containerService.createContainerDetails(containerDetails);
            return ResponseEntity.ok(createdContainerDetails);
        } catch (DataIntegrityViolationException e) {
            // Extract the duplicate value from the exception
            String duplicateValue = extractDuplicateValue(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry for '" + duplicateValue + "'. The data you are trying to add already exists.");
        }
    }

    private String extractDuplicateValue(DataIntegrityViolationException e) {
        String errorMessage = e.getRootCause().getMessage();
        return extractDuplicateValueFromErrorMessage(errorMessage);
    }

    private String extractDuplicateValueFromErrorMessage(String errorMessage) {
        int startIndex = errorMessage.indexOf("'");
        int endIndex = errorMessage.indexOf("'", startIndex + 1);
        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            return errorMessage.substring(startIndex + 1, endIndex);
        } else {
            return "unknown"; // Unable to extract duplicate value
        }
    }

    
	/*
	 * @PostMapping("/createContainerDetails")
	 * // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public ContainerDetails createContainerDetails(@RequestBody
	 * ContainerDetails containerDetails) { ContainerDetails
	 * vssl=containerService.createContainerDetails(containerDetails); return vssl;
	 * }
	 */
    @PutMapping("/updateContainerDetails")
    public ResponseEntity<?> updateContainerDetails(@RequestBody ContainerDetails containerDetails) {
        try {
            ContainerDetails updatedContainerDetails = containerService.updateContainerDetails(containerDetails);
            return ResponseEntity.ok(updatedContainerDetails);
        } catch (DataIntegrityViolationException e) {
            // Extract the duplicate value from the exception
            String duplicateValue = extractDuplicateValue(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry for '" + duplicateValue + "'. The data you are trying to update already exists.");
        }
    }

    private String extractDuplicatecont(DataIntegrityViolationException e) {
        // Implement your logic to extract the duplicate value from the error message
        // This is just a basic example and may need adjustment based on your specific case
        String errorMessage = e.getRootCause().getMessage();
        // You need to customize this logic based on the actual format of the error message
        // Example: Extracting values between single quotes in the error message
        String[] values = errorMessage.split("'");
        if (values.length >= 2) {
            return "'" + values[1] + "'"; // Assuming the first value in the error message is the duplicate value
        } else {
            return "unknown"; // Unable to extract duplicate value
        }
    }

    
	/*
	 * @PutMapping("/updateContainerDetails")
	 * // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public ContainerDetails updateContainerDetails(@RequestBody
	 * ContainerDetails containerDetails) { ContainerDetails
	 * vssl=containerService.updateContainerDetails(containerDetails); return vssl;
	 * }
	 */
    @GetMapping("/getContainerDetailsById/{id}")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<ContainerDetails> getContainerDetailsById(@PathVariable("id") int id) {
        Optional<ContainerDetails> vs=containerService.getContainerDetailsById(id);
        return vs;
    }

    @GetMapping("/getAllContainerDetails")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ContainerDetails> getAllContainerDetails(ContainerDetails containerDetails) {
        List<ContainerDetails> container= (List<ContainerDetails>) containerService.getAllContainerDetails(containerDetails);
        return container;
    }
    
	@DeleteMapping("/deleteContainerDetails/{id}")
	public void deleteContainerDetails(@PathVariable("id") Integer id) throws Exception {
		containerService.deleteContainerDetails(id);
	}
    
	
    @GetMapping("/getcontainer/{containerNumber}")
    public List<ContainerDetails> getAllContainer(@PathVariable String containerNumber) {
    //  System.out.println("==>"+ cd);
      List<ContainerDetails> cd=containerService.getAllContainer(containerNumber);
      System.out.println("==>"+ cd);
    	return cd;
    }
}
