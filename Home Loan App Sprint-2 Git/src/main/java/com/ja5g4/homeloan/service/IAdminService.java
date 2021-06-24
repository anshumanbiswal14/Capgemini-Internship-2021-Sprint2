package com.ja5g4.homeloan.service;
import java.util.List;  
import com.ja5g4.homeloan.entities.Admin;

/* Admin Service 
 * AdminService implements IAdminService 
 * Admin addAdmin(Admin Admin) to add new user as admin.
 * Admin getAllAdmin to get the list of all admins.
 * isValidAdmin to check whether admin exist in the database or not.
 
 * Author : Blesy Helen
 */

public interface IAdminService {

	public Admin addAdmin(Admin admin); 
	public Admin getAdmin(int userId);
	public List<Admin> getAllAdmin();
	public Boolean isValidAdmin(String username, String password);
	}

//By Blesy Helen