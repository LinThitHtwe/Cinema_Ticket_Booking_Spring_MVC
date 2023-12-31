package com.cinemamanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cinemamanage.dto.AccountRequestDTO;
import com.cinemamanage.dto.AccountResponseDTO;


@Service("accountDAO")
public class AccountDAO {
	public static Connection con = null;
	static {
		con=MyConncection.getConnection();
	}
//--------------crud---------------------------
	
	public int searchUserIdbyEmail(String email) {
	    int userId=0;
	    String str = "SELECT * FROM ACCOUNT WHERE account_email=?";
	    try {
	      PreparedStatement ps = con.prepareStatement(str);
	      ps.setString(1,email);
	      ResultSet res = ps.executeQuery();
	      
	      while(res.next()) {
	        userId=res.getInt(1);
	      }
	    } catch (SQLException e) {
	      System.out.print(e);
	    }
	    return userId;
	  }
	public int insertData(AccountRequestDTO dto) {
		int result=0;
		String sql="insert into account(account_name,account_email,account_password,account_role,account_status) values(?,?,?,?,?)";

		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAccountName());
			ps.setString(2, dto.getAccountEmail());
			ps.setString(3, dto.getAccountPassword());
			ps.setString(4,dto.getAccountRole());
			ps.setNString(5, dto.getAccountStatus());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DataBase Error "+e); 
		}
		 return result;
	}
	
	public int updateData(AccountRequestDTO dto) {
		String sql="update account set account_name=?,account_email=?,account_password=?,account_role=? where id=?";
		int result = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setNString(1, dto.getAccountName());
			ps.setNString(2, dto.getAccountEmail());
			ps.setNString(3, dto.getAccountPassword());
			ps.setNString(4, dto.getAccountRole());
			ps.setInt(5, dto.getAccountID());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DataBase Error "+e); 
		}return result;
		 
	}
	
	public int deleteData(AccountRequestDTO dto) {
		int result = 0;
		String sql="delete from account where id=?";

		
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, dto.getAccountID());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DataBase Error "+e); 
		}return result;
		 
	}
	
	public AccountResponseDTO selectOne(AccountRequestDTO dto) {
		AccountResponseDTO res = new AccountResponseDTO();
		String sql="select * from account where id=?";

		
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, dto.getAccountID());
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				res.setAccountID(rs.getInt("id"));
				res.setAccountName(rs.getString("account_name"));
				res.setAccountEmail(rs.getString("account_email"));
				res.setAccountPassword(rs.getString("account_password"));
				res.setAccountRole(rs.getString("account_role"));
			}
			
		} catch (SQLException e) {
			System.out.println("DataBase Error "+e); 
		}
		return res;
	}
	
	public ArrayList<AccountResponseDTO> selectAll() {
		ArrayList<AccountResponseDTO> list = new ArrayList();
		String sql= "select * from account";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				AccountResponseDTO res = new AccountResponseDTO();
				res.setAccountID(rs.getInt("id"));
				res.setAccountName(rs.getString("account_name"));
				res.setAccountEmail(rs.getString("account_email"));
				res.setAccountPassword(rs.getString("account_password"));
				res.setAccountRole(rs.getString("account_role"));
				list.add(res);  
			}
			
		} catch (SQLException e) {
			System.out.println("DataBase Error "+e); 
		}
		return list;
	}
	
	public ArrayList<AccountResponseDTO> selectAllUsers() {
		ArrayList<AccountResponseDTO> list = new ArrayList();
		String sql= "SELECT * FROM account WHERE account_role != 'admin';"  ;
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				AccountResponseDTO res = new AccountResponseDTO();
				res.setAccountID(rs.getInt("id"));
				res.setAccountName(rs.getString("account_name"));
				res.setAccountEmail(rs.getString("account_email"));
				res.setAccountPassword(rs.getString("account_password"));
				res.setAccountRole(rs.getString("account_role"));
				list.add(res);  
			}
			
		} catch (SQLException e) {
			System.out.println("DataBase Error "+e); 
		}
		return list;
	}
	
	public ArrayList<AccountResponseDTO> selectAllAdmins() {
		ArrayList<AccountResponseDTO> list = new ArrayList();
		String sql= "SELECT * FROM account WHERE account_role != 'user';"  ;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				AccountResponseDTO res = new AccountResponseDTO();
				res.setAccountID(rs.getInt("id"));
				res.setAccountName(rs.getString("account_name"));
				res.setAccountEmail(rs.getString("account_email"));
				res.setAccountPassword(rs.getString("account_password"));
				res.setAccountRole(rs.getString("account_role"));
				list.add(res);  
			}
			
		} catch (SQLException e) {
			System.out.println("DataBase Error "+e); 
		}
		return list;
	}


