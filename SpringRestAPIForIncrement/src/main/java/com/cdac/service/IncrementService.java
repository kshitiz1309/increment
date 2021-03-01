package com.cdac.service;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdac.dao.IncrementDao;

@Service
public class IncrementService {

	@Autowired
	IncrementDao incrementDao;

		
	public int increaseNumberForID() {		
			int result = 0;
			try {
			result=	incrementDao.doIncrementWithLock();
			System.out.println("data saved....");
			}catch (StaleObjectStateException e) {
				System.out.println("************** race condition occured, try again for perform this. *******************");	
			}catch (Exception e) {
				throw e;
			}
			return result;		
		}
}
