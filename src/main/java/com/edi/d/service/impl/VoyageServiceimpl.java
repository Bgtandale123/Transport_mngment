
package com.edi.d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edi.a.models.VoyageDetails;
import com.edi.b.Repository.VoyageRepository;
import com.edi.c.service.VoyageService;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageServiceimpl implements VoyageService {

	@Autowired
	private VoyageRepository voyageRepository;

	@Override
	public VoyageDetails createVoyageDetails(VoyageDetails voyageDetails) {
		VoyageDetails voyage = voyageRepository.save(voyageDetails);
		return voyage;
	}

	@Override
	public Optional<VoyageDetails> getVoyageDetailsById(int id) {
		Optional<VoyageDetails> vs = Optional.ofNullable(voyageRepository.findById(id));
		return vs;
	}

	@Override
	public List<VoyageDetails> getAllVoyageDetails(VoyageDetails voyageDetails) {
		List<VoyageDetails> voyage1 = (List<VoyageDetails>) voyageRepository.findAll();
		return voyage1;
	}

	@Override
	public VoyageDetails updateVoyageDetails(VoyageDetails voyageDetails) {
		VoyageDetails updatevoyage=voyageRepository.save(voyageDetails);

		return updatevoyage;
	}

	@Override
	public void deleteVoyageDetails(int id) {
		voyageRepository.deleteById(id);
		
	}

	@Override
	public List<VoyageDetails> getJoinInformation(String voyageNumber) {
		
		return voyageRepository.getJoinInformation(voyageNumber);
	}

	@Override
	public List<VoyageDetails> getVoyages(String vesseltype) {
        return voyageRepository.getVoyages(vesseltype);
    }
}
