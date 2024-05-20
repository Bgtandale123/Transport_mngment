package com.edi.b.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edi.a.models.BLDetails;

@Repository
public interface BLDetailsRepository extends CrudRepository<BLDetails, Integer> {

	public BLDetails findById(int id);
	
	
	/*
	 * @Query(value = "SELECT * FROM BL_Information WHERE blno = :blno", nativeQuery
	 * = true) List<BLDetails> getJoinInformation(@Param("blno") String blno);
	 */
	
	//@Query("SELECT bl FROM BLDetails bl WHERE bl.blno = :blno")
   // List<BLDetails> getJoinInformation(@Param("blno") String blno);List<String> blno);

	
  //   @Query("SELECT c FROM BLDetails c WHERE c.blno IN :blno")
  // List<BLDetails> getJoinInformation(@Param("blno") String blno);
	
	@Query("SELECT b FROM BLDetails b WHERE b.blno IN :blnoList")
	List<BLDetails> getJoinInformation(@Param("blnoList") List<String> blnoList);

	@Query("SELECT bl FROM BLDetails bl WHERE bl.vesseltype = :vesseltype AND bl.voyage = :voyage AND bl.carrierInformation = :carrierInformation")
	List<BLDetails> getblbyvesselandvoyage(
	        @Param("vesseltype") String vesseltype,
	        @Param("voyage") String voyage,
	        @Param("carrierInformation") String carrierInformation);

}
