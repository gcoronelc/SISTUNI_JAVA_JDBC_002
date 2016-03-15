package Proyecto.dao.impl;

import Proyecto.dao.espec.DaoUsuarioEspec;
import Proyecto.db.AccesoDB;
import Proyecto.domain.Usuario;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Josué Moreno
 */
public class DaoUsuarioImpl implements DaoUsuarioEspec {

    @Override
    public Usuario validar(String U, String C) {
        Usuario usuario = null;
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT * "
                    + "FROM Usuario "
                    + "WHERE USUARIO = ? "
                    + "and CONTRASEÑA = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, U);
            pstm.setString(2, C);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                usuario = getBean(rs);
            }
            rs.close();
            pstm.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            String Mensaje = "Se ha Producido un Error, Intentelo mas Tarde";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
                Mensaje += (" " + e.getMessage());
            }
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return usuario;
    }

    @Override
    public Usuario readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> readAll() {
        List<Usuario> lista = new ArrayList<Usuario>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT * "
                    + "FROM Usuario";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario usuario = getBean(rs);
                lista.add(usuario);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            String mensaje = "Se ha Producido un error, Intentelo mas Tarde";

        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public List<Usuario> readForCriteria(Usuario bean) {
        List<Usuario> lista = new ArrayList<Usuario>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT * "
                    + "FROM Usuario "
                    + "WHERE PATERNO like ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getPaterno() + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario usuario = getBean(rs);
                lista.add(usuario);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            String mensaje = "Se ha Producido un error, Intentelo mas Tarde";

        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public void insert(Usuario bean, String ruta) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String sql = "insert into Usuario(USUARIO,CONTRASEÑA,PATERNO,MATERNO,NOMBRE,DNI,TELEFONO,DIRECCION,EMAIL,TIPO,IMAGEN) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getUsuario());
            pstm.setString(2, bean.getContraseña());
            pstm.setString(3, bean.getPaterno());
            pstm.setString(4, bean.getMaterno());
            pstm.setString(5, bean.getNombre());
            pstm.setString(6, bean.getDni());
            pstm.setString(7, bean.getTelefono());
            pstm.setString(8, bean.getDireccion());
            pstm.setString(9, bean.getEmail());
            pstm.setString(10, bean.getTipo());
            File Imagen = new File(ruta);
            FileInputStream fis = new FileInputStream(Imagen);
            pstm.setBinaryStream(11, fis, (int) Imagen.length());
            pstm.executeUpdate();
            cn.commit();

        } catch (Exception e) {
            try {
                // Cancela Tx
                cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso. Intentelo mas tarde";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
                mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void update(Usuario bean, String ruta) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String sql = "UPDATE USUARIO "
                    + "SET CONTRASEÑA = ? , PATERNO = ? , MATERNO = ? , NOMBRE = ? , DNI = ? , TELEFONO = ? , DIRECCION = ? ,"
                    + " EMAIL = ? , TIPO = ? , IMAGEN = ?"
                    + "WHERE USUARIO = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getContraseña());
            pstm.setString(2, bean.getPaterno());
            pstm.setString(3, bean.getMaterno());
            pstm.setString(4, bean.getNombre());
            pstm.setString(5, bean.getDni());
            pstm.setString(6, bean.getTelefono());
            pstm.setString(7, bean.getDireccion());
            pstm.setString(8, bean.getEmail());
            pstm.setString(9, bean.getTipo());
            File Imagen = new File(ruta);
            FileInputStream fis = new FileInputStream(Imagen);
            pstm.setBinaryStream(10, fis, (int) Imagen.length());
            pstm.setString(11, bean.getUsuario());
            pstm.executeUpdate();
            cn.commit();

        } catch (Exception e) {
            try {
                // Cancela Tx
                cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso. Intentelo mas tarde";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
                mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void delete(Usuario bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String sql = "DELETE FROM USUARIO "
                    + "WHERE PATERNO like ? AND MATERNO like ? AND NOMBRE like ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getPaterno());
            pstm.setString(2, bean.getMaterno());
            pstm.setString(3, bean.getNombre());
            pstm.executeUpdate();
            cn.commit();
        } catch (Exception e) {
            try {
                // Cancela Tx
                cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso. Intentelo mas tarde";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
                mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(mensaje);
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
    private Image imagen;

    private Usuario getBean(ResultSet rs) throws SQLException, IOException {
        Usuario bean = new Usuario();
        bean.setUsuario(rs.getString("USUARIO"));
        bean.setContraseña(rs.getString("CONTRASEÑA"));
        bean.setPaterno(rs.getString("PATERNO"));
        bean.setMaterno(rs.getString("MATERNO"));
        bean.setNombre(rs.getString("NOMBRE"));
        bean.setDni(rs.getString("DNI"));
        bean.setTelefono(rs.getString("TELEFONO"));
        bean.setDireccion(rs.getString("DIRECCION"));
        bean.setEmail(rs.getString("EMAIL"));
        bean.setTipo(rs.getString("TIPO"));
        if (rs.getBytes("Imagen") != null) {
            byte[] b = rs.getBytes("Imagen");
            imagen = ConvertirImagen(b);
            bean.setImagen(imagen);
        }

        return bean;
    }

    private Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }

}
