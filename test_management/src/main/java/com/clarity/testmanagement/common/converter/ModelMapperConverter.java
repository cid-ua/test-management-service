package com.clarity.testmanagement.common.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.config.Configuration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ModelMapper-based converter for bidirectional BO/DTO conversion
 * Handles complex objects with nested structures and collections
 */
public class ModelMapperConverter {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        Configuration config = modelMapper.getConfiguration();
        
        // Configure for deep mapping and complex objects
        config.setMatchingStrategy(MatchingStrategies.STRICT);
        config.setFieldMatchingEnabled(true);
        config.setSkipNullEnabled(true);
        config.setCollectionsMergeEnabled(false); // Prevent merging, always replace
        config.setDeepCopyEnabled(true); // Enable deep copying for nested objects
    }

    /**
     * Convert any BO to DTO with matching field names
     * Handles complex nested objects and collections automatically
     */
    public static <D, B> D toDto(B bo, Class<D> dtoClass) {
        if (bo == null) {
            return null;
        }
        return modelMapper.map(bo, dtoClass);
    }

    /**
     * Convert any DTO to BO with matching field names
     * Handles complex nested objects and collections automatically
     */
    public static <B, D> B toBo(D dto, Class<B> boClass) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, boClass);
    }

    /**
     * Convert List of BOs to List of DTOs
     * Handles complex nested objects and collections automatically
     */
    public static <D, B> List<D> toDto(List<B> bos, Class<D> dtoClass) {
        if (bos == null) {
            return null;
        }
        return bos.stream()
                .map(bo -> toDto(bo, dtoClass))
                .collect(Collectors.toList());
    }

    /**
     * Convert List of DTOs to List of BOs
     * Handles complex nested objects and collections automatically
     */
    public static <B, D> List<B> toBo(List<D> dtos, Class<B> boClass) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(dto -> toBo(dto, boClass))
                .collect(Collectors.toList());
    }

    /**
     * Get the configured ModelMapper instance for custom mappings
     */
    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
