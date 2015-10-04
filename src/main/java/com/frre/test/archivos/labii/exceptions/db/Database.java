package com.frre.test.archivos.labii.exceptions.db;

import com.frre.test.archivos.labii.exceptions.exceptions.ZeroComprasException;
import com.frre.test.archivos.labii.exceptions.model.Compra;

import java.util.List;

/**
 * Created by jvargas on 10/2/15.
 */
public abstract class Database {

    public abstract void open();

    public abstract void close();

    public abstract List<Compra> getRecordsForUser(int user) throws ZeroComprasException;

    public abstract double getAveragePerUser(int user);
}
