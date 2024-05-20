/*
 * package com.edi.e.controllers;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.edi.a.models.BLDetails; import com.edi.a.models.LineDetails;
 * import com.edi.a.models.Vessel; import com.edi.a.models.VoyageDetails; import
 * com.edi.c.service.BLDetailsService; import com.edi.c.service.LineService;
 * import com.edi.c.service.VesselService; import
 * com.edi.c.service.VoyageService;
 * 
 * @CrossOrigin(origins = "*", maxAge = 3600)
 * 
 * @RestController
 * 
 * @RequestMapping("/edi/aggregated") public class AggregatedController {
 * private final VoyageService voyageService; private final VesselService
 * vesselService; private final LineService lineService; private final
 * BLDetailsService blService;
 * 
 * @Autowired public AggregatedController(VoyageService voyageService,
 * VesselService vesselService, LineService lineService, BLDetailsService
 * blService) { this.voyageService = voyageService; this.vesselService =
 * vesselService; this.lineService = lineService; this.blService = blService; }
 * 
 * // ccc
 * 
 * @GetMapping(value
 * ="/details/{identifier}/{identifier1}/{identifier2}/{identifier3}", produces
 * = "application/json") public ResponseEntity<AggregatedResponse>
 * getAggregatedDetails(
 * 
 * @PathVariable String identifier,
 * 
 * @PathVariable String identifier1,
 * 
 * @PathVariable String identifier2,
 * 
 * @PathVariable String identifier3) { List<VoyageDetails> voyageDetails =
 * voyageService.getJoinInformation(identifier); List<Vessel> vessels =
 * vesselService.getJoinInformation(identifier1); List<LineDetails> lineDetails
 * = lineService.getJoinInformation(identifier2); List<BLDetails> blDetails =
 * blService.getJoinInformation(identifier3);
 * 
 * AggregatedResponse response = new AggregatedResponse(voyageDetails, vessels,
 * lineDetails, blDetails); return new ResponseEntity<>(response,
 * HttpStatus.OK); }
 * 
 * 
 * 
 * 
 * @GetMapping("/combined-details/{blno}/{code}/{vesselName}/{voyageNumber}")
 * // @GetMapping("/combined-details") public ResponseEntity<Object>
 * getCombinedDetails(
 * 
 * @RequestParam(required = false) String blno,
 * 
 * @RequestParam(required = false) String code,
 * 
 * @RequestParam(required = false) String vesselName,
 * 
 * @RequestParam(required = false) String voyageNumber) {
 * 
 * if (blno != null) { List<BLDetails> blDetails =
 * blService.getJoinInformation(blno); return new ResponseEntity<>(blDetails,
 * HttpStatus.OK); } else if (code != null) { List<LineDetails> linecode =
 * lineService.getJoinInformation(code); return new ResponseEntity<>(linecode,
 * HttpStatus.OK); } else if (vesselName != null) { List<Vessel> id =
 * vesselService.getJoinInformation(vesselName); return new ResponseEntity<>(id,
 * HttpStatus.OK); } else if (voyageNumber != null) { List<VoyageDetails> vno =
 * voyageService.getJoinInformation(voyageNumber); return new
 * ResponseEntity<>(vno, HttpStatus.OK); } else { Handle invalid or missing
 * parameters return new ResponseEntity<>("Invalid or missing parameters",
 * HttpStatus.BAD_REQUEST); } }
 * 
 * @GetMapping("/combineddetails/{blno}/{code}/{vesselName}/{voyageNumber}")
 * public ResponseEntity<Object> getCombinedDetailsEntity(
 * 
 * @PathVariable(required = false) String blno,
 * 
 * @PathVariable(required = false) String code,
 * 
 * @PathVariable(required = false) String vesselName,
 * 
 * @PathVariable(required = false) String voyageNumber) {
 * 
 * List<Object> combinedResult = new ArrayList<>();
 * 
 * if (blno != null) { List<BLDetails> blDetails =
 * blService.getJoinInformation(blno); combinedResult.addAll(blDetails); }
 * 
 * if (code != null) { List<LineDetails> linecode =
 * lineService.getJoinInformation(code); combinedResult.addAll(linecode); }
 * 
 * if (vesselName != null) { List<Vessel> id =
 * vesselService.getJoinInformation(vesselName); combinedResult.addAll(id); }
 * 
 * if (voyageNumber != null) { List<VoyageDetails> vno =
 * voyageService.getJoinInformation(voyageNumber); combinedResult.addAll(vno); }
 * 
 * if (!combinedResult.isEmpty()) { return ResponseEntity.ok(combinedResult); }
 * else { // Handle invalid or missing parameters return
 * ResponseEntity.badRequest().body("Invalid or missing parameters"); } }
 * 
 * 
 * 
 * }
 */