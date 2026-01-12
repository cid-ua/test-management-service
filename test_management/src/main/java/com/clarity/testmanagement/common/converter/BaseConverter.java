package com.clarity.testmanagement.common.converter;

import com.clarity.testmanagement.common.model.BaseBO;
import com.clarity.testmanagement.common.model.BaseDTO;
import com.clarity.testmanagement.common.model.FeatureConfiguration;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import com.clarity.testmanagement.common.model.PageResult;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic type-safe converter for BO/DTO conversion.
 * Each feature should create its own converter extending this class.
 * 
 * @param <B> Business Object type extending BaseBO
 * @param <D> Data Transfer Object type extending BaseDTO
 */
public abstract class BaseConverter<B extends BaseBO, D extends BaseDTO> {

    private final ModelMapper modelMapper;
    private final Class<B> boClass;
    private final Class<D> dtoClass;

    protected BaseConverter(Class<B> boClass, Class<D> dtoClass) {
        this.boClass = boClass;
        this.dtoClass = dtoClass;
        this.modelMapper = new ModelMapper();
        
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setCollectionsMergeEnabled(false)
                .setDeepCopyEnabled(true);
    }

    public D toDto(B bo) {
        if (bo == null) {
            return null;
        }
        return modelMapper.map(bo, dtoClass);
    }

    public B toBo(D dto) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, boClass);
    }

    public List<D> toDtoList(List<B> bos) {
        if (bos == null) {
            return null;
        }
        return bos.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<B> toBoList(List<D> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(this::toBo)
                .collect(Collectors.toList());
    }

    public FeatureConfigurationDTO<D> toFeatureDto(FeatureConfiguration<B> feature) {
        if (feature == null) {
            return null;
        }
        FeatureConfigurationDTO<D> dto = new FeatureConfigurationDTO<>();
        dto.setFeatureId(feature.getFeatureId());
        dto.setFeatureName(feature.getFeatureName());
        dto.setFeatureDescription(feature.getFeatureDescription());
        dto.setFeatureTitle(feature.getFeatureTitle());
        dto.setValidationErrors(feature.getValidationErrors());
        dto.setPageResult(toPageResultDto(feature.getPageResult()));
        return dto;
    }

    public FeatureConfiguration<B> toFeatureBo(FeatureConfigurationDTO<D> dto) {
        if (dto == null) {
            return null;
        }
        FeatureConfiguration<B> feature = new FeatureConfiguration<>();
        feature.setFeatureId(dto.getFeatureId());
        feature.setFeatureName(dto.getFeatureName());
        feature.setFeatureDescription(dto.getFeatureDescription());
        feature.setFeatureTitle(dto.getFeatureTitle());
        feature.setValidationErrors(dto.getValidationErrors());
        feature.setPageResult(toPageResultBo(dto.getPageResult()));
        return feature;
    }

    public PageResult<D> toPageResultDto(PageResult<B> source) {
        if (source == null) {
            return null;
        }
        PageResult<D> result = new PageResult<>();
        result.setItems(toDtoList(source.getItems()));
        result.setHasNext(source.isHasNext());
        result.setHasPrevious(source.isHasPrevious());
        result.setSize(source.getSize());
        result.setTotalRows(source.getTotalRows());
        result.setNextSortColumnValue(source.getNextSortColumnValue());
        result.setPreviousSortColumnValue(source.getPreviousSortColumnValue());
        return result;
    }

    public PageResult<B> toPageResultBo(PageResult<D> source) {
        if (source == null) {
            return null;
        }
        PageResult<B> result = new PageResult<>();
        result.setItems(toBoList(source.getItems()));
        result.setHasNext(source.isHasNext());
        result.setHasPrevious(source.isHasPrevious());
        result.setSize(source.getSize());
        result.setTotalRows(source.getTotalRows());
        result.setNextSortColumnValue(source.getNextSortColumnValue());
        result.setPreviousSortColumnValue(source.getPreviousSortColumnValue());
        return result;
    }

    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
