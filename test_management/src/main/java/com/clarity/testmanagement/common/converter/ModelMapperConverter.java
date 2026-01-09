package com.clarity.testmanagement.common.converter;

import com.clarity.testmanagement.common.model.ConfigBO;
import com.clarity.testmanagement.common.model.ConfigDTO;
import com.clarity.testmanagement.common.model.FeatureConfiguration;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ModelMapper-based converter for bidirectional BO/DTO conversion
 * Uses ModelMapper library for automatic field mapping with matching names
 */
public class ModelMapperConverter {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Convert any BO to DTO with matching field names
     */
    public static <D, B> D toDto(B bo, Class<D> dtoClass) {
        if (bo == null) {
            return null;
        }
        return modelMapper.map(bo, dtoClass);
    }

    /**
     * Convert any DTO to BO with matching field names
     */
    public static <B, D> B toBo(D dto, Class<B> boClass) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, boClass);
    }

    /**
     * Update existing BO from DTO (partial update)
     */
    public static <B, D> void updateBo(D dto, B bo) {
        if (dto == null || bo == null) {
            return;
        }
        modelMapper.map(dto, bo);
    }

    /**
     * Update existing DTO from BO (partial update)
     */
    public static <D, B> void updateDto(B bo, D dto) {
        if (bo == null || dto == null) {
            return;
        }
        modelMapper.map(bo, dto);
    }

    /**
     * Convert List of BOs to List of DTOs
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
     * Convert FeatureConfiguration BO to DTO with custom mapping
     */
    public static FeatureConfigurationDTO<ConfigDTO> toFeatureDto(FeatureConfiguration<ConfigBO> bo) {
        if (bo == null) {
            return null;
        }
        
        FeatureConfigurationDTO<ConfigDTO> dto = new FeatureConfigurationDTO<>();
        dto.setConfig(toDto(bo.getConfig(), ConfigDTO.class));
        dto.setEnabled(bo.isEnabled());
        dto.setDescription(bo.getDescription());
        return dto;
    }

    /**
     * Convert FeatureConfiguration DTO to BO with custom mapping
     */
    public static FeatureConfiguration<ConfigBO> toFeatureBo(FeatureConfigurationDTO<ConfigDTO> dto) {
        if (dto == null) {
            return null;
        }
        
        FeatureConfiguration<ConfigBO> bo = new FeatureConfiguration<>();
        bo.setConfig(toBo(dto.getConfig(), ConfigBO.class));
        bo.setEnabled(dto.isEnabled());
        bo.setDescription(dto.getDescription());
        return bo;
    }

    /**
     * Convert List of FeatureConfiguration BO to DTO
     */
    public static List<FeatureConfigurationDTO<ConfigDTO>> toFeatureDto(List<FeatureConfiguration<ConfigBO>> bos) {
        if (bos == null) {
            return null;
        }
        return bos.stream()
                .map(ModelMapperConverter::toFeatureDto)
                .collect(Collectors.toList());
    }

    /**
     * Convert List of FeatureConfiguration DTO to BO
     */
    public static List<FeatureConfiguration<ConfigBO>> toFeatureBo(List<FeatureConfigurationDTO<ConfigDTO>> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(ModelMapperConverter::toFeatureBo)
                .collect(Collectors.toList());
    }
}
