package com.edi.c.service;

import java.util.List;
import java.util.Optional;

import com.edi.a.models.BLContainerInfo;



public interface BLContainerInfoService 
{

	  public BLContainerInfo createBLContainerInfo(BLContainerInfo blContainer);
	  
	  public BLContainerInfo updateBLContainerInfo(BLContainerInfo blContainer);
	  
	  public Optional<BLContainerInfo> getBLContainerInfoById(int id);
	  
	  public List<BLContainerInfo> getAllBLContainerInfo(BLContainerInfo blContainer);
	  
	  public void deleteBLContainerInfo(int id);
		public List<Object> getDataFromModels();

	
}
