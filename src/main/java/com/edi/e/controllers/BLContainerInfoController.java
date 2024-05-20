package com.edi.e.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edi.a.models.BLContainerInfo;

import com.edi.c.service.BLContainerInfoService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/edi")
public class BLContainerInfoController {
	
	@Autowired
	private BLContainerInfoService blContainerService;

	@PostMapping("/createBLContainerInfo")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public BLContainerInfo createBLContainerInfo(@RequestBody BLContainerInfo blContainer) {
		BLContainerInfo saveBL = blContainerService.createBLContainerInfo(blContainer);
		return saveBL;
	}

	@PutMapping("/updateBLContainerInfo")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public BLContainerInfo updateBLContainerInfo(@RequestBody BLContainerInfo blContainer) {
		BLContainerInfo updateBL = blContainerService.updateBLContainerInfo(blContainer);
		return updateBL;
	}

	@GetMapping("/getBLContainerInfoById/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Optional<BLContainerInfo> getBLContainerInfoById(@PathVariable("id") int id) {
		Optional<BLContainerInfo> getBL = blContainerService.getBLContainerInfoById(id);
		return getBL;
	}

	
	@GetMapping("/getAllBLContainerInfo")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<BLContainerInfo> getAllBLContainerInfo(BLContainerInfo blContainer) {
		List<BLContainerInfo> line2 = (List<BLContainerInfo>) blContainerService.getAllBLContainerInfo(blContainer);
		return line2;
	}

	@DeleteMapping("/deleteBLContainerInfo/{id}")
	public void deleteBLDetails(@PathVariable("id") Integer id) throws Exception {
		blContainerService.deleteBLContainerInfo(id);
	}
	
	@GetMapping("/combineapi")
	public List<Object> getDataFromModels()
	{
		return blContainerService.getDataFromModels();
	}

	
}
