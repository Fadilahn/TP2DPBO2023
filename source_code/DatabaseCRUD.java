/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foody;

import java.sql.ResultSet;
//import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class DatabaseCRUD {
    private final dbConnection db;
    private String table;
    
    public DatabaseCRUD(dbConnection db) {
        this.db = db;
    }

    public DatabaseCRUD(dbConnection db, String table) {
        this.db = db;
        this.table = table;
    }

    public void setTable(String table){
        this.table = table;
    }
    
//    private String[] getColumns(String table) {
//        try {
//            String query = "SELECT COLUMN_NAME FROM information_schema.columns WHERE TABLE_NAME = '" + table + "'";
//            ResultSet rs = db.selectQuery(query);
//            ArrayList<String> columnsList = new ArrayList<>();
//            while (rs.next()) {
//                columnsList.add(rs.getString("COLUMN_NAME"));
//            }
//            return columnsList.toArray(new String[columnsList.size()]);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }

    public String getTable(){
        return table;
    }

    public void create(String[] values){
        create(this.table, null, values);
    }

    public void create(String[] columns, String[] values){
        create(this.table, columns, values);
    }

    public void create(String table, String[] values){
        create(table, null, values);
    }

    public void create(String table, String[] columns, String[] values){
        if(table != null){ 
            String query = "INSERT INTO " + table;
            if (columns != null && columns.length > 0) {
                query += " (";
                for (String column : columns) {
                    query += column + ", ";
                }
                query = query.substring(0, query.length() - 2) + ")";
            }
            query += " VALUES (";
            for (String value : values) {
                query += "'" + value + "', ";
            }
            query = query.substring(0, query.length() - 2) + ")";
            db.updateQuery(query);
        }
    } 
    
    public ResultSet read(){
        return read(this.table, null, null);
    }

    public ResultSet read(String whereClause) {
        return read(this.table, null, whereClause);
    }

    public ResultSet read(String[] columns, String whereClause) {
        return read(this.table, columns, whereClause);
    }

    public ResultSet read(String table, String whereClause) {
        return read(table, null, whereClause);
    }

    public ResultSet read(String table, String[] columns, String whereClause) {
        String query = "SELECT ";
        if (columns == null || columns.length == 0) {
            query += "*";
        } else {
            for (String column : columns) {
                query += column + ", ";
            }
            query = query.substring(0, query.length() - 2);
        }
        query += " FROM " + table;
        if (whereClause != null && !whereClause.isEmpty()) {
            query += " WHERE " + whereClause;
        }
        return db.selectQuery(query);
    }
    
    public void update(String[] columns, String[] values, String whereClause) {
        update(this.table, columns, values, whereClause);
    }

    public void update(String table, String[] columns, String[] values, String whereClause) {
        String query = "UPDATE " + table + " SET ";
        for (int i = 0; i < columns.length; i++) {
            query += columns[i] + "='" + values[i] + "', ";
        }
        query = query.substring(0, query.length() - 2) + " WHERE " + whereClause;
        
        db.updateQuery(query);
    }

    public void delete(String whereClause) {
        delete(this.table, whereClause);
    }

    public void delete(String table, String whereClause) {
        String query = "DELETE FROM " + table + " WHERE " + whereClause;
        db.updateQuery(query);
    }

}
