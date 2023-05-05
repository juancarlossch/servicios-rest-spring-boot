package com.itsao.curso.services;

import javax.servlet.http.HttpServletRequest;

import com.itsao.curso.dtos.UsuariosDto;
import com.itsao.curso.responses.GenericResponse;

public interface UsuariosService {

    /**
     * Método para eliminar un usuario
     * @param name Cadena con el usuario a eliminar
     */
    public void delete(String name);

    /**
     * Métofo para buscar un usuario por nombre
     * @param name Cadena con el usuario a buscar
     * @return Objeto de tipo UsuariosDto
     */
    public UsuariosDto search(String name);

    /**
     * Método para retornar los datos del usuario logueado
     * @param req Parámetps de la sesión
     * @return Objeto de tipo UsuariosDto
     */
    public UsuariosDto whoami(HttpServletRequest req);

    /**
     * Método para guardar un nuevo usuario
     * @param userDto Objeto tipo UsuariosDto
     * @return Objeto de tipo GenericResponse
     */
    public GenericResponse save(UsuariosDto userDto);

}
