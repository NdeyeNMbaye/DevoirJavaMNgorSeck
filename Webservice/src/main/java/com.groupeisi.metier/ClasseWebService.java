package com.groupeisi.metier;

import java.util.List;

import com.groupeisi.dto.ClasseDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface ClasseWebService {

    @WebMethod(operationName = "getClasse")
    ClasseDto get(@WebParam(name = "idClasse") Integer id); // Changement de int à Integer

    @WebMethod(operationName = "allClasses")
    List<ClasseDto> all();

    @WebMethod(operationName = "saveClasse")
    ClasseDto save(@WebParam(name = "classe") ClasseDto classeDto);

    @WebMethod(operationName = "updateClasse")
    boolean update(@WebParam(name = "classe") ClasseDto classeDto);

    @WebMethod(operationName = "deleteClasse")
    boolean delete(@WebParam(name = "idClasse") Integer id); // Changement de int à Integer
}