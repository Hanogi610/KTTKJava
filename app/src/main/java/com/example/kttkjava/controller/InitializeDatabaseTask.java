package com.example.kttkjava.controller;

import android.content.Context;
import android.os.AsyncTask;

import com.example.kttkjava.model.Account;
import com.example.kttkjava.model.Address;
import com.example.kttkjava.model.Collateral;
import com.example.kttkjava.model.CollateralInContract;
import com.example.kttkjava.model.Customer;
import com.example.kttkjava.model.Employee;
import com.example.kttkjava.model.InstallmentProduct;
import com.example.kttkjava.model.InstallmentProductContract;
import com.example.kttkjava.model.LendingPartner;
import com.example.kttkjava.model.Name;
import com.example.kttkjava.model.Payment;
import com.example.kttkjava.model.Person;
import com.example.kttkjava.model.Product;
import com.example.kttkjava.model.Supplier;

public class InitializeDatabaseTask extends AsyncTask<Void, Void, Void> {
    private Context context;

    public InitializeDatabaseTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        AppDatabase db = AppDatabase.getInstance(context);

        // DAOs
        AccountDao accountDao = db.accountDao();
        AddressDao addressDao = db.addressDao();
        CollateralDAO collateralDAO = db.collateralDAO();
        CollateralInContractDAO collateralInContractDAO = db.collateralInContractDAO();
        CustomerDAO customerDAO = db.customerDAO();
        EmployeeDao employeeDao = db.employeeDao();
        InstallmentProductDAO installmentProductDAO = db.installmentProductDAO();
        InstallmentProductContractDAO installmentProductContractDAO = db.installmentProductContractDAO();
        LendingPartnerDAO lendingPartnerDAO = db.lendingPartnerDAO();
        NameDao nameDao = db.nameDao();
        PaymentDAO paymentDAO = db.paymentDAO();
        PersonDao personDao = db.personDao();
        ProductDAO productDAO = db.productDAO();
        PurchaseInvoiceDAO purchaseInvoiceDAO = db.purchaseInvoiceDAO();
        PurchaseProductDAO purchaseProductDAO = db.purchaseProductDAO();
        ShipmentDAO shipmentDAO = db.shipmentDAO();
        SupplierDAO supplierDAO = db.supplierDAO();

        // Insert your data here in the correct order

        // Insert data into tables that do not have foreign keys
//        accountDao.insert(new Account( "employee1","123456"));
//        accountDao.insert(new Account( "employee2","123456"));
//        nameDao.insert(new Name("nguyen","viet","anh"));
//        nameDao.insert(new Name("le","viet","hung"));
//        nameDao.insert(new Name("vuong","viet","hai"));
//        addressDao.insert(new Address("123","abc","def","ghi","viet nam"));
//        addressDao.insert(new Address("456","abc","def","ghi","viet nam"));
//        addressDao.insert(new Address("789","abc","def","ghi","viet nam"));
//        productDAO.insert(new Product("product1","product1",1000));
//        productDAO.insert(new Product("product2","product2",2000));
//        supplierDAO.insert(new Supplier("supplier1","supplier1","Ha Dong","0123456","supplier1@gmail.com"));
//
//        // Insert data into tables that have foreign keys referencing the above tables
//        personDao.insert(new Person(1,"25/10/2000","male",1,1));
//        personDao.insert(new Person(2,"10/10/2002","male",2,2));
//        personDao.insert(new Person(3,"10/10/2000","male",3,3));
//        personDao.insert(new Person(4,"10/10/1999","male",3,3));
//        employeeDao.insert(new Employee(1,"25/10/2000","male",1,1,"employee",1000,1));
//        customerDAO.insert(new Customer(2,"10/10/2002","male",2,2,"teacher","PTIT",1000,500,2));
//        lendingPartnerDAO.insert(new LendingPartner(3,"10/10/2002","male",2,2,"Ha Dong bank"));
//        lendingPartnerDAO.insert(new LendingPartner(4,"10/10/1999","male",3,3,"Agribank"));

//        collateralDAO.insert(new Collateral("collateral1","collateral1","1000$","ACTIVE",2));
////        installmentProductContractDAO.insert(new InstallmentProductContract(1500,1300,10,"10/04/2024","Ha Dong","10/02/2024",200,"30","pending",2,3));
//        installmentProductDAO.insert(new InstallmentProduct(1,"jbox",1500,1,1));
//        collateralInContractDAO.insert(new CollateralInContract(1000,"good",1,1));
//        paymentDAO.insert(new Payment("10/10/2022","fist paid",2,3,1,200));
//        paymentDAO.insert(new Payment("10/11/2022","second paid",2,3,1,200));
//        for(int i = 13; i <= 13; i++) {
//            collateralInContractDAO.delete(i);
//            paymentDAO.deletePayment(i);
//        }


        //db.close();

        return null;
    }
}
