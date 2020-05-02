package pe.isil;

import pe.isil.dao.AccountDAO;

public class AccountMain {

    public static void main(String[] args) {

        boolean transfer = AccountDAO.transfer(2, 1, 500.0);
        System.out.println("transferSuccess = " + transfer);

    }

}
