package cdu.jhb.manage.data.request;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.manage.data.dto.DepartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/30 21:34
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInfoRequest {

    private DepartmentDTO departmentAdd;

    private List<EmployeeDTO> departmentEmployeeList;

}
