package com.groupeisi.mapper;

import com.groupeisi.dto.ClasseDto;
import com.groupeisi.entity.ClasseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClasseMapper {

    public static List<ClasseDto> listClasseEntityToListClasseDto(List<ClasseEntity> classes) {
        return classes.stream()
                .map(ClasseMapper::toClasseDto)
                .collect(Collectors.toList());
    }

    public static ClasseDto toClasseDto(ClasseEntity classe) {
        if (classe == null) return null;

        ClasseDto dto = new ClasseDto();
        dto.setId(classe.getId());
        dto.setClassName(classe.getClassName());
        dto.setDescription(classe.getDescription());
        // Vous pouvez ajouter le mapping du secteur ici si vous le souhaitez
        // dto.setSectorDto(SectorMapper.toSectorDto(classe.getSector()));

        return dto;
    }

    public static ClasseEntity toClasseEntity(ClasseDto dto) {
        if (dto == null) return null;

        ClasseEntity classe = new ClasseEntity();
        classe.setId(dto.getId());
        classe.setClassName(dto.getClassName());
        classe.setDescription(dto.getDescription());
        // Vous pouvez ajouter le mapping du secteur ici si vous le souhaitez
        // classe.setSector(SectorMapper.toSectorEntity(dto.getSectorDto()));

        return classe;
    }
}