//-----Ban----------------------------------	
	
	public int addBanlist(AccountRequestDTO dto) {
	    int i = 0;
	    String str = "update account set account_status=? where id=?";
	    
	    try {
	      PreparedStatement ps = con.prepareStatement(str);
	      ps.setString(1,dto.getAccountStatus());
	      ps.setInt(2,dto.getAccountID());
	       i = ps.executeUpdate();
	    } catch (SQLException e) {
	      System.out.print(e);
	    }
	    return i;
	  }
	  
	  public int removeBanlist(AccountRequestDTO dto) {
	    int i = 0;
	    String str = "update account set account_status=? where id=?";
	    try {
	      PreparedStatement ps = con.prepareStatement(str);
	      ps.setString(1,dto.getAccountStatus());
	      ps.setInt(2,dto.getAccountID());
	       i = ps.executeUpdate();
	    } catch (SQLException e) {
	      System.out.print(e);
	    }
	    return i;
	  }

	  
	  public ArrayList<AccountResponseDTO> selectAllNomalUsers() {
	    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
	    String str = "select * from account where account_status in ('unban')";
	    try {
	      PreparedStatement ps = con.prepareStatement(str);
	      ResultSet rs = ps.executeQuery();
	      while(rs.next()) {
	        AccountResponseDTO dto = new AccountResponseDTO();
	        dto.setAccountID(rs.getInt("id"));
	        dto.setAccountName(rs.getString("account_name"));
	        dto.setAccountEmail(rs.getString("account_email"));
	        dto.setAccountPassword(rs.getString("account_password"));
	        dto.setAccountRole(rs.getString("account_role"));
	        dto.setAccountStatus(rs.getString("account_status"));
	        
	        datalist.add(dto);
	      }
	    } catch (SQLException e) {
	       System.out.print(e);
	    }
	    return datalist;
	  }
	  
	  public ArrayList<AccountResponseDTO> selectAllBannedUsers() {
	    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
	    String str = "select * from account where account_status in ('banned')";
	    try {
	      PreparedStatement ps = con.prepareStatement(str);
	      ResultSet rs = ps.executeQuery();
	      while(rs.next()) {
	        AccountResponseDTO dto = new AccountResponseDTO();
	        dto.setAccountID(rs.getInt("id"));
	        dto.setAccountName(rs.getString("account_name"));
	        dto.setAccountEmail(rs.getString("account_email"));
	        dto.setAccountPassword(rs.getString("account_password"));
	        dto.setAccountRole(rs.getString("account_role"));
	        dto.setAccountStatus(rs.getString("account_status"));
	        
	        datalist.add(dto);
	      }
	    } catch (SQLException e) {
	       System.out.print(e);
	    }
	    return datalist;
	  }
	  
		//------------------adminSearch-------------
	  
	public ArrayList<AccountResponseDTO> searchByAdminId(AccountRequestDTO dto) {
			ArrayList<AccountResponseDTO> list = new ArrayList();
			String sql= "select * from account where id=? and account_role!='user';"  ;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, dto.getAccountID());
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					AccountResponseDTO res = new AccountResponseDTO();
					res.setAccountID(rs.getInt("id"));
					res.setAccountName(rs.getString("account_name"));
					res.setAccountEmail(rs.getString("account_email"));
					res.setAccountPassword(rs.getString("account_password"));
					res.setAccountRole(rs.getString("account_role"));
					list.add(res);  
				}
				
			} catch (SQLException e) {
				System.out.println("DataBase Error "+e); 
			}
			return list;
		}
	
	  public ArrayList<AccountResponseDTO> selectByAdminName(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE account_name LIKE CONCAT('%',?, '%') And account_role!='user';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, dto.getAccountName());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
	  
	  public ArrayList<AccountResponseDTO> selectByAdminEmail(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE account_email LIKE CONCAT('%',?, '%') And account_role!='user';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, dto.getAccountEmail());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
	  
	  public ArrayList<AccountResponseDTO> selectByAdminAll(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE id=? and account_name LIKE CONCAT('%',?, '%') and account_email LIKE CONCAT('%',?, '%') And account_role!='user';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, dto.getAccountID());
		        ps.setString(2, dto.getAccountName());
		        ps.setString(3, dto.getAccountEmail());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}

