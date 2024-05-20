
  package com.edi.e.controllers;
  
  import java.util.List;
  
  import com.edi.a.models.BLDetails; import com.edi.a.models.LineDetails;
  import com.edi.a.models.Vessel; import com.edi.a.models.VoyageDetails; import
  com.fasterxml.jackson.annotation.JsonProperty;
  
  public class AggregatedResponse {
  
  @JsonProperty("voyageDetails") private List<VoyageDetails> voyageDetails;
  
  @JsonProperty("vessels") 		private List<Vessel> vessels;
  
  @JsonProperty("lineDetails") private List<LineDetails> lineDetails;
  
  @JsonProperty("blDetails") private List<BLDetails> blDetails;

	public AggregatedResponse(List<VoyageDetails> voyageDetails, List<Vessel> vessels, List<LineDetails> lineDetails,
			List<BLDetails> blDetails) {
		this.voyageDetails = voyageDetails;
		this.vessels = vessels;
		this.lineDetails = lineDetails;
		this.blDetails = blDetails;
	}

  }
 