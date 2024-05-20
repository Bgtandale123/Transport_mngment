package com.edi.b.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edi.a.models.BLContainerInfo;

@Repository
public interface BLContainerInfoRepsitory extends CrudRepository<BLContainerInfo,Integer> {
	
	 public BLContainerInfo findById(int id);

}
