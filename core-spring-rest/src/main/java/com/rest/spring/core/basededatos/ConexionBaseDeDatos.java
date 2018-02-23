package com.rest.spring.core.basededatos;

import com.rest.spring.core.Restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ConexionBaseDeDatos {

    //Metemos en variables los parametros que usaremos para conectarnos a la DB , como la IP , user , password .
    
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    private static final String THIN_URL = "jdbc:oracle:thin:@35.205.41.45:1521:XE";

    private static final String USER = "usuari";

    private static final String PASSWORD = "usuari";



        public ArrayList readRestaurant (String cercar){

            ArrayList rst = new ArrayList();

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");

                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

                Statement stmt = con.createStatement();
                ResultSet rs;


                if (cercar == null || cercar.equals("")) {

             //Cuando cercar = null o equivale a nada , nos busca en la base de datos sin filtro 
                    rs = stmt.executeQuery("SELECT * FROM (SELECT RE.RES_NOM, RE.RES_ADRECA, RE.RES_WEB, RE.RES_TELEFON, RE.RES_URL_IMG, RR.TRS_DESCRIPCIO, RE.RES_CODI FROM " +
                            "RESTAURANTS RE, TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI ORDER BY RES_MITJANA DESC)where ROWNUM <= 5");


                } else {

                    //En esta consulta se hace un select con el parametro que nosotros introducimos
                    rs = stmt.executeQuery("SELECT * FROM (SELECT RE.RES_NOM, RE.RES_ADRECA, RE.RES_WEB, RE.RES_TELEFON, RE.RES_URL_IMG, RR.TRS_DESCRIPCIO, RE.RES_CODI FROM " +
                            "RESTAURANTS RE, TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI AND RE.RES_NOM LIKE '%" + cercar + "%' ORDER BY RES_MITJANA DESC)where ROWNUM <= 5");

                }


                while (rs.next()) {

                    Restaurant rstt = new Restaurant();

                    rstt.setNombre(rs.getString("RES_NOM"));
                    rstt.setDireccion(rs.getString("RES_ADRECA"));
                    rstt.setWeb(rs.getString("RES_WEB"));
                    rstt.setTelefono(rs.getString("RES_TELEFON"));
                    rstt.setTipo(rs.getString("TRS_DESCRIPCIO"));
                    rstt.setUrl_imagen(rs.getString("RES_URL_IMG"));
                    rstt.setID(rs.getString("RES_CODI"));

                    rst.add(rstt);

                }

                stmt.close();
                con.close();

            } catch (Exception e) {

                System.out.println(e.toString());

            }

            return rst;

        }


        public Restaurant readRestaurant2 (String idinformacio){

            Restaurant rstt = null;

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");

                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

                Statement stmt = con.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT RE.RES_NOM, RE.RES_ADRECA, RE.RES_WEB, RE.RES_TELEFON, RE.RES_URL_IMG, RR.TRS_DESCRIPCIO, RE.RES_CODI FROM RESTAURANTS RE, TRESTAURANTS RR WHERE " + idinformacio + "=RE.RES_CODI AND RE.RES_TRS_CODI = RR.TRS_CODI");

                if (rs.next()) {

                    rstt = new Restaurant();

                    rstt.setNombre(rs.getString("RES_NOM"));
                    rstt.setDireccion(rs.getString("RES_ADRECA"));
                    rstt.setWeb(rs.getString("RES_WEB"));
                    rstt.setTelefono(rs.getString("RES_TELEFON"));
                    rstt.setTipo(rs.getString("TRS_DESCRIPCIO"));
                    rstt.setUrl_imagen(rs.getString("RES_URL_IMG"));
                    rstt.setID(rs.getString("RES_CODI"));


                    
                            //Con esta consulta , se obtienen los comentarios

                    Statement stmtt = con.createStatement();
                    ResultSet rsst;

                    rsst = stmtt.executeQuery("SELECT OP.OPI_OBSERVACIO, US.USU_NOM FROM RESTAURANTS RS, OPINIONS OP, USUARIS US WHERE  RS.RES_CODI = OP.OPI_RES_CODI AND " + idinformacio + "= RS.RES_CODI AND OP.OPI_USU_CODI = US.USU_CODI");

                    while (rsst.next()) {

                        rstt.getOpinions().add(rsst.getString("USU_NOM"));
                        rstt.getOpinions().add(rsst.getString("OPI_OBSERVACIO"));

                    }

                    stmtt.close();

                }

                stmt.close();
                con.close();

            } catch (Exception b) {

                System.out.println(b.toString());

            }

            return rstt;
        }

    }
