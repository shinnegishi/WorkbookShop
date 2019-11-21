package model;

import java.util.List;

import dao.UsrDAO;

public class UsrLogic{

	public List<Usr> findAUsr(Usr usr){
        UsrDAO daoUsr = new UsrDAO();
        List<Usr> usrList = daoUsr.findAUsr(usr);
        return usrList;
    }


    public String getNewID() {
        UsrDAO daoUsr = new UsrDAO();
        return daoUsr.getNewID();
    }


    public String insertUsr(Usr usr) {
        UsrDAO daoUsr = new UsrDAO();
        return daoUsr.insertUsr(usr);
    }

}
