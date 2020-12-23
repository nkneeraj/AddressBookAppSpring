package com.cg.addressbookapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.addressbookapp.models.AddressBookData;

@Repository
public interface IAddressBookRespository extends JpaRepository<AddressBookData, Long> {

	List<AddressBookData> findBycity(String city);

}
