package com.edi.d.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edi.a.models.BLContainerInfo;
import com.edi.a.models.BLDetails;
import com.edi.a.models.ContainerDetails;
import com.edi.a.models.LineDetails;
import com.edi.a.models.Vessel;
import com.edi.a.models.VoyageDetails;
import com.edi.b.Repository.BLContainerInfoRepsitory;
import com.edi.b.Repository.BLDetailsRepository;
import com.edi.b.Repository.ContainerRepository;
import com.edi.b.Repository.LineRepository;
import com.edi.b.Repository.VesselRepository;
import com.edi.b.Repository.VoyageRepository;
import com.edi.c.service.BLContainerInfoService;

@Service
public class BLContainerInfoServiceimpl implements BLContainerInfoService {
	
	@Autowired
	private BLContainerInfoRepsitory blContainerRepo;

	@Override
	public BLContainerInfo createBLContainerInfo(BLContainerInfo blContainer) {
		BLContainerInfo saveBlcontainer=blContainerRepo.save(blContainer);
		return saveBlcontainer;
	}

	@Override
	public BLContainerInfo updateBLContainerInfo(BLContainerInfo blContainer) {
		BLContainerInfo updateBlcontainer=blContainerRepo.save(blContainer);
		return updateBlcontainer;
	}

	@Override
	public Optional<BLContainerInfo> getBLContainerInfoById(int id) {
		Optional<BLContainerInfo> getBLcontainer = Optional.ofNullable(blContainerRepo.findById(id));
		return getBLcontainer;
	}

	@Override
	public List<BLContainerInfo> getAllBLContainerInfo(BLContainerInfo blContainer) {
		List<BLContainerInfo> getallBLcontainer = (List<BLContainerInfo>) blContainerRepo.findAll();
		return getallBLcontainer;
	}

	@Override
	public void deleteBLContainerInfo(int id) {
		 blContainerRepo.deleteById(id);
		
	}
	
	
	@Autowired
    private  BLDetailsRepository bl1Repository;
	@Autowired
    private VesselRepository vesselRepository;
	@Autowired
	private VoyageRepository voyageRepository;
	  @Autowired 
	  private LineRepository lineRepository;
	  @Autowired 
	  private ContainerRepository containerRepository;
	  @Autowired
		private BLContainerInfoRepsitory blContainerRepo1;

		public BLContainerInfoServiceimpl(BLDetailsRepository bl1Repository, VesselRepository vesselRepository,
				VoyageRepository voyageRepository, LineRepository lineRepository,
				ContainerRepository containerRepository, BLContainerInfoRepsitory blContainerInfoRepsitory1)    		 {
        this.bl1Repository=bl1Repository;
        this.vesselRepository=vesselRepository;
        this.voyageRepository=voyageRepository;
        this.lineRepository = lineRepository;
        this.containerRepository=containerRepository;
        this.blContainerRepo =blContainerRepo;
        
    }

    public List<Object> getDataFromModels() {
        List<Object> combinedData = new ArrayList<>();

        List<BLDetails> model1Data = (List<BLDetails>) bl1Repository.findAll();
        List<Vessel> model2Data = (List<Vessel>) vesselRepository.findAll();
        List<VoyageDetails> model3Data = (List<VoyageDetails>) voyageRepository.findAll();
        List<LineDetails> model4Data = (List<LineDetails>) lineRepository.findAll();
        List<BLContainerInfo> model5Data = (List<BLContainerInfo>) blContainerRepo.findAll();
        List<ContainerDetails> model6Data = (List<ContainerDetails>) containerRepository.findAll();

        combinedData.addAll(model1Data);
        combinedData.addAll(model2Data);
        combinedData.addAll(model3Data);
        combinedData.addAll(model4Data);
        combinedData.addAll(model5Data);
        combinedData.addAll(model6Data);

        return combinedData;
    }


}
