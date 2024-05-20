package com.edi.c.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.edi.a.models.BLDetails;
import com.edi.a.models.Vessel;

public interface VesselService {

	public Vessel createVessel(Vessel vessel);

	public Vessel updateVessel(Vessel vessel);

	public Optional<Vessel> getVesselById(int id);

	public List<Vessel> getAllVessel(Vessel vessel);

	public void deleteVessel(int id);
	
    List<Vessel> getJoinInformation(@Param("vesselId") String vesselId);

}
