package com.example.kttkjava.repository;

import android.content.Context;

import com.example.kttkjava.controller.AppDatabase;
import com.example.kttkjava.controller.SupplierDAO;
import com.example.kttkjava.model.Supplier;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplierRepository {
    private SupplierDAO supplierDAO;
    private ExecutorService executorService;
    private Supplier[] list;

    public SupplierRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        supplierDAO = db.supplierDAO();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertSupplier(Supplier supplier) {
        executorService.execute(() -> supplierDAO.insert(supplier));
    }

    public void getAllSupplier() {
        executorService.execute(() -> list = supplierDAO.getAllSuppliers());
    }
}
