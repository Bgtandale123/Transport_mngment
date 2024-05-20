package com.edi.b.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edi.a.models.ContainerDetails;

@Repository
public interface ContainerRepository extends CrudRepository<ContainerDetails,Integer> {

    public ContainerDetails findById(int id);
   
    @Query("SELECT cd FROM ContainerDetails cd WHERE cd.containerNumber = :containerNumber")
    List<ContainerDetails> getAllContainer(@Param("containerNumber") String containerNumber);

    
    
}
