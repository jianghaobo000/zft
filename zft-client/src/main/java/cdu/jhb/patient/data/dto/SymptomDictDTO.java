package cdu.jhb.patient.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 症状字典DTO
* @author jhb
* @date 2023/2/20 22:01
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDictDTO {
    /**
     * 症状ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long symptomId;

    /**
     * 症状名
     */
    private String symptomName;
}
