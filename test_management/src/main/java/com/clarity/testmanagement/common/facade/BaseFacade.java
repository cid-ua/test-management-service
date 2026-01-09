package com.clarity.testmanagement.common.facade;

import com.clarity.testmanagement.common.converter.ModelMapperConverter;
import com.clarity.testmanagement.common.model.FeatureConfiguration;
import com.clarity.testmanagement.common.model.FeatureConfigurationDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BaseFacade<B extends FeatureConfiguration<?>, D extends FeatureConfigurationDTO<?>> {
    
    /**
     * Convert Business Object to Data Transfer Object
     */
    default D toDTO(B bo) {
        return (D) ModelMapperConverter.toFeatureDto((FeatureConfiguration<com.clarity.testmanagement.common.model.ConfigBO>) bo);
    }
    
    /**
     * Convert Data Transfer Object to Business Object
     */
    default B toBO(D dto) {
        return (B) ModelMapperConverter.toFeatureBo((FeatureConfigurationDTO<com.clarity.testmanagement.common.model.ConfigDTO>) dto);
    }
    
    /**
     * Convert List of Business Objects to List of Data Transfer Objects
     */
    default List<D> toDTO(List<B> bos) {
        return (List<D>) ModelMapperConverter.toFeatureDto((List<FeatureConfiguration<com.clarity.testmanagement.common.model.ConfigBO>>) bos);
    }
    
    /**
     * Convert List of Data Transfer Objects to List of Business Objects
     */
    default List<B> toBO(List<D> dtos) {
        return (List<B>) ModelMapperConverter.toFeatureBo((List<FeatureConfigurationDTO<com.clarity.testmanagement.common.model.ConfigDTO>>) dtos);
    }
    
    /**
     * Get the BO class type (to be implemented by specific facades)
     */
    Class<?> getBOClass();
    
    /**
     * Get the DTO class type (to be implemented by specific facades)
     */
    Class<?> getDTOClass();
}
