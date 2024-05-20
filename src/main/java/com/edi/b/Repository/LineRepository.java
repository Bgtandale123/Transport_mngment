package com.edi.b.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edi.a.models.BLDetails;
import com.edi.a.models.LineDetails;

@Repository
public interface LineRepository extends CrudRepository<LineDetails,Integer> {

    public LineDetails findById(int id);
        
    @Query("SELECT ld FROM LineDetails ld WHERE ld.code = :code")
    List<LineDetails> getJoinInformation(@Param("code") String code);


	// @Query(value = "SELECT * FROM Line_Details WHERE code = :code", nativeQuery =
	// true)
	// List<LineDetails> getJoinInformation(@Param("code") String code);

	/*
	 * //@Query("SELECT bl FROM BLDetails bl WHERE bl.blno = :blno") List<BLDetails>
	 * getJoinInformation(@Param("blno") String blno);
	 */
    
    

}
