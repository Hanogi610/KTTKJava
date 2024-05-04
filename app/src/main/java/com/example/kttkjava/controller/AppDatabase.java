package com.example.kttkjava.controller;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

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
import com.example.kttkjava.model.PurchaseInvoice;
import com.example.kttkjava.model.PurchaseProduct;
import com.example.kttkjava.model.Shipment;
import com.example.kttkjava.model.Supplier;


@Database(entities = {Account.class,Address.class, Collateral.class, CollateralInContract.class, Customer.class, Employee.class, InstallmentProduct.class,
        InstallmentProductContract.class, LendingPartner.class,Name.class, Payment.class,Person.class, Product.class, PurchaseInvoice.class,
        PurchaseProduct.class, Shipment.class, Supplier.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase instance;
    public abstract CollateralDAO collateralDAO();
    public abstract CollateralInContractDAO collateralInContractDAO();
    public abstract CustomerDAO customerDAO();
    public abstract InstallmentProductDAO installmentProductDAO();
    public abstract InstallmentProductContractDAO installmentProductContractDAO();
    public abstract LendingPartnerDAO lendingPartnerDAO();
    public abstract PaymentDAO paymentDAO();
    public abstract PersonDao personDao();
    public abstract EmployeeDao employeeDao();
    public abstract ProductDAO productDAO();
    public abstract PurchaseInvoiceDAO purchaseInvoiceDAO();
    public abstract PurchaseProductDAO purchaseProductDAO();
    public abstract ShipmentDAO shipmentDAO();
    public abstract SupplierDAO supplierDAO();
    public abstract NameDao nameDao();
    public abstract AddressDao addressDao();
    public abstract AccountDao accountDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "BNPL_database")
                    .build();
        }
        return instance;
    }
}
