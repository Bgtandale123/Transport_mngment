package com.edi.e.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edi.a.models.BLDetails;
import com.edi.a.models.Vessel;
import com.edi.c.service.VesselService;



import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/edi")
public class VesselController {
    @Autowired
    private VesselService vesselService;


   @PostMapping("/createVessel")
    public ResponseEntity<?> createVessel(@RequestBody Vessel vessel) {
        try {
            Vessel createdVessel = vesselService.createVessel(vessel);
            return ResponseEntity.ok(createdVessel);
        } catch (DataIntegrityViolationException e) {
            // Extract the duplicate value from the exception
            String duplicateValue = extractDuplicateValue(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry for '" + duplicateValue + "'. The data you are trying  that vessel or imo or callsign to add already exists.");
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

    
    
    
   // @PostMapping("/createVessel")
//    @ApiOperation(value = "This method is used to create vessel details")
//    @ApiResponses(value= {@ApiResponse(code = 200, message = "Vessel Details stored successfully"),
//    		@ApiResponse(code = 404, message = "not found")})
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
   // public Vessel createVessel( @RequestBody Vessel vessel) {
   //     Vessel vssl=vesselService.createVessel(vessel);
     //   return vssl;
   // }
    
    @PutMapping("/updateVessel")
    public ResponseEntity<?> updateVessel(@RequestBody Vessel vessel) {
        try {
            Vessel updatedVessel = vesselService.updateVessel(vessel);
            return ResponseEntity.ok(updatedVessel);
        } catch (DataIntegrityViolationException e) {
            // Extract the duplicate value from the exception
            String duplicateValue = extractDuplicateValue(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry for '" + duplicateValue + "'. The data you are trying to update already exists.");
        }
    }

    private String extractDuplicatevoyage(DataIntegrityViolationException e) {
        String errorMessage = e.getRootCause().getMessage();
        String[] values = errorMessage.split("'");
        if (values.length >= 2) {
            return "'" + values[1] + "'"; // Assuming the first value in the error message is the duplicate value
        } else {
            return "unknown"; // Unable to extract duplicate value
        }
    }

    
	/*
	 * @PutMapping("/updateVessel")
	 * // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public Vessel upadateVessel( @RequestBody Vessel vessel) {
	 * 
	 * Vessel updatevssl=vesselService.updateVessel(vessel); return updatevssl; }
	 */ 

    @GetMapping("/getVesselById/{id}")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<Vessel> getVesselById(@PathVariable("id") int id) {
        Optional<Vessel> vs=vesselService.getVesselById(id);
        return vs;
    }

    @GetMapping("/getAllVessel")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Vessel> getAllVessel(Vessel vessel) {
        List<Vessel> vsall= (List<Vessel>) vesselService.getAllVessel(vessel);
        return vsall;
    }
    
    @DeleteMapping("/deleteVessel/{id}")
    public void deleteVesselById(@PathVariable("id") 
    Integer id) throws Exception {
      vesselService.deleteVessel(id);
    }

    
   /* @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }
    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";*/





    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    //@PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    //@PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
    

  @GetMapping("/vesel/{vesselId}") 
  public List<Vessel>getBLDetailsByVoyageID(@PathVariable String vesselId)
  { 
	  List<Vessel>id = vesselService.getJoinInformation(vesselId);
	  System.out.println("op===>"+ id);
	  return id;
  
  }
 
}
