
package com.edi.d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edi.a.models.LineDetails;
import com.edi.b.Repository.LineRepository;
import com.edi.c.service.LineService;

import java.util.List;
import java.util.Optional;

@Service
public class LineServiceimpl implements LineService {

	@Autowired
	private LineRepository lineRepository;

	@Override
	public LineDetails createLineDetails(LineDetails lineDetails) {
		LineDetails lined = lineRepository.save(lineDetails);
		return lined;
	}

	@Override
	public Optional<LineDetails> getLineDetailsById(int id) {
		Optional<LineDetails> lined1 = Optional.ofNullable(lineRepository.findById(id));
		return lined1;
	}

	@Override
	public List<LineDetails> getAllLineDetails(LineDetails lineDetails) {
		List<LineDetails> getall = (List<LineDetails>) lineRepository.findAll();
		return getall;
	}

	@Override
	public LineDetails updateLineDetails(LineDetails lineDetails) {
		LineDetails updateline = lineRepository.save(lineDetails);
		return updateline;
	}

	@Override
	public void deleteLineDetails(int id) {
		lineRepository.deleteById(id);

	}

	@Override
	public List<LineDetails> getJoinInformation(String code) {

		return lineRepository.getJoinInformation(code);
	}

}
