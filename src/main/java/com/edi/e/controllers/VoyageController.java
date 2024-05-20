package com.edi.e.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edi.a.models.Vessel;
import com.edi.a.models.VoyageDetails;
import com.edi.c.service.VoyageService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/edi")
public class VoyageController {
    @Autowired
    private VoyageService voyageService;

    @PostMapping("/createVoyageDetails")
    public ResponseEntity<?> createVoyageDetails(@RequestBody VoyageDetails voyageDetails) {
        try {
            VoyageDetails createdVoyageDetails = voyageService.createVoyageDetails(voyageDetails);
            return ResponseEntity.ok(createdVoyageDetails);
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
	 * @PostMapping("/createVoyageDetails")
	 * //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public VoyageDetails createVoyageDetails(@RequestBody VoyageDetails
	 * voyageDetails) { VoyageDetails
	 * vssl=voyageService.createVoyageDetails(voyageDetails); return vssl; }
	 */
    
    @PutMapping("/updateVoyageDetails")
    public ResponseEntity<?> updateVoyageDetails(@RequestBody VoyageDetails voyageDetails) {
        try {
            VoyageDetails updatedVoyageDetails = voyageService.updateVoyageDetails(voyageDetails);
            return ResponseEntity.ok(updatedVoyageDetails);
        } catch (DataIntegrityViolationException e) {
            // Extract the duplicate value from the exception
            String duplicateValue = extractDuplicateFields(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry for '" + duplicateValue + "'. The data you are trying to update already exists.");
        }
    }

    private String extractDuplicateFields(DataIntegrityViolationException e) {
        String errorMessage = e.getRootCause().getMessage();
        String[] values = errorMessage.split("'");
        if (values.length >= 2) {
            return "'" + values[1] + "'"; // Assuming the first value in the error message is the duplicate value
        } else {
            return "unknown"; // Unable to extract duplicate value
        }
    }

    
	/*
	 * @PutMapping("/updateVoyageDetails")
	 * //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public VoyageDetails updateVoyageDetails(@RequestBody VoyageDetails
	 * voyageDetails) { VoyageDetails
	 * vssl=voyageService.updateVoyageDetails(voyageDetails); return vssl; }
	 */
    @GetMapping("/getVoyageDetailsById/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<VoyageDetails> getVoyageDetailsById(@PathVariable("id") int id) {
        Optional<VoyageDetails> vs=voyageService.getVoyageDetailsById(id);
        return vs;
    }

    @GetMapping("/getAllVoyageDetails")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<VoyageDetails> getAllVoyageDetails(VoyageDetails voyageDetails) {
        List<VoyageDetails> voyage= (List<VoyageDetails>) voyageService.getAllVoyageDetails(voyageDetails);
        return voyage;
    }
    
    @DeleteMapping("/deleteVoyageDetails/{id}")
    public void deleteVoyageDetails(@PathVariable("id") 
    Integer id) throws Exception {
      voyageService.deleteVoyageDetails(id);
    }
    
    @GetMapping("/detailsbyvoyage/{voyageNumber}")
	public List<VoyageDetails> getJoinInformation(@PathVariable String voyageNumber) {
		  List<VoyageDetails>vno = voyageService.getJoinInformation(voyageNumber);
		  return vno;
	}
	/*
	 * @GetMapping("/detailsbyvessel/{vesseltype}") public List<VoyageDetails>
	 * GetByVessel(String vesseltype) {
	 * 
	 * List<VoyageDetails> data=voyageService.getVoyages(vesseltype); return data; }
	 */
    @GetMapping("/detailsbyvessel/{vesseltype}")
	public ResponseEntity<List<VoyageDetails>> getVoyagesByVesselType(@PathVariable String vesseltype) {
		List<VoyageDetails> voyages = voyageService.getVoyages(vesseltype);
		return ResponseEntity.ok(voyages);
	}

}
