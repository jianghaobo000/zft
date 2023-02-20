package cdu.jhb.patient.dto.data;

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
    private Long symptom_id;
    private String symptom_name;
}
