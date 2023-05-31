package BLL;

import DAO.ClientDAO;
import DAO.ComandaDAO;
import Model.Client;
import Model.Comanda;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic layer for Comanda
 */
public class ComandaBLL {
    private ComandaDAO comandaDAO;

    public ComandaBLL()
    {
        comandaDAO = new ComandaDAO();
    }
    /**
     * @param args
     */
    public void createOrder(List<String> args) {
            try
            {
                comandaDAO.insert(args);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    public List<Comanda> findAll() {
        List<Comanda> st = comandaDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("The comands were not found!");
        }
        return st;
    }

    /**
     * @param id - id of the ordered product
     * @param stocNou - new stock
     */
    public void scadeStoc(int id, int stocNou)
    {
        ProductBLL produs = new ProductBLL();
        List<String> fieldNames = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        fieldNames.add("stock");
        values.add(String.valueOf(stocNou));
        produs.editProduct(String.valueOf(id), fieldNames, values);
    }
}
