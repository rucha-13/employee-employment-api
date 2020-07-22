/**
 * 
 */
package com.org.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.app.model.Office;

/**
 * @author ruchs
 *
 */
@Repository
public interface OfficeRepository extends CrudRepository<Office, Integer> {

}
