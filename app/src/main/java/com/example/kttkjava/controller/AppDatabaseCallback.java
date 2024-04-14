package com.example.kttkjava.controller;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
import com.example.kttkjava.model.ProductForSale;
import com.example.kttkjava.model.Supplier;

import java.util.concurrent.Executors;

public class AppDatabaseCallback extends RoomDatabase.Callback {

    private Context context;
    public AppDatabaseCallback(Context context) {
        this.context = context;
    }
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // Get instance of your database
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
                ProductForSaleDAO productForSaleDAO = db.productForSaleDAO();
                PurchaseInvoiceDAO purchaseInvoiceDAO = db.purchaseInvoiceDAO();
                PurchaseProductDAO purchaseProductDAO = db.purchaseProductDAO();
                ShipmentDAO shipmentDAO = db.shipmentDAO();
                SupplierDAO supplierDAO = db.supplierDAO();

                // Insert your data here in the correct order

                // Insert data into tables that do not have foreign keys
                accountDao.insert(new Account( "employee1","123456"));
                accountDao.insert(new Account( "employee2","123456"));
                nameDao.insert(new Name("nguyen","viet","anh"));
                nameDao.insert(new Name("nguyen","viet","hung"));
                nameDao.insert(new Name("nguyen","viet","hai"));
                addressDao.insert(new Address("123","abc","def","ghi","viet nam"));
                addressDao.insert(new Address("456","abc","def","ghi","viet nam"));
                addressDao.insert(new Address("789","abc","def","ghi","viet nam"));
                productDAO.insert(new Product("product1","product1",1000));
                productDAO.insert(new Product("product2","product2",2000));
                supplierDAO.insert(new Supplier("supplier1","supplier1","Ha Dong","0123456","supplier1@gmail.com"));

                // Insert data into tables that have foreign keys referencing the above tables
                personDao.insert(new Person(1,"10/10/2002","male",1,1));
                personDao.insert(new Person(2,"10/10/2002","male",2,2));
                personDao.insert(new Person(3,"10/10/2002","male",3,3));
                employeeDao.insert(new Employee(1,"10/10/2002","male",1,1,"employee",1000,1));
                customerDAO.insert(new Customer(2,"10/10/2002","male",2,2,"teacher","Ha Dong elementary school",1000,500,2));
                lendingPartnerDAO.insert(new LendingPartner(3,"10/10/2002","male",3,3,"Ha Dong bank"));
                productForSaleDAO.insert(new ProductForSale("product1",1500,"product1","warehouse1",100,1));
                installmentProductDAO.insert(new InstallmentProduct(1,"jbox",1500,1,1));
                collateralDAO.insert(new Collateral("collateral1","collateral1","1000$","good",2));
                collateralInContractDAO.insert(new CollateralInContract(1000,"good",1,1));
                installmentProductContractDAO.insert(new InstallmentProductContract(1500,1300,10,"10/04/2024","Ha Dong","10/02/2024",200,"30","pending",2,3));
                paymentDAO.insert(new Payment("10/10/2022","fist paid",2,3,1));

                db.close();
            }
        });
    }
}