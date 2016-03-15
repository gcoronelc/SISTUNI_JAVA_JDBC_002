package Proyecto.controller;

import Proyecto.Util.Memoria;
import Proyecto.service.AccesoService;
import Proyecto.domain.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import Proyecto.Util.Crud;

/**
 *
 * @author Josué Moreno
 */
public class AccesoController {

    AccesoService service;

    public AccesoController() {
        service = new AccesoService();
    }

    public void Validar(String U, String C) {
        Usuario usuario = new Usuario();
        usuario = service.validar(U, C);
        if (usuario == null) {
            throw new RuntimeException("Datos Incorrectos");
        } else {
            Memoria.put("usuario", usuario);
        }
    }

    public List<Usuario> readAll() {
        return service.readAll();
    }

    public List<Usuario> getClientes(Usuario bean) {
        return service.getClientes(bean);
    }

    public void grabar(Usuario bean, String accion,String ruta) {
        switch (accion) {
            case Crud.CRUD_NUEVO:
                service.insert(bean,ruta);
                break;
            case Crud.CRUD_EDITAR:
                service.update(bean,ruta);
                break;
            case Crud.CRUD_ELIMINAR:
                service.delete(bean);
                break;

        }
    }

}
