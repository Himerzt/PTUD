package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.TaiKhoan_Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TaiKhoan_Impl extends UnicastRemoteObject implements TaiKhoan_Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8114624633946054475L;
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyThuoc MSSQL";
	private EntityManager em;
	
	public TaiKhoan_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

}
