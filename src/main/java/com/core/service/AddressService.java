package com.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.model.Address;
import com.core.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository repo;
	
	public Address createAddress(Address ad) {
		ad.setAddressId(null);
		Address newa = new Address();
		newa.setAddress(ad.getAddress());
		newa.setState(ad.getState());
		newa.setCity(ad.getCity());
		newa.setZipCode(ad.getZipCode());
		newa.setLocation(ad.getLocation());
		Address created = repo.save(newa);
		return created;
	}
	
	//Read
	
	public List<Address> getAllAddresss() {
		return repo.findAll();
	}	
	public Optional<Address> getAddressById(int id) {
		return repo.findById(id);
	}
	
	//Update
	public Address updateAddress(Address ad) {
		if(repo.existsById(ad.getAddressId())) {
			Address update = repo.save(ad);
			return update;
		}
		return null;
	}
	
	//Delete
	
	public boolean deleteAddressById(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
}
