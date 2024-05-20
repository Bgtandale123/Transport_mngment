package com.edi.c.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.edi.a.models.BLDetails;


public interface BLDetailsService {
	
    public BLDetails createBLDetails(BLDetails blDetails);
    
    public BLDetails updateBLDetails(BLDetails blDetails);

    public Optional<BLDetails> getBLDetailsById(int id);

    public List<BLDetails> getAllBLDetails(BLDetails blDetails);
    
    public void deleteBLDetails(int id);
    
   // List<BLDetails> getJoinInformation(@Param("blno") String blno);
	List<BLDetails> getJoinInformation(@Param("blnoList") List<String> blnoList);

	public List<BLDetails> getblbyvesselandvoyage(String vesseltype, String voyage,String carrierInformation);
}
