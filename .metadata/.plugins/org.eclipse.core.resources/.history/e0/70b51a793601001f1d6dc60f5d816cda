package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.NhanVien_Dao;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class NhanVien_Impl extends UnicastRemoteObject implements NhanVien_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7181702291304918722L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;

	public NhanVien_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public NhanVien getNhanVien(String maNV) {
		return em.find(NhanVien.class, maNV);
	}

	@Override
	public boolean maNhanVienDaTonTai(String maNV) {
		return em.createQuery("Select nv FROM NhanVien nv WHERE nv.maNV = :maNV", NhanVien.class).setParameter("maNV", maNV).getSingleResult() != null;
               
    }
	

}
