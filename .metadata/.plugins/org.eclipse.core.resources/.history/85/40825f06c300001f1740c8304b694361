package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.ChiTietDonDat_Dao;
import dao.DonDat_Dao;
import entity.DonDat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DonDat_Impl extends UnicastRemoteObject implements DonDat_Dao {
	
	private static final long serialVersionUID = 9223372036854723658L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public DonDat_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public boolean addDonDat(DonDat donDat) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(donDat);
			ChiTietDonDat_Dao ctddDao = new ChiTietDonDat_Impl();
			ctddDao.addChiTietDonDat(donDat);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean checkThuoc(String maThuoc) {
		return em.createNamedQuery("DonDat.checkThuoc", DonDat.class).setParameter("maThuoc", maThuoc).executeUpdate() > 0;
	}
}
