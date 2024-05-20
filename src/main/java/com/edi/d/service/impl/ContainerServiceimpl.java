
  package com.edi.d.service.impl;
  
  
  
  
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;

import com.edi.a.models.ContainerDetails;
import com.edi.b.Repository.ContainerRepository;
import com.edi.c.service.ContainerService;

import java.util.List; import java.util.Optional;
  
  @Service public class ContainerServiceimpl implements ContainerService {
  
  @Autowired private ContainerRepository containerRepository;
  
  @Override public ContainerDetails createContainerDetails(ContainerDetails
  containerDetails) { ContainerDetails
  container=containerRepository.save(containerDetails); return container; }
  
  @Override public Optional<ContainerDetails> getContainerDetailsById(int id) {
  Optional<ContainerDetails> getcontainer=
  Optional.ofNullable(containerRepository.findById(id)); return getcontainer; }
  
  @Override public List<ContainerDetails>
  getAllContainerDetails(ContainerDetails containerDetails) {
  List<ContainerDetails> getall= (List<ContainerDetails>)
  containerRepository.findAll(); return getall; }

@Override
public ContainerDetails updateContainerDetails(ContainerDetails containerDetails) {
	ContainerDetails updatecontainer=containerRepository.save(containerDetails);
	return updatecontainer;
}

@Override
public void deleteContainerDetails(int id) {
	containerRepository.deleteById(id);
	
}

/*
 * @Override public List<ContainerDetails> getContainerdetails(String
 * containerNumber) { System.out.println("===>"+ containerNumber); return
 * containerRepository.getAllContainer(containerNumber) ; }
 */
public List<ContainerDetails> getAllContainer(String containerNumber) {
    return containerRepository.getAllContainer(containerNumber);
}
}
 