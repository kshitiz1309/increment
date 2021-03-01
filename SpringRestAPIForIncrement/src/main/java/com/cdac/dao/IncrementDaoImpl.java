package com.cdac.dao;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdac.entity.IncrementEntity;

	
	@Component
	public class IncrementDaoImpl implements IncrementDao {

		@Autowired
		SessionFactory sessionFaactory;

		@Autowired
		IncrementDao incrementDao;

		 
		@Override
		public int doIncrementWithLock() {

			System.out.println(" saving increment ");
			Session session = sessionFaactory.getCurrentSession();
			int data = 0;
			try {
				
				session.beginTransaction();
				 
				IncrementEntity idg = (IncrementEntity) session.get(IncrementEntity.class, 1,LockOptions.UPGRADE);
				
				idg.setNumber(idg.getNumber() + 1);
				idg = (IncrementEntity) session.merge(idg);
				data = idg.getNumber();
				session.getTransaction().commit();
			} catch (org.hibernate.StaleObjectStateException e) {
				 session.getTransaction().rollback();
				throw e;
			}
			catch (Exception e) {
				throw e;
			} 

			return data;

		}
}
