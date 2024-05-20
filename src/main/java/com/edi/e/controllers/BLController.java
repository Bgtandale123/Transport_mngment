package com.edi.e.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edi.a.models.BLContainerInfo;
import com.edi.a.models.BLDetails;
import com.edi.c.service.BLContainerInfoService;
import com.edi.c.service.BLDetailsService;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/edi")
public class BLController {

	@Autowired
	private BLDetailsService blService;

	@Autowired
	private BLContainerInfoService blContainerService;


	@PostMapping("/createBLDetails")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public BLDetails createBLDetails(@RequestBody BLDetails blDetails) {
		System.out.println("blDetails===>"+ blDetails.toString());
		BLDetails saveBL = blService.createBLDetails(blDetails);
		return saveBL;
	}

	@PostMapping("/createBLDetails/containerInfo")
	ResponseEntity<BLDetails> saveUserPolicy(@RequestBody BLDetails blDetails) {
		BLDetails saveBL = blService.createBLDetails(blDetails);
		List<BLContainerInfo> containerinfo = blDetails.getShippingContainerInfo();

		for (BLContainerInfo blContainer : containerinfo) {
			blContainer.setBlid(blDetails.getId());
			blContainerService.createBLContainerInfo(blContainer);

		}
		return ResponseEntity.ok().body(saveBL);

	}
	

	/*
	 * @PutMapping("/updateBLDetails")
	 * // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')"
	 * ) public BLDetails updateBLDetails(@RequestBody BLDetails blDetails) {
	 * BLDetails updateBL = blService.updateBLDetails(blDetails); return updateBL; }
	 */
	
	@Transactional
	@PutMapping("/updateBLDetails")
	ResponseEntity<BLDetails> saveorupdate(@RequestBody BLDetails blDetails) {
		BLDetails saveBL = blService.updateBLDetails(blDetails);
		List<BLContainerInfo> containerinfo = blDetails.getShippingContainerInfo();

		for (BLContainerInfo blContainer : containerinfo) {
			blContainer.setBlid(blDetails.getId());
			blContainerService.updateBLContainerInfo(blContainer);

		}
		return ResponseEntity.ok().body(saveBL);

	}
	
	/*
	 * @Transactional
	 * 
	 * @PutMapping("/updateBLDetails") public BLDetails
	 * updateBLDetailsAndContainers(BLDetails blDetails) { // Update BLDetails
	 * BLDetails updatedBLDetails = blService.updateBLDetails(blDetails);
	 * 
	 * // Update or create BLContainerInfo entries List<BLContainerInfo>
	 * containerInfoList = blDetails.getShippingContainerInfo(); for
	 * (BLContainerInfo containerInfo : containerInfoList) {
	 * containerInfo.setBlid(blDetails.getId());
	 * blContainerService.updateBLContainerInfo(containerInfo); }
	 * 
	 * return updatedBLDetails; }
	 */
	
	@GetMapping("/getBLDetailsById/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Optional<BLDetails> getBLDetailsById(@PathVariable("id") int id) {
		Optional<BLDetails> getBL = blService.getBLDetailsById(id);
		return getBL;
	}

	@GetMapping("/getAllBLDetails")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<BLDetails> getAllBLDetails(BLDetails lineDetails) {
		List<BLDetails> line2 = (List<BLDetails>) blService.getAllBLDetails(lineDetails);
		
		
		return line2;
	}

	@DeleteMapping("/deleteBLDetails/{id}")
	public void deleteBLDetails(@PathVariable("id") Integer id) throws Exception {
		blService.deleteBLDetails(id);
	}
	
	@GetMapping("/bl-details/{blno}")
	public ResponseEntity<List<BLDetails>> getBLDetailsByVoyageID(@RequestParam(value = "blno", required = false) List<String> blnoList) throws Exception {
	    List<BLDetails> blDetails = blService.getJoinInformation(blnoList);

	    if (blDetails.isEmpty()) {
	        // If no data is found, return a 404 Not Found status
	        return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
	    } else {
	        // If data is found, return it with a 200 OK status
	        return new ResponseEntity<>(blDetails, HttpStatus.OK);
	    }
	}

	@GetMapping("/")
    public ResponseEntity<List<BLDetails>> getBLDetailsByBlno1(@RequestParam(value = "blno", required = false) List<String> blnoList) {
        if (blnoList == null || blnoList.isEmpty()) {
            // Handle invalid or missing parameters
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<BLDetails> blDetails = blService.getJoinInformation(blnoList);

        if (blDetails.isEmpty()) {
            // If no data is found, return a 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // If data is found, return it with a 200 OK status
            return new ResponseEntity<>(blDetails, HttpStatus.OK);
        }
    }

	//get bl details by multi bl no created query 
	@PostMapping("/bl")
    public ResponseEntity<List<BLDetails>> getBLDetailsByBlno(@RequestBody List<String> blnoList) {
        List<BLDetails> blDetails = blService.getJoinInformation(blnoList);
      System.out.println("--->"+ blnoList );
        if (blDetails.isEmpty()) {
            // If no data is found, return a 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // If data is found, return it with a 200 OK status
            return new ResponseEntity<>(blDetails, HttpStatus.OK);
        }
    }
	
    @GetMapping("/join-information/{vesseltype}/{voyage}/{carrierInformation}")
    public ResponseEntity<List<BLDetails>> getJoinInformation(
            @PathVariable("vesseltype") String vesseltype,
            @PathVariable("voyage") String voyage,
    		@PathVariable("carrierInformation") String carrierInformation){
    {

        List<BLDetails> joinInformation = blService.getblbyvesselandvoyage(vesseltype, voyage,carrierInformation);
        return ResponseEntity.ok(joinInformation);
    }
}

}

