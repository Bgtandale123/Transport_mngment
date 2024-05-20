
package com.edi.e.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edi.a.models.BLDetails;
import com.edi.a.models.LineDetails;
import com.edi.a.models.Vessel;
import com.edi.a.models.VoyageDetails;
import com.edi.c.service.BLDetailsService;
import com.edi.c.service.LineService;
import com.edi.c.service.VesselService;
import com.edi.c.service.VoyageService;
import com.fasterxml.jackson.databind.ObjectMapper;

  @RestController
  @CrossOrigin(origins = "*", maxAge = 3600)
  @RequestMapping("/edi") 
  public class My_Controller {
  
  @Autowired private BLDetailsService blService;
  
  @Autowired private LineService lineService;
  
  @Autowired private VesselService vesselService;
  
  @Autowired private VoyageService voyageService;
  
  @GetMapping("/test/{blno}/{code}/{vesselName}/{voyageNumber}") 
	public ResponseEntity<Map<String, List<?>>> getCombinedDetails(

			@RequestParam(value = "blno", required = false) List<String> blnoList,

			@PathVariable String code,

			@PathVariable String vesselName,

			@PathVariable String voyageNumber) {

		Map<String, List<?>> result = new HashMap();

		// List<BLDetails> blDetails = blService.getJoinInformation(blno);
		// result.put("blDetails", blDetails);

		List<LineDetails> lineDetails = lineService.getJoinInformation(code);
		result.put("lineDetails", lineDetails);

		List<Vessel> vessels = vesselService.getJoinInformation(vesselName);
		result.put("vessels", vessels);

		List<VoyageDetails> voyageDetails = voyageService.getJoinInformation(voyageNumber);
		result.put("voyageDetails", voyageDetails);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
  
// passing parameter all combine api
  @GetMapping("/a") public ResponseEntity<Map<String, List<?>>>
  getCombinedDetail(
  
  @RequestParam(value = "blno", required = false) List<String> blnoList,
  
  @RequestParam(value = "code", required = false) String code,
  
  @RequestParam(value = "vesselName", required = false) String vesselName,
  
  @RequestParam(value = "voyageNumber", required = false) String voyageNumber)
  {
  
  Map<String, List<?>> result = new HashMap<>();
  
  if (blnoList != null && !blnoList.isEmpty()) { List<BLDetails> blDetails =
  blService.getJoinInformation(blnoList); result.put("blDetails", blDetails); }
  
  if (code != null) { List<LineDetails> lineDetails =
  lineService.getJoinInformation(code); result.put("lineDetails", lineDetails);
  }
  
  if (vesselName != null) { List<Vessel> vessels =
  vesselService.getJoinInformation(vesselName); result.put("vessels", vessels);
  }
  
  if (voyageNumber != null) { List<VoyageDetails> voyageDetails =
  voyageService.getJoinInformation(voyageNumber); result.put("voyageDetails",
  voyageDetails); }
  
  return new ResponseEntity<>(result, HttpStatus.OK); }
 
  //post method for all api
	
  @PostMapping("/rowbyfeild")
  public ResponseEntity<Map<String, List<?>>> getCombinedDetails(@RequestBody Map<String, Object> requestBody) {
      Map<String, List<?>> result = new HashMap<>();

      // Extract parameters from the request body
      List<String> blnoList = (List<String>) requestBody.get("blnoList");
      String code = (String) requestBody.get("code");
      String vesselId = (String) requestBody.get("vesselId");
      String voyageNumber = (String) requestBody.get("voyageNumber");

      // Fetch data based on parameters
      if (blnoList != null && !blnoList.isEmpty()) {
          List<BLDetails> blDetails = blService.getJoinInformation(blnoList);
          result.put("blDetails", blDetails);
      }

      if (code != null) {
          List<LineDetails> lineDetails = lineService.getJoinInformation(code);
          result.put("lineDetails", lineDetails);
      }

      if (vesselId != null) {
          List<Vessel> vessels = vesselService.getJoinInformation(vesselId);
          result.put("vessels", vessels);
      }

      if (voyageNumber != null) {
          List<VoyageDetails> voyageDetails = voyageService.getJoinInformation(voyageNumber);
          result.put("voyageDetails", voyageDetails);
      }

      return new ResponseEntity<>(result, HttpStatus.OK);
  }
	   
	/*
	 * @PostMapping("//") public ResponseEntity<List<Object>>
	 * getCombinedDetails(@RequestBody Map<String, Object> requestBody) {
	 * List<Object> result = new ArrayList<>();
	 * 
	 * // Extract parameters from the request body String blno = (String)
	 * requestBody.get("blno"); List<String> blnoList = (List<String>)
	 * requestBody.get("blnoList"); String code = (String) requestBody.get("code");
	 * String vesselId = (String) requestBody.get("vesselId"); String voyageNumber =
	 * (String) requestBody.get("voyageNumber");
	 * 
	 * // Fetch data based on parameters if (blno != null) { List<BLDetails>
	 * blDetails = blService.getJoinInformation(Collections.singletonList(blno));
	 * result.addAll(flattenDetails(blDetails)); }
	 * 
	 * if (blnoList != null) { List<BLDetails> blDetails =
	 * blService.getJoinInformation(blnoList);
	 * result.addAll(flattenDetails(blDetails)); }
	 * 
	 * if (code != null) { List<LineDetails> lineDetails =
	 * lineService.getJoinInformation(code);
	 * result.addAll(flattenDetails(lineDetails)); }
	 * 
	 * if (vesselId != null) { List<Vessel> vessels =
	 * vesselService.getJoinInformation(vesselId);
	 * result.addAll(flattenDetails(vessels)); }
	 * 
	 * if (voyageNumber != null) { List<VoyageDetails> voyageDetails =
	 * voyageService.getJoinInformation(voyageNumber);
	 * result.addAll(flattenDetails(voyageDetails)); }
	 * 
	 * return new ResponseEntity<>(result, HttpStatus.OK); }
	 * 
	 * private List<Object> flattenDetails(List<?> details) { List<Object>
	 * flattenedList = new ArrayList<>(); for (Object detail : details) {
	 * ObjectMapper objectMapper = new ObjectMapper(); Map<String, Object> detailMap
	 * = objectMapper.convertValue(detail, Map.class); flattenedList.add(detailMap);
	 * } return flattenedList; }
	 */


  // get mapping api...
  @GetMapping("/combineddetails/{code}/{vesselName}/{voyageNumber}/{blnos}")
  public ResponseEntity<Map<String, List<?>>> getCombinedDetails(
          @PathVariable(name = "code") String code,
          @PathVariable(name = "vesselName") String vesselName,
          @PathVariable(name = "voyageNumber") String voyageNumber,
       //   @PathVariable List<String> blnos)
  @RequestParam(value = "blno", required = false) List<String> blnoList)
  {

      Map<String, List<?>> result = new HashMap<>();

      // Fetch data based on parameters
      for (String blno : blnoList) {
          if (blno != null) {
              List<BLDetails> blDetails = blService.getJoinInformation(Collections.singletonList(blno));
              result.put("blDetails_" + blno, blDetails);
          }
      }

      if (code != null) {
          List<LineDetails> lineDetails = lineService.getJoinInformation(code);
          result.put("lineDetails", lineDetails);
      }

      if (vesselName != null) {
          List<Vessel> vessels = vesselService.getJoinInformation(vesselName);
          result.put("vessels", vessels);
      }

      if (voyageNumber != null) {
          List<VoyageDetails> voyageDetails = voyageService.getJoinInformation(voyageNumber);
          result.put("voyageDetails", voyageDetails);
      }

      return new ResponseEntity<>(result, HttpStatus.OK);
  }


	
}
 
  
  
  
 