//-----------------------userSearch----------------------------------
		public ArrayList<AccountResponseDTO> searchByUnBanUserId(AccountRequestDTO dto) {
			ArrayList<AccountResponseDTO> list = new ArrayList();
			String sql= "select * from account where id=? and account_role!='admin' and account_status!='banned';"  ;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, dto.getAccountID());
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					AccountResponseDTO res = new AccountResponseDTO();
					res.setAccountID(rs.getInt("id"));
					res.setAccountName(rs.getString("account_name"));
					res.setAccountEmail(rs.getString("account_email"));
					res.setAccountPassword(rs.getString("account_password"));
					res.setAccountRole(rs.getString("account_role"));
					res.setAccountStatus(rs.getString("account_status"));
					list.add(res);  
				}
				
			} catch (SQLException e) {
				System.out.println("DataBase Error "+e); 
			}
			return list;
		}
	
	  public ArrayList<AccountResponseDTO> selectByUnbanUserName(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE account_name LIKE CONCAT('%',?, '%') And account_role!='admin' and account_status!='banned';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, dto.getAccountName());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            res.setAccountStatus(rs.getString("account_status"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
	  
	  public ArrayList<AccountResponseDTO> selectByUnbanUserEmail(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE account_email LIKE CONCAT('%',?, '%') And account_role!='admin' and account_status!='banned';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, dto.getAccountEmail());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            res.setAccountStatus(rs.getString("account_status"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
	  
	  public ArrayList<AccountResponseDTO> selectByUnbanUserAll(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE id=? and account_name LIKE CONCAT('%',?, '%') and account_email LIKE CONCAT('%',?, '%') And account_role!='admin' and account_status!='banned';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, dto.getAccountID());
		        ps.setString(2, dto.getAccountName());
		        ps.setString(3, dto.getAccountEmail());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            res.setAccountStatus(rs.getString("account_status"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
	  
	  //-------------------------- Search Ban User------------------------------------
	  
		public ArrayList<AccountResponseDTO> searchByBanUserId(AccountRequestDTO dto) {
			ArrayList<AccountResponseDTO> list = new ArrayList();
			String sql= "select * from account where id=? and account_role!='admin' and account_status!='unban';"  ;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, dto.getAccountID());
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					AccountResponseDTO res = new AccountResponseDTO();
					res.setAccountID(rs.getInt("id"));
					res.setAccountName(rs.getString("account_name"));
					res.setAccountEmail(rs.getString("account_email"));
					res.setAccountPassword(rs.getString("account_password"));
					res.setAccountRole(rs.getString("account_role"));
					res.setAccountStatus(rs.getString("account_status"));
					list.add(res);  
				}
				
			} catch (SQLException e) {
				System.out.println("DataBase Error "+e); 
			}
			return list;
		}
	
	  public ArrayList<AccountResponseDTO> selectByBanUserName(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE account_name LIKE CONCAT('%',?, '%') And account_role!='admin' and account_status!='unban';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, dto.getAccountName());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            res.setAccountStatus(rs.getString("account_status"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
	  
	  public ArrayList<AccountResponseDTO> selectByBanUserEmail(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE account_email LIKE CONCAT('%',?, '%') And account_role!='admin' and account_status!='unban';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, dto.getAccountEmail());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); // create a new object for each row
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            res.setAccountStatus(rs.getString("account_status"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
	  
	  public ArrayList<AccountResponseDTO> selectByBanUserAll(AccountRequestDTO dto) {
		    ArrayList<AccountResponseDTO> datalist = new ArrayList<AccountResponseDTO>();
		    String sql="SELECT * FROM account WHERE id=? and account_name LIKE CONCAT('%',?, '%') and account_email LIKE CONCAT('%',?, '%') And account_role!='admin' and account_status!='unban';";	
		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, dto.getAccountID());
		        ps.setString(2, dto.getAccountName());
		        ps.setString(3, dto.getAccountEmail());
		        ResultSet rs= ps.executeQuery();
		        while(rs.next()) {
		            AccountResponseDTO res = new AccountResponseDTO(); 
		            res.setAccountID(rs.getInt("id"));
		            res.setAccountName(rs.getString("account_name"));
		            res.setAccountEmail(rs.getString("account_email"));
		            res.setAccountPassword(rs.getString("account_password"));
		            res.setAccountRole(rs.getString("account_role"));
		            res.setAccountStatus(rs.getString("account_status"));
		            datalist.add(res);
		        }
		    } catch (SQLException e) {
		        System.out.println("DataBase Error "+e); 
		    }
		    return datalist;
		}
}
