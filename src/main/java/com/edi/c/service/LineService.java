
  package com.edi.c.service;
  
  
  
  
  
  import java.util.List; import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.edi.a.models.LineDetails;
import com.edi.a.models.Vessel;
  
  public interface LineService {
  
  public LineDetails createLineDetails(LineDetails lineDetails);
  
  public LineDetails updateLineDetails(LineDetails lineDetails);
  
  public Optional<LineDetails> getLineDetailsById(int id);
  
  public List<LineDetails> getAllLineDetails(LineDetails lineDetails);
  
  public void deleteLineDetails(int id);
  
  List<LineDetails> getJoinInformation(@Param("code") String code);

  
  }
 