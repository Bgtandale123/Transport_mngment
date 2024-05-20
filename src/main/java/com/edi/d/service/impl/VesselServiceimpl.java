package com.edi.d.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edi.a.models.BLDetails;
import com.edi.a.models.Vessel;
import com.edi.b.Repository.VesselRepository;
import com.edi.c.service.VesselService;

import java.util.List;
import java.util.Optional;

@Service
public class VesselServiceimpl implements VesselService {

    @Autowired
    private VesselRepository vesselRepository;
    @Override
    public Vessel createVessel(Vessel vessel) {
       Vessel vssl=vesselRepository.save(vessel);
       return vssl;
    }

    @Override
    public Optional<Vessel> getVesselById(int id) {
        Optional<Vessel> vs= Optional.ofNullable(vesselRepository.findById(id));
        return vs;
    }

    @Override
    public List<Vessel> getAllVessel(Vessel vessel) {
        List<Vessel> vsall= (List<Vessel>) vesselRepository.findAll();
        return vsall;
    }

	@Override
	public Vessel updateVessel(Vessel vessel) {
		Vessel updatevssl=vesselRepository.save(vessel);
		return updatevssl;
	}


	@Override
	public void deleteVessel(int id) {
		vesselRepository.deleteById(id);
		
	}

	@Override
	public List<Vessel> getJoinInformation(String vesselId) {
		return vesselRepository.getJoinInformation(vesselId) ;
	}

	

}
