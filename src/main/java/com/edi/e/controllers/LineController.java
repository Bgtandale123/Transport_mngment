package com.edi.e.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.edi.a.models.BLDetails;
import com.edi.a.models.LineDetails;
import com.edi.a.models.Vessel;
import com.edi.c.service.LineService;

import jakarta.transaction.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/edi")
public class LineController {

    @Autowired
    private LineService lineService;

	/*
	 * @PostMapping("/createLineDetails")
	 * // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public LineDetails createLineDetails(@RequestBody LineDetails lineDetails)
	 * { LineDetails line=lineService.createLineDetails(lineDetails); return line; }
	 */
    @PostMapping("/createLineDetails")
    public ResponseEntity<?> createLineDetails(@RequestBody LineDetails lineDetails) {
        try {
            LineDetails line = lineService.createLineDetails(lineDetails);
            return ResponseEntity.ok(line);
        } catch (DataIntegrityViolationException e) {
        	System.out.println();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry for the line code . The data you are trying to add already exists.");
        }
    }
    
	/*
	 * @PutMapping("/updateLineDetails")
	 * // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public LineDetails updateLineDetails(@RequestBody LineDetails lineDetails)
	 * { LineDetails line=lineService.updateLineDetails(lineDetails); return line; }
	 */
    
    ///show duplicted error msg on update 
   @PutMapping("/updateLineDetails")
    public ResponseEntity<?> updateLineDetails(@RequestBody LineDetails lineDetails) {
        try {
            LineDetails updatedLineDetails = lineService.updateLineDetails(lineDetails);
            return ResponseEntity.ok(updatedLineDetails);
        } catch (DataIntegrityViolationException e) {
            // Extract the duplicate value from the exception
            String duplicateValue = extractDuplicateValue(e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry for '" + duplicateValue + "'. The data you are trying to update already exists.");
        }
    }

    private String extractDuplicateValue(DataIntegrityViolationException e) {
           String errorMessage = e.getRootCause().getMessage();
            String[] values = errorMessage.split("'");
        if (values.length >= 2) {
            return "'" + values[1] + "'"; // Assuming the first value in the error message is the duplicate value
        } else {
            return "unknown"; // Unable to extract duplicate value
        }
    }
    
    @GetMapping("/getLineDetailsById/{id}")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<LineDetails> getLineDetailsById(@PathVariable("id") int id) {
        Optional<LineDetails> line1=lineService.getLineDetailsById(id);
        return line1;
    }

    @GetMapping("/getAllLineDetails")
   // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<LineDetails> getAllLineDetails(LineDetails lineDetails) {
        List<LineDetails> line2= (List<LineDetails>) lineService.getAllLineDetails(lineDetails);
        return line2;
    }
    
    @DeleteMapping("/deleteLineDetails/{id}")
    public void deleteLineDetails(@PathVariable("id") 
    Integer id) throws Exception {
      lineService.deleteLineDetails(id);
      
    }

	
	//@GetMapping("/line/{code}") // @PostMapping("/line") 
	public ResponseEntity<List<LineDetails>> getBLDetailsByVoyageID(@PathVariable String code) {
		List<LineDetails> linecode = lineService.getJoinInformation(code);
		System.out.println("input-->" + code + "linecode====>" + linecode);
		return new ResponseEntity<>(linecode, HttpStatus.OK);

	}
	 
	/*@PostMapping("/line")
	public ResponseEntity<List<LineDetails>> getBLDetailsByVoyageID(@RequestBody Map<String, String> requestBody) {
		String code = requestBody.get("code");
		if (code == null)	  { 
		  // Handle missing parameter return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
	  
	  List<LineDetails> linecode = lineService.getJoinInformation(code);
	  System.out.println("input-->" + code + " linecode====>" + linecode);
	  return new ResponseEntity<>(linecode, HttpStatus.OK); }    
*/	
    /*for list [format]
	 * @PostMapping("/line") public ResponseEntity<List<LineDetails>>
	 * getBLDetailsByVoyageID(@RequestBody List<String> codes) { if (codes == null
	 * || codes.isEmpty()) { // Handle missing or empty list return new
	 * ResponseEntity<>(HttpStatus.BAD_REQUEST); }
	 * 
	 * List<LineDetails> linecode = lineService.getJoinInformation(codes);
	 * System.out.println("input-->" + codes + " linecode====>" + linecode); return
	 * new ResponseEntity<>(linecode, HttpStatus.OK); }
	 */

   
}


