package com.edi.b.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edi.a.models.Vessel;

@Repository
public interface VesselRepository extends CrudRepository<Vessel,Integer> {
    public Vessel findById(int id);
    
   // @Query(value = "SELECT * FROM vessel_information WHERE vessel_name = :vesselName", nativeQuery = true)
   // List<Vessel> getJoinInformation(@Param("vesselName") String vesselName);
    @Query("SELECT vn FROM Vessel vn WHERE vn.vesselId = :vesselId")
    List<Vessel> getJoinInformation(@Param("vesselId") String vesselId);

}
