package model.Dao.impl;

import db.DB;
import db.DbException;
import model.Dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection con;

    public DepartmentDaoJDBC(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement  st = null;

        try{
            st = con.prepareStatement(
                    "INSERT INTO department " +
                            "(Name) " +
                            "VALUES " +
                            "(?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }


    public void update(Department obj) {

    }


    public void deleteById(Integer id) {

    }


    public Department findById(Integer id) {
        PreparedStatement  st = null;
        ResultSet rs = null;

        try{
            st = con.prepareStatement(
                    "SELECT * FROM department WHERE Id = ?");


            st.setInt(1, id);

            rs = st.executeQuery();
            if(rs.next()){
                Department obj = new Department();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("Name"));
                return obj;

            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);

        }

    }



    public List<Department> findAll() {
        return null;
    }
}
