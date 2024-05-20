package com.edi.d.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edi.a.models.BLDetails;

import com.edi.b.Repository.BLDetailsRepository;
import com.edi.c.service.BLDetailsService;

@Service
public class BLDetailsServiceimpl implements BLDetailsService {

	@Autowired
	private BLDetailsRepository blRepository;

	@Override
	public BLDetails createBLDetails(BLDetails blDetails) {
		BLDetails saveBL = blRepository.save(blDetails);
		return saveBL;
	}

	@Override
	public BLDetails updateBLDetails(BLDetails blDetails) {
		BLDetails updateBL = blRepository.save(blDetails);
		return updateBL;
	}

	@Override
	public Optional<BLDetails> getBLDetailsById(int id) {
		Optional<BLDetails> getBL = Optional.ofNullable(blRepository.findById(id));
		return getBL;
	}

	@Override
	public List<BLDetails> getAllBLDetails(BLDetails blDetails) {
		List<BLDetails> getallBL = (List<BLDetails>) blRepository.findAll();
		return getallBL;
	}

	@Override
	public void deleteBLDetails(int id) {
		blRepository.deleteById(id);

	}

	/*
	 * public List<BLDetails> getJoinInformation(String blno) { return
	 * blRepository.getJoinInformation(blno); }
	 */
    public List<BLDetails> getJoinInformation(List<String> blnoList) {
        return blRepository.getJoinInformation(blnoList);
    }
    
    public List<BLDetails> getblbyvesselandvoyage(String vesseltype, String voyage,String carrierInformation) {
        return blRepository.getblbyvesselandvoyage(vesseltype, voyage,carrierInformation);
    }

}
