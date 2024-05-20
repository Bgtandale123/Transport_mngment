package com.edi.b.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.edi.a.models.VoyageDetails;

public interface VoyageRepository extends CrudRepository<VoyageDetails,Integer> {
    public VoyageDetails findById(int id);
    
    @Query("SELECT vd FROM VoyageDetails vd WHERE vd.voyageNumber = :voyageNumber")
    List<VoyageDetails> getJoinInformation(@Param("voyageNumber") String voyageNumber);
   
    @Query("SELECT vt FROM VoyageDetails vt WHERE vt.vesseltype = :vesseltype")
    List<VoyageDetails> getVoyages(@Param("vesseltype") String vesseltype);

}

//@Query("SELECT bl FROM BLDetails bl WHERE bl.blno = :blno")
//List<BLDetails> getJoinInformation(@Param("blno") String blno);
