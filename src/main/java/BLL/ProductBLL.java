package BLL;

import DAO.ClientDAO;
import DAO.ProductDAO;
import Model.Client;
import Model.Product;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic layer for Produs
 */
public class ProductBLL {
    private ProductDAO productDAO;
    public ProductBLL()
    {
        productDAO = new ProductDAO();
    }

    public List<Product> findAll() {
        List<Product> st = productDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("The products were not found!");
        }
        return st;
    }
    /**
     * @param args
     */
    public void insertInto(List<String> args)
    {
        try
        {
            productDAO.insert(args);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * @param args
     */
    public void deleteFrom(String args)
    {
        try
        {
            productDAO.deleteFrom(args);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editProduct(String id, List<String> fieldNames, List<String> values)
    {
        try
        {
            productDAO.updateTable(id, fieldNames, values);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
