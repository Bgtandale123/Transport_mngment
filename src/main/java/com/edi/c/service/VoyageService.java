
package com.edi.c.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.edi.a.models.Vessel;
import com.edi.a.models.VoyageDetails;

public interface VoyageService {
	
	public VoyageDetails createVoyageDetails(VoyageDetails voyageDetails);
	
	public VoyageDetails updateVoyageDetails(VoyageDetails voyageDetails);

	public Optional<VoyageDetails> getVoyageDetailsById(int id);

	public List<VoyageDetails> getAllVoyageDetails(VoyageDetails voyageDetails);
	
	public void deleteVoyageDetails(int id);
	
    List<VoyageDetails> getJoinInformation(@Param("voyageNumber") String voyageNumber);

    List<VoyageDetails> getVoyages(@Param("vesseltype") String vesseltype);

}
