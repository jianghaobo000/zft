package cdu.jhb.domain.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 症状字典实体
* @author jhb
* @date 2023/2/21 11:25
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDict {
    /**
     * 症状ID
     */
    private Long symptom_id;

    /**
     * 症状名
     */
    private String symptom_name;
}
