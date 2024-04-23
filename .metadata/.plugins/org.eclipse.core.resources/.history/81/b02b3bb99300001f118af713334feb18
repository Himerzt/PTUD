package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.KhachHang_Dao;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KhachHang_Impl extends UnicastRemoteObject implements KhachHang_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -925182845073983525L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	List<KhachHang> ds = null;
	
	public KhachHang_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
		ds = new ArrayList<KhachHang>();
	}

	@Override
	public void addKhachHang(KhachHang kh) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(kh);
			ds.add(kh);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public KhachHang findById(String maKH) {
		return em.find(KhachHang.class, maKH);
	}

	@Override
	public KhachHang findBySDT(String sdtKH) {
		return em.createQuery("Select kh FROM KhachHang kh WHERE kh.soDienThoai = :soDienThoai", KhachHang.class)
				.setParameter("soDienThoai", sdtKH)
				.getSingleResult();
	}

	@Override
	public List<KhachHang> getDSKH() {
		return ds;
	}

}
