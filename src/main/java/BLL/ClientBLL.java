package BLL;

import DAO.ClientDAO;
import Model.Client;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic layer for Client
 */
public class ClientBLL {

    private ClientDAO clientDAO;
    public ClientBLL()
    {
        clientDAO = new ClientDAO();
    }

    public List<Client> findAll() {
        List<Client> st = clientDAO.findAll();
        if (st == null) {
            throw new NoSuchElementException("The clients were not found!");
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
            clientDAO.insert(args);
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
            clientDAO.deleteFrom(args);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**

     * @param id - The client id
     * @param fieldNames - fields to modify
     * @param values - values
     */
    public void editClient(String id, List<String> fieldNames, List<String> values)
    {
        try
        {
            clientDAO.updateTable(id, fieldNames, values);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
