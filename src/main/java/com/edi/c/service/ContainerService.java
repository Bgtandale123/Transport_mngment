
package com.edi.c.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.edi.a.models.ContainerDetails;


public interface ContainerService {

	public ContainerDetails createContainerDetails(ContainerDetails containerDetails);
	
	public ContainerDetails updateContainerDetails(ContainerDetails containerDetails);

	public Optional<ContainerDetails> getContainerDetailsById(int id);

	public List<ContainerDetails> getAllContainerDetails(ContainerDetails containerDetails);
	
	 public void deleteContainerDetails(int id);
	    //get all con by c-no
	  List<ContainerDetails> getAllContainer(@Param("containerNumber") String containerNumber);

	
}
