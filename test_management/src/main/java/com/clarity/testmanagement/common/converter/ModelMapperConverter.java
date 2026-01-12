package com.clarity.testmanagement.common.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.config.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperConverter {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        Configuration config = modelMapper.getConfiguration();
        
        config.setMatchingStrategy(MatchingStrategies.STRICT);
        config.setFieldMatchingEnabled(true);
        config.setSkipNullEnabled(true);
        config.setCollectionsMergeEnabled(false);
        config.setDeepCopyEnabled(true);
    }

    public static <D, B> D toDto(B bo, Class<D> dtoClass) {
        if (bo == null) {
            return null;
        }
        return modelMapper.map(bo, dtoClass);
    }

    public static <B, D> B toBo(D dto, Class<B> boClass) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, boClass);
    }

    public static <D, B> List<D> toDto(List<B> bos, Class<D> dtoClass) {
        if (bos == null) {
            return null;
        }
        return bos.stream()
                .map(bo -> toDto(bo, dtoClass))
                .collect(Collectors.toList());
    }

    public static <B, D> List<B> toBo(List<D> dtos, Class<B> boClass) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(dto -> toBo(dto, boClass))
                .collect(Collectors.toList());
    }

    